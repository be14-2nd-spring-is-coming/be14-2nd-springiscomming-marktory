package com.sic.marktory.post.query.service;

import com.sic.marktory.post.query.dto.PostDTO;
import java.util.List;


public interface PostService {

    // 회원 공개 전체 게시글 조회 (public)
    List<PostDTO> findPublicPosts();

}
