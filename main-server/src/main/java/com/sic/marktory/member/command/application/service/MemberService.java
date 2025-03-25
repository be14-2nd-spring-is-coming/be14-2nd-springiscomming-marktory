package com.sic.marktory.member.command.application.service;

import com.sic.marktory.member.command.application.dto.MemberDTO;
import com.sic.marktory.common.exception.NickNameException;

public interface MemberService {

    void registMember(MemberDTO memberDTO) throws NickNameException;
}
