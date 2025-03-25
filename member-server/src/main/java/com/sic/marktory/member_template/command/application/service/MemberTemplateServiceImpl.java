package com.sic.marktory.member_template.command.application.service;

import com.sic.marktory.common.DateTimeUtil;
import com.sic.marktory.common.MarkdownUtil;
import com.sic.marktory.member_template.command.application.dto.MemberTemplateCreateRequest;
import com.sic.marktory.member_template.command.application.dto.MemberTemplateUpdateRequest;
import com.sic.marktory.member_template.command.domain.aggregate.MemberTemplateEntity;
import com.sic.marktory.member_template.command.application.vo.Visibility;
import com.sic.marktory.member_template.command.domain.repository.MemberTemplateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("MemberTemplateCommandServiceImpl")
@RequiredArgsConstructor
@Slf4j
public class MemberTemplateServiceImpl implements MemberTemplateService {

    private final MemberTemplateRepository memberTemplateRepository;

    // 회원이 템플릿을 작성
    @Override
    @Transactional
    public String createMemberTemplate(MemberTemplateCreateRequest request) {
        String html ="<body><html>" + MarkdownUtil.toHtml(request.getContent()) + "</body></html>";

        MemberTemplateEntity template = MemberTemplateEntity.builder()
                .title(request.getTitle())
                .content(html)
                .writtenDate(DateTimeUtil.nowFormatted())
                .visibility(new Visibility(request.getVisibility()))
                .usageCount(0)
                .isCopy('N')
                // TODO : 회원의 id를 받아서 생성해야 함. 현재는 command 구조 테스트를 위한 코드임.
                .repositoryId(request.getRepositoryId())
                .build();

        memberTemplateRepository.save(template);

        return html;
    }

    // 회원이 특정 템플릿을 수정
    @Override
    @Transactional
    public void updateMemberTemplate(Long id, MemberTemplateUpdateRequest request) {
        MemberTemplateEntity template = memberTemplateRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Template not found with id: " + id));

        log.info("Updating member template with id : " + template + ", id : "+ id);

        template.update(
                request.getTitle(),
                request.getContent(),
                new Visibility(request.getVisibility()),
                DateTimeUtil.nowFormatted()
        );

        log.info("Updating member template with id : " + template + ", id : "+ id);
    }

    @Override
    @Transactional
    public void deleteMemberTemplate(Long id) {
        MemberTemplateEntity template = memberTemplateRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Template not found with id: " + id));

        template.delete();

        log.info("Updating member template with id : " + template + ", id : "+ id);
    }

}
