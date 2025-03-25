package com.sic.marktory.comment.command.application.service;

import com.sic.marktory.comment.command.domain.aggregate.CommentEntity;
import com.sic.marktory.comment.command.domain.repository.CommentRepository;
import com.sic.marktory.common.DateTimeUtil;
import com.sic.marktory.member.command.application.service.MailServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = {
        "springdoc.api-docs.enabled=false",
        "springdoc.swagger-ui.enabled=false"
})
@Transactional
class CommentServiceTest {

    @Autowired
    private CommentRepository commentRepository;

    @MockBean
    private MailServiceImpl mailService;

    @Test
    void 댓글_등록_테스트() {

        // Given
        CommentEntity comment = CommentEntity.builder()
                .postId(1L)
                .memberId(5L)
                .content("댓글 등록 테스트")
                .writtenDate(DateTimeUtil.nowFormatted())
                .modifyDate(DateTimeUtil.nowFormatted())
                .isDeleted(false)
                .type(1)
                .aboveId(null)
                .build();

        CommentEntity saved = commentRepository.save(comment);

        // When
        CommentEntity found = commentRepository.findById(saved.getId()).orElse(null);

        // Then
        assertNotNull(found);
        assertEquals("댓글 등록 테스트", found.getContent());
        assertEquals(1L, found.getPostId());
        assertEquals(5L, found.getMemberId());

    }

    @Test
    void 댓글_수정_테스트() {

        // Given
        CommentEntity comment = CommentEntity.builder()
                .postId(1L)
                .memberId(5L)
                .content("수정 전 댓글")
                .writtenDate(DateTimeUtil.nowFormatted())
                .modifyDate(DateTimeUtil.nowFormatted())
                .isDeleted(false)
                .type(1)
                .aboveId(null)
                .build();

        CommentEntity saved = commentRepository.save(comment);

        // When
        saved.updateContent("댓글 수정 테스트");
        commentRepository.flush();

        // Then
        CommentEntity found = commentRepository.findById(saved.getId()).orElse(null);
        assertNotNull(found);
        assertEquals("댓글 수정 테스트", found.getContent());
        assertEquals(1L, found.getPostId());
        assertEquals(5L, found.getMemberId());
        System.out.println(saved.getId());

    }

    @Test
    void 댓글_삭제_테스트() {

        // Given
        CommentEntity comment = CommentEntity.builder()
                .postId(1L)
                .memberId(5L)
                .content("삭제 전 댓글")
                .writtenDate(DateTimeUtil.nowFormatted())
                .modifyDate(DateTimeUtil.nowFormatted())
                .isDeleted(false)
                .type(1)
                .aboveId(null)
                .build();

        CommentEntity saved = commentRepository.save(comment);

        // When
        saved.softDelete();
        commentRepository.flush();

        // Then
        CommentEntity found = commentRepository.findById(saved.getId()).orElse(null);
        assertNotNull(found);
        assertEquals("삭제 전 댓글", found.getContent());
        assertEquals(true, found.getIsDeleted());
        assertEquals(1L, found.getPostId());
        assertEquals(5L, found.getMemberId());

    }

}