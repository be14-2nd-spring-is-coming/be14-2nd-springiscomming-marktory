package com.sic.marktory.member_template.query.controller;

import com.sic.marktory.member_template.query.dto.MemberTemplateDTO;
import com.sic.marktory.member_template.query.service.MemberTemplateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Member Template Query", description = "템플릿 조회")
@RestController
@RequestMapping("api/member")
public class MemberTemplateController {

    private final MemberTemplateService memberTemplateService;

    @Autowired
    public MemberTemplateController(MemberTemplateService memberTemplateService) {
        this.memberTemplateService = memberTemplateService;
    }

    // 특정 회원의 공개된 템플릿 조회
    @Operation(
            summary = "특정 회원의 공개 템플릿 조회",
            description = """
        특정 회원이 공개 설정한 템플릿만 조회합니다.
        - 로그인하지 않은 사용자도 접근 가능한 공개용 템플릿 API입니다.
        - HTTP GET 메서드를 사용하며, 회원 ID는 경로 변수로 전달됩니다.
        """
    )
    @GetMapping("/public/templates/{memberId}")
    @ResponseBody
    public List<MemberTemplateDTO> getMemberTemplatePublicAll(@PathVariable Long memberId) {
        return memberTemplateService.findMemberTemplatePublicAll(memberId);
    }

    // 특정 회원의 모든 템플릿 조회 (회원 본인)
    @Operation(
            summary = "특정 회원의 템플릿 조회",
            description = """
        특정 회원이 작성한 모든 템플릿을 조회합니다.
        - 비공개 템플릿을 포함하며, 요청자는 해당 회원 본인이어야 합니다.
        - HTTP POST 방식으로 호출되며, 회원 ID는 경로 변수로 전달됩니다.
        """
    )
    @PostMapping("/templates/{memberId}")
    @ResponseBody
    public List<MemberTemplateDTO> PostMemberTemplates(@PathVariable Long memberId) {
        return memberTemplateService.findMemberTemplates(memberId);
    }
}
