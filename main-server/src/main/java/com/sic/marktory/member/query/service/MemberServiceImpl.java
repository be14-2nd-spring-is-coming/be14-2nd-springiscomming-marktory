package com.sic.marktory.member.query.service;

import com.sic.marktory.member.query.dto.*;
import com.sic.marktory.member.query.mapper.AuthorityMapper;
import com.sic.marktory.member.query.mapper.MemberMapper;
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

@Service("queryMemberService")
@Slf4j
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;
    private final AuthorityMapper authorityMapper;

    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper, AuthorityMapper authorityMapper) {
        this.memberMapper = memberMapper;
        this.authorityMapper = authorityMapper;
    }

    /* 설명. spring security 사용 시 프로바이더에서 활용할
        로그인용 메소드(id로 회원 조회해서 UserDetails 타입을 반환하는 메소드) */
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

    @Override
    public MemberPageDTO findById(Long memberId) {
        return memberMapper.selectById(memberId);
    }

    /* 설명. 마이페이지에서 내가 작성한 게시글 조회 완료 */
    @Override
    public List<MemberAndPostDTO> findByIdAndPost(Long memberId) {
        List<MemberAndPostDTO> resultSet = memberMapper.selectByIdAndPost(memberId);
        return resultSet;
    }

    @Override
    public List<MemberAndCommentDTO> findByIdAndComment(Long memberId) {
        List<MemberAndCommentDTO> resultSet = memberMapper.selectByIdAndComment(memberId);
        return resultSet;
    }

    @Override
    public List<MemberAndTemplateDTO> findByIdAndTemplate(Long memberId) {
        List<MemberAndTemplateDTO> resultSet = memberMapper.selectByIdAndTemplate(memberId);
        return resultSet;
    }

}
