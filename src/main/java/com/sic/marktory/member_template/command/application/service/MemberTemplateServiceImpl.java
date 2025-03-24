package com.sic.marktory.member_template.command.application.service;

import com.sic.marktory.member_template.command.application.dto.MemberTemplateCreateRequest;
import com.sic.marktory.member_template.command.application.entity.MemberTemplateEntity;
import com.sic.marktory.member_template.command.application.vo.Visibility;
import com.sic.marktory.member_template.command.domain.repository.MemberTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;

@Service("MemberTemplateCommandServiceImpl")
@RequiredArgsConstructor
public class MemberTemplateServiceImpl implements MemberTemplateService {

    private final MemberTemplateRepository memberTemplateRepository;

    @Override
    @Transactional
    public Long createMemberTemplate(MemberTemplateCreateRequest request) {
        MemberTemplateEntity template = MemberTemplateEntity.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .writtenDate(Date.from(Instant.now()).toString())
                .visibility(new Visibility(request.getVisibility()))
                .usageCount(0)
                .isCopy('N')
                // TODO : 회원의 id를 받아서 생성해야 함. 현재는 command 구조 테스트를 위한 코드임.
                .repositoryId(request.getRepositoryId())
                .build();

        return memberTemplateRepository.save(template).getId();
    }
}
