package com.sic.marktory.post.command.application.service;

import com.sic.marktory.post.command.application.dto.PostCreateRequestDTO;

public interface PostService {


    // 게시글 작성, todo md파일 html 변환
    Long createPost(PostCreateRequestDTO request);
}
