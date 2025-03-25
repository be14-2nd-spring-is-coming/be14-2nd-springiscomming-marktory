package com.sic.marktory.member.service;

import com.sic.marktory.member.dto.MemberWithRoleDTO;
import com.sic.marktory.member.repository.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MemberVerifyServiceImpl implements MemberVerifyService {

    private MemberMapper memberMapper;

    @Autowired
    public MemberVerifyServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        // email 필드로 where절을 걸어서 조회하는 쿼리 메소드
        MemberWithRoleDTO loginMember = memberMapper.selectMemberWithRoleByEmail(email);
        log.info("loginMember={}", loginMember);
        if (loginMember == null) {
            throw new UsernameNotFoundException("이메일이 존재하지 않습니다: " + email);
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_MEMBER")); // 기본 권한

        if (loginMember.getRole() != null && !loginMember.getRole().isEmpty()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(loginMember.getRole()));
        }

        return new User(loginMember.getEmail(), loginMember.getPassword(),
                true,
                true,
                true,
                true, grantedAuthorities);

    }
}
