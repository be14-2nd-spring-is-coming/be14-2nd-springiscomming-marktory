package com.sic.marktory.member.query.service;

import com.sic.marktory.member.query.dto.MemberAndCommentDTO;
import com.sic.marktory.member.query.dto.MemberAndPostDTO;
import com.sic.marktory.member.query.dto.MemberAndTemplateDTO;
import com.sic.marktory.member.query.dto.MemberPageDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface MemberService extends UserDetailsService {
    UserDetails loadUserByUsername(String email);

    MemberPageDTO findById(Long memberId);

    List<MemberAndPostDTO> findByIdAndPost(Long memberId);

    List<MemberAndCommentDTO> findByIdAndComment(Long memberId);

    List<MemberAndTemplateDTO> findByIdAndTemplate(Long memberId);
}
