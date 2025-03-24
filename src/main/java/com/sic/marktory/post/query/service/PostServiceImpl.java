package com.sic.marktory.post.query.service;

import com.sic.marktory.post.query.dto.PostDTO;
import com.sic.marktory.post.query.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;

    @Autowired
    public PostServiceImpl(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    // 회원 공개 전체 게시글 조회
    @Override
    public List<PostDTO> findPublicPosts() {
        return postMapper.selectAllPublicPosts();
    }

}
