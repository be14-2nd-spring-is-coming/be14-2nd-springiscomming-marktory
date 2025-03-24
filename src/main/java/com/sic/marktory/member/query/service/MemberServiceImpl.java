package com.sic.marktory.member.query.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service("queryMemberService")
public class MemberServiceImpl implements MemberService {

    @Override
    public UserDetails loadUserByUsername(String email) {
        return null;
    }
}
