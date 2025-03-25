package com.sic.marktory.post.query.mapper;

import com.sic.marktory.post.query.dto.PostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {

    List<PostDTO> selectAllPublicPosts();
}
