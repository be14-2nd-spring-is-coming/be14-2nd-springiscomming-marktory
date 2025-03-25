package com.sic.marktory.member_template.query.controller;

import com.sic.marktory.member_template.query.dto.MemberTemplateDTO;
import com.sic.marktory.member_template.query.service.MemberTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberTemplateController {

    private final MemberTemplateService memberTemplateService;

    @Autowired
    public MemberTemplateController(MemberTemplateService memberTemplateService) {
        this.memberTemplateService = memberTemplateService;
    }

    // 특정 회원의 모든 템플릿 조회 (회원 본인)
    @PostMapping("/templates/{memberId}")
    @ResponseBody
    public List<MemberTemplateDTO> PostMemberTemplates(@PathVariable Long memberId) {
        return memberTemplateService.findMemberTemplates(memberId);
    }

    // 특정 회원의 공개된 템플릿 조회
    @GetMapping("/public/templates/{memberId}")
    @ResponseBody
    public List<MemberTemplateDTO> getMemberTemplatePublicAll(@PathVariable Long memberId) {
        return memberTemplateService.findMemberTemplatePublicAll(memberId);
    }
}
