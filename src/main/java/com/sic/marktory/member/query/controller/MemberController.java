package com.sic.marktory.member.query.controller;

import com.sic.marktory.member.query.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("memberQueryController")
@RequestMapping("api/member")
public class MemberController {

    /* 설명. 로그인을 위한 조회 */
    private MemberService memberSerivce;

    @Autowired
    public MemberController(@Qualifier("queryMemberService") MemberService memberSerivce) {
        this.memberSerivce = memberSerivce;
    }

}
