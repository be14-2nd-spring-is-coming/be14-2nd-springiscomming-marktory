package com.sic.marktory.member_template.query.controller;

import com.sic.marktory.member_template.query.dto.MemberTemplateDTO;
import com.sic.marktory.member_template.query.service.MemberTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberTemplateController {

    private final MemberTemplateService memberTemplateService;

    @Autowired
    public MemberTemplateController(MemberTemplateService memberTemplateService) {
        this.memberTemplateService = memberTemplateService;
    }

    @GetMapping("/public/templates")
    @ResponseBody
    public List<MemberTemplateDTO> getMemberTemplates() {
        return memberTemplateService.findMemberTemplatePublicAll();
    }
}
