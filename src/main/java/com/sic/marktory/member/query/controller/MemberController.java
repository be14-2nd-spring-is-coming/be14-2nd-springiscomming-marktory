package com.sic.marktory.member.query.controller;

import com.sic.marktory.member.query.dto.MemberAndCommentDTO;
import com.sic.marktory.member.query.dto.MemberAndPostDTO;
import com.sic.marktory.member.query.dto.MemberAndTemplateDTO;
import com.sic.marktory.member.query.dto.MemberPageDTO;
import com.sic.marktory.member.query.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("memberQueryController")
@RequestMapping("api/member")
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(@Qualifier("queryMemberService") MemberService memberService) {
        this.memberService = memberService;
    }

    /* 설명. 회원 페이지 조회 */
    @GetMapping("mypage/{memberId}")
    public ResponseEntity<MemberPageDTO> getMembers(@PathVariable Long memberId) {
        MemberPageDTO memberPageDTO = memberService.findById(memberId);
        return ResponseEntity.status(HttpStatus.OK).body(memberPageDTO);
    }

    /* 설명. 회원 페이지에서 내가 작성한 게시글 조회 */
    @GetMapping("mypage/{memberId}/my-post")
    public ResponseEntity<List<MemberAndPostDTO>> getMemberAndPosts(@PathVariable Long memberId) {
        List<MemberAndPostDTO> resultSet = memberService.findByIdAndPost(memberId);
        log.info(resultSet.toString());
        return ResponseEntity.status(HttpStatus.OK).body(resultSet);
    }
    /* 설명. 회원 페이지에서 내가 작성한 댓글 조회 */
    @GetMapping("mypage/{memberId}/my-comment")
    public ResponseEntity<List<MemberAndCommentDTO>> getMemberAndComoments(@PathVariable Long memberId){
        List<MemberAndCommentDTO> resultSet = memberService.findByIdAndComment(memberId);
        log.info(resultSet.toString());
        return ResponseEntity.status(HttpStatus.OK).body(resultSet);
    }
    /* 설명. 회원 페이지에서 내 템플릿 저장소 확인 */
    @GetMapping("mypage/{memberId}/member-template")
    public ResponseEntity<List<MemberAndTemplateDTO>> getMemberTemplates(@PathVariable Long memberId) {
        List<MemberAndTemplateDTO> resultSet = memberService.findByIdAndTemplate(memberId);
        return ResponseEntity.status(HttpStatus.OK).body(resultSet);
    }

    /* 설명. 회원 페이지에서 내 게시글에 달린 댓글 확인 */
}
