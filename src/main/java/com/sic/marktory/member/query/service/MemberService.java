package com.sic.marktory.member.query.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {
    UserDetails loadUserByUsername(String email);
}
