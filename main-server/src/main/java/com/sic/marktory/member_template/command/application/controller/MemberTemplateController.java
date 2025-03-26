package com.sic.marktory.member_template.command.application.controller;

import com.sic.marktory.member_template.command.application.dto.MemberTemplateCreateRequest;
import com.sic.marktory.member_template.command.application.dto.MemberTemplateUpdateRequest;
import com.sic.marktory.member_template.command.application.service.MemberTemplateServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Member Template Command", description = "작성, 수정, 삭제")
@RestController("MemberTemplateCommandController")
@RequestMapping("api/member-template")
@RequiredArgsConstructor
public class MemberTemplateController {

    private final MemberTemplateServiceImpl memberTemplateService;

    // TODO: 템플릿을 작성할 때 회원의 id가 필요. 이 코드에서는 테스트를 위해서 임의로 설정
    // TODO: request 값이 null 인 경우의 처리 필요
    @Operation(
            summary = "회원 템플릿 작성",
            description = """
        회원이 개인 템플릿을 새로 생성합니다.
        - 작성자는 request body에 포함된 회원 ID 정보로 전달됩니다.
        - 작성된 템플릿 HTML이 문자열 형태로 응답 본문에 포함되어 반환됩니다.
        - Content-Type은 `text/html`입니다.
        """
    )
    @PostMapping()
    public ResponseEntity<String> postCreateMemberTemplate(@RequestBody MemberTemplateCreateRequest request) {
        String result = memberTemplateService.createMemberTemplate(request);
        return ResponseEntity.ok()
                .header("Content-Type", "text/html").body(result);
    }

    @Operation(
            summary = "회원 템플릿 수정",
            description = """
        기존에 작성된 템플릿을 수정합니다.
        - 템플릿의 식별자(ID)는 URL path에서 전달됩니다.
        - 수정할 내용은 request body에 포함된 정보를 기반으로 적용됩니다.
        - 성공 시 200 OK 응답만 반환하며, 응답 본문은 없습니다.
        """
    )
    @PutMapping("/{id}")
    public ResponseEntity<Long> putUpdateMemberTemplate(@PathVariable Long id, @RequestBody MemberTemplateUpdateRequest request) {
        memberTemplateService.updateMemberTemplate(id, request);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "회원 템플릿 삭제",
            description = """
        특정 템플릿을 삭제합니다.
        - 템플릿의 ID는 URL path를 통해 전달됩니다.
        - 삭제 성공 시 200 OK 응답만 반환합니다.
        - 실제 삭제 방식(소프트/하드)은 서비스 로직에 따라 달라집니다.
        """
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteMemberTemplate(@PathVariable Long id) {
        memberTemplateService.deleteMemberTemplate(id);
        return ResponseEntity.ok().build();
    }

}
