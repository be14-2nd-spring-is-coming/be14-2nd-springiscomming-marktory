package com.sic.marktory.comment.query.mapper;

import com.sic.marktory.comment.query.dto.CommentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = {
        "springdoc.api-docs.enabled=false",
        "springdoc.swagger-ui.enabled=false"
})
class CommentMapperTest {

    @Autowired
    private CommentMapper commentMapper;

    @Test
    void 댓글_조회_테스트() {

        // Given

        // When
        List<CommentDTO> commentDTO = commentMapper.selectCommentsByPostId(1L);

        // Then
        assertNotNull(commentDTO);
        assertFalse(commentDTO.isEmpty());

        commentDTO.forEach(System.out::println);

    }

}