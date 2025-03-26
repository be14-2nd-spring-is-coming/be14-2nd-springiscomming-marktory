package com.sic.marktory.member.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface MemberVerifyService {
    UserDetails loadUserByUsername(String subject);
}
