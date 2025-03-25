package com.sic.marktory.member.query.controller;

import com.sic.marktory.member.query.dto.MemberAndCommentDTO;
import com.sic.marktory.member.query.dto.MemberAndPostDTO;
import com.sic.marktory.member.query.dto.MemberAndTemplateDTO;
import com.sic.marktory.member.query.dto.MemberPageDTO;
import com.sic.marktory.member.query.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "Member Query", description = "정보 조회, 게시글 조회, 댓글 조회")
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
    @Operation(
            summary = "회원 페이지 조회",
            description = """
        회원 ID를 기반으로 해당 사용자의 마이페이지 정보를 조회합니다.
        - 기본적인 회원 정보, 활동 요약 정보 등을 포함합니다.
        """
    )
    @GetMapping("mypage/{memberId}")
    public ResponseEntity<MemberPageDTO> getMembers(@PathVariable Long memberId) {
        MemberPageDTO memberPageDTO = memberService.findById(memberId);
        return ResponseEntity.status(HttpStatus.OK).body(memberPageDTO);
    }

    /* 설명. 회원 페이지에서 내가 작성한 게시글 조회 */
    @Operation(
            summary = "회원 페이지에서 내 게시글 조회",
            description = """
        특정 회원이 작성한 게시글 목록을 조회합니다.
        - 회원 ID를 기반으로 필터링된 게시글 데이터를 반환합니다.
        """
    )
    public ResponseEntity<List<MemberAndPostDTO>> getMemberAndPosts(@PathVariable Long memberId) {
        List<MemberAndPostDTO> resultSet = memberService.findByIdAndPost(memberId);
        log.info(resultSet.toString());
        return ResponseEntity.status(HttpStatus.OK).body(resultSet);
    }
    /* 설명. 회원 페이지에서 내가 작성한 댓글 조회 */
    @Operation(
            summary = "회원 페이지에서 내 댓글 조회",
            description = """
        특정 회원이 작성한 댓글 목록을 조회합니다.
        - 회원 ID를 기준으로 필터링된 댓글 정보를 반환합니다.
        """
    )
    @GetMapping("mypage/{memberId}/my-comment")
    public ResponseEntity<List<MemberAndCommentDTO>> getMemberAndComoments(@PathVariable Long memberId){
        List<MemberAndCommentDTO> resultSet = memberService.findByIdAndComment(memberId);
        log.info(resultSet.toString());
        return ResponseEntity.status(HttpStatus.OK).body(resultSet);
    }
    /* 설명. 회원 페이지에서 내 템플릿 저장소 확인 */
    @Operation(
            summary = "회원 페이지에서 내 템플릿 조회",
            description = """
        회원이 보유한 템플릿 저장소의 템플릿 목록을 조회합니다.
        - 템플릿은 작성자가 구독자에게 공개하거나 개인적으로 보관한 내용입니다.
        """
    )
    @GetMapping("mypage/{memberId}/member-template")
    public ResponseEntity<List<MemberAndTemplateDTO>> getMemberTemplates(@PathVariable Long memberId) {
        List<MemberAndTemplateDTO> resultSet = memberService.findByIdAndTemplate(memberId);
        return ResponseEntity.status(HttpStatus.OK).body(resultSet);
    }

    /* 설명. 회원 페이지에서 내 게시글에 달린 댓글 확인 */
}
