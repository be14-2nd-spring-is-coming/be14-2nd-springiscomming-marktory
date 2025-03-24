package com.sic.marktory.member.command.application.service;

import com.sic.marktory.member.command.application.dto.MemberDTO;
import com.sic.marktory.member.command.domain.aggregate.entity.EmailTokenEntity;
import com.sic.marktory.member.command.domain.aggregate.entity.MemberEntity;
import com.sic.marktory.member.command.domain.repository.EmailRepository;
import com.sic.marktory.member.command.domain.repository.MemberRepository;
import com.sic.marktory.member.common.exception.NickNameException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;
    private EmailRepository emailRepository;
    private ModelMapper modelMapper;
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository,
                             EmailRepository emailRepository,
                             ModelMapper modelMapper) {
        this.memberRepository = memberRepository;
        this.emailRepository = emailRepository;
        this.modelMapper = modelMapper;
    }

    /* 설명. 회원가입 실행 */
    @Override
    @Transactional
    public void registMember(MemberDTO memberDTO) throws NickNameException {
        /* 설명. insert가 일어나기 위해서는, 인증이 되었는지 상태를 봐야함 */
        /* 설명. 인증 상태 확인 */
        EmailTokenEntity foundEmailTokenEntity = emailRepository.findByEmail(memberDTO.getEmail());
        if (foundEmailTokenEntity.getEmail() == null) {
            log.info("인증되지 않은 이메일입니다.");
        }

        /* 설명. 회원 닉네임 중복 확인 */
        /* 설명. 별도 예외처리 안하면 500 서버 에러 발생 */
        MemberEntity newMemberEntity = modelMapper.map(memberDTO, MemberEntity.class);
        MemberEntity nicknameFound = memberRepository.findByNickname(newMemberEntity.getNickname());
        if (nicknameFound != null) {
            log.info(nicknameFound.getNickname());
            throw new NickNameException("해당 닉네임은 존재하고 있는 닉네임입니다.");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        newMemberEntity.setAssignedDate(LocalDateTime.now().format(formatter));
        memberRepository.save(newMemberEntity);
    }
}
