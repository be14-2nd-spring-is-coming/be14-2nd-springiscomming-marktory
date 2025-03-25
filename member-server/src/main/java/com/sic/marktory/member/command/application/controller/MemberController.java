package com.sic.marktory.member.command.application.controller;

import com.sic.marktory.member.command.application.dto.EmailTokenDTO;
import com.sic.marktory.member.command.application.dto.EmailTokenVerifyDTO;
import com.sic.marktory.member.command.application.dto.MemberDTO;
import com.sic.marktory.member.command.application.service.MailService;
import com.sic.marktory.member.command.application.service.MemberService;
import com.sic.marktory.member.command.domain.aggregate.vo.*;
<<<<<<< Updated upstream:src/main/java/com/sic/marktory/member/command/application/controller/MemberController.java
import com.sic.marktory.member.common.exception.NickNameException;
import com.sic.marktory.member.common.exception.TokenAlreadyVerifiedException;
import com.sic.marktory.member.common.exception.TokenExpiredException;
import com.sic.marktory.member.common.exception.TokenNotFoundException;
<<<<<<< Updated upstream:member-server/src/main/java/com/sic/marktory/member/command/application/controller/MemberController.java
=======
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
=======
import com.sic.marktory.common.exception.NickNameException;
import com.sic.marktory.common.exception.TokenAlreadyVerifiedException;
import com.sic.marktory.common.exception.TokenExpiredException;
import com.sic.marktory.common.exception.TokenNotFoundException;
>>>>>>> Stashed changes:member-server/src/main/java/com/sic/marktory/member/command/application/controller/MemberController.java
>>>>>>> Stashed changes:src/main/java/com/sic/marktory/member/command/application/controller/MemberController.java
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
public class MemberController {
    private final ModelMapper modelMapper;
    private MemberService memberService;
    private MailService mailService;
    private ModelMapper mapper;
    private Environment env;

    @Autowired
    public MemberController(MemberService memberService, MailService mailService , ModelMapper mapper, Environment env, ModelMapper modelMapper) {
        this.memberService = memberService;
        this.mailService = mailService;
        this.mapper = mapper;
        this.env = env;
        this.modelMapper = modelMapper;
    }

    /* 설명. 이메일 전송(API)
     *  흐름 -> 이메일 전송, 응답으로 토큰 값 전송, 토큰 값을 기준으로 프론트에서 요청-> 백엔드에서 요청 확인
     *  토큰값이 일치 시 -> 회원가입 폼으로 이동시켜 줌
    * */
    @PostMapping("/signup-email")
    public ResponseEntity<ResponseEmailVO> postSignupEmail(@RequestBody RequestEmailVO email) {

        EmailTokenDTO emailTokenDTO = modelMapper.map(email, EmailTokenDTO.class);
        mailService.sendVerificationEmail(emailTokenDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseEmailVO(emailTokenDTO.getEmail(),
                        emailTokenDTO.getToken(),
                        "이메일이 전송되었습니다."));
    }

    /* 설명. 이메일 토큰 확인
     *  커스텀 예외를 사용해서, 발생시키기
    * */
    @PostMapping("/signup-email/verification")
    public ResponseEntity<ResponseVerifyTokenVO> postEmailVerification(@RequestBody RequestVerifyTokenVO verifyMemberInfo) {

        EmailTokenVerifyDTO emailTokenVerifyDTO = mapper.map(verifyMemberInfo, EmailTokenVerifyDTO.class);
        emailTokenVerifyDTO.setToken(verifyMemberInfo.getToken());

        try {
            mailService.verifyToken(emailTokenVerifyDTO);
            ResponseVerifyTokenVO responseVerifyTokenVO =
                    new ResponseVerifyTokenVO("인증이 완료되었습니다.");
            return ResponseEntity.status(HttpStatus.OK).body(responseVerifyTokenVO);
        } catch (TokenNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ResponseVerifyTokenVO(e.getMessage()));
        } catch (TokenExpiredException e) {
            return ResponseEntity
                    .status(HttpStatus.GONE)
                    .body(new  ResponseVerifyTokenVO(e.getMessage()));
        } catch (TokenAlreadyVerifiedException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new ResponseVerifyTokenVO(e.getMessage()));
        }
    }

    /* 설명. 이메일 토큰 확인이 완료되었다? 회원가입 */
    @PostMapping("/signup")
    public ResponseEntity<?> postSingup(@RequestBody RequestSignupVO signupVO) {
        MemberDTO memberDTO = mapper.map(signupVO, MemberDTO.class);
        try {
            memberService.registMember(memberDTO);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new ResponseSignupVO(memberDTO.getNickname(),
                            "회원가입이 완료되었습니다! 환영합니다!"));
        } catch (NickNameException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new NickNameException(e.getMessage()));
        }
    }
}
