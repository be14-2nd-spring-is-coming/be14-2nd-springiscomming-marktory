package com.sic.marktory.member.command.application.service;

import com.sic.marktory.member.command.application.dto.EmailTokenDTO;
import com.sic.marktory.member.command.application.dto.MemberDTO;
import com.sic.marktory.member.common.exception.NickNameException;
import com.sic.marktory.member.query.dto.MemberPageDTO;

import java.time.LocalDateTime;

public interface MemberService {

    void registMember(MemberDTO memberDTO) throws NickNameException;
}
