package com.sic.marktory.post.command.application.service;

import com.sic.marktory.post.command.application.dto.PostCreateRequestDTO;
import com.sic.marktory.post.command.application.dto.PostUpdateRequestDTO;

public interface PostService {

    // 게시글 작성, todo md파일 html 변환
    Long createPost(PostCreateRequestDTO request);

    // 게시글 삭제
    void deletePost(Long id);

    //게시물 수정
    void updatePost(Long id, PostUpdateRequestDTO request);
}
