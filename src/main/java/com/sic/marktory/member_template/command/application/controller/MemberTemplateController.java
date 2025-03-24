package com.sic.marktory.member_template.command.application.controller;

import com.sic.marktory.member_template.command.application.dto.MemberTemplateCreateRequest;
import com.sic.marktory.member_template.command.application.dto.MemberTemplateUpdateRequest;
import com.sic.marktory.member_template.command.application.service.MemberTemplateServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("MemberTemplateCommandController")
@RequestMapping("/member-template")
@RequiredArgsConstructor
public class MemberTemplateController {

    private final MemberTemplateServiceImpl memberTemplateService;

    // TODO: 템플릿을 작성할 때 회원의 id가 필요. 이 코드에서는 테스트를 위해서 임의로 설정
    // TODO: request 값이 null 인 경우의 처리 필요
    @PostMapping()
    public ResponseEntity<Long> postCreateMemberTemplate(@RequestBody MemberTemplateCreateRequest request) {
        Long id = memberTemplateService.createMemberTemplate(request);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> putUpdateMemberTemplate(@PathVariable Long id, @RequestBody MemberTemplateUpdateRequest request) {
        memberTemplateService.updateMemberTemplate(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> pubDeleteMemberTemplate(@PathVariable Long id) {
        memberTemplateService.deleteMemberTemplate(id);
        return ResponseEntity.ok().build();
    }

}
