package com.sic.marktory.member.command.application.service;

import com.sic.marktory.member.command.application.dto.EmailTokenDTO;
import com.sic.marktory.member.command.application.dto.EmailTokenVerifyDTO;
import com.sic.marktory.member.command.domain.aggregate.entity.EmailTokenEntity;
import com.sic.marktory.member.command.domain.repository.EmailRepository;
import com.sic.marktory.member.common.MailTemplate;
import com.sic.marktory.member.common.exception.TokenAlreadyVerifiedException;
import com.sic.marktory.member.common.exception.TokenExpiredException;
import com.sic.marktory.member.common.exception.TokenNotFoundException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Slf4j
public class MailServiceImpl implements MailService {

    private JavaMailSender javaMailSender;
    private MailTemplate mailTemplate;
    private ModelMapper modelMapper;
    private EmailRepository emailRepository;

    @Autowired
    public MailServiceImpl(JavaMailSender javaMailSender,
                           MailTemplate mailTemplate,
                           ModelMapper modelMapper,
                           EmailRepository emailRepository) {
        this.javaMailSender = javaMailSender;
        this.mailTemplate = mailTemplate;
        this.modelMapper = modelMapper;
        this.emailRepository = emailRepository;
    }

    /* 설명. 이메일 전송을 위한 코드 */
    @Override
    @Transactional
    public void sendVerificationEmail(EmailTokenDTO emailTokenDTO){
        /* 설명. 토큰 생성 + 이메일 전송 */
        String verificationTokenCode = UUID.randomUUID().toString();
        LocalDateTime expiredTime = LocalDateTime.now().plusMinutes(10);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setTo(emailTokenDTO.getEmail());
            helper.setFrom("marktory@gmail.com", "Marktory_관리자팀");
            helper.setSubject("MarkTory 회원가입 인증 이메일 입니다 !");
            String link = "http://www.naver.com";
            String htmlContent = mailTemplate.sendSignUpEamil(link);
            helper.setText(htmlContent, true);

            javaMailSender.send(mimeMessage);

            /* 설명. Token 생성한 값을 별도로 DB에 저장 */
            emailTokenDTO.setToken(verificationTokenCode);
            emailTokenDTO.setExpirationTime(expiredTime);
            registMailInfo(emailTokenDTO);
        } catch (MessagingException e) {
            log.info("이메일 전송 오류 발생");
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            log.info("인코딩 오류 ?");
            throw new RuntimeException(e);
        }
    }

    /* 설명. 이메일 정보 토큰 저장 */
    @Override
    @Transactional
    public void registMailInfo(EmailTokenDTO emailTokenDTO) {
        EmailTokenEntity emailTokenEntity = modelMapper.map(emailTokenDTO, EmailTokenEntity.class);
        emailRepository.save(emailTokenEntity);
    }

    /* 설명. 이메일 토큰 인증 후, 상태 값 변동을 해주는 메소드
     *  커스텀 예외를 사용하여, responseVo에 message만 넣을 것
    * */
    @Override
    @Transactional
    public void verifyToken(EmailTokenVerifyDTO emailTokenVerifyDTO) throws TokenNotFoundException,
            TokenExpiredException, TokenAlreadyVerifiedException {
        EmailTokenEntity foundEmailTokenEntity = emailRepository.findByToken(emailTokenVerifyDTO.getToken());

        if (foundEmailTokenEntity == null) {
            throw new TokenNotFoundException("토큰이 일치하지 않습니다.");
        }

        if (foundEmailTokenEntity.getExpirationTime().isBefore(LocalDateTime.now())) {
            throw new TokenExpiredException("토큰 시간이 만료되었습니다. 다시 요청을 보내주세요.");
        }

        if (foundEmailTokenEntity.isVerified()) {
            throw new TokenAlreadyVerifiedException("이미 가입되어 있는 계정입니다.");
        }
        foundEmailTokenEntity.setVerified(true);
        emailTokenVerifyDTO.setVerified(true);
        emailTokenVerifyDTO.setVerifyMessage("이메일 인증에 성공하였습니다.");

        emailRepository.save(foundEmailTokenEntity);
    }

}
