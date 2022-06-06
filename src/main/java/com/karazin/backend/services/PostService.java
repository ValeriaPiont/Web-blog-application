package com.karazin.backend.services;

import com.karazin.backend.dto.PostDTO;
import com.karazin.backend.dto.ResultDTO;
import com.karazin.backend.model.Post;

import java.util.List;

public interface PostService {

    PostDTO savePost(PostDTO postDTO);

    void updatePost(PostDTO postDTO);

    void deletePost(Long postId);

    List<PostDTO> getAllPostsByUserId(Long id);

    List<ResultDTO> getAllPosts();
}
