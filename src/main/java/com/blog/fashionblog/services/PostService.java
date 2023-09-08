package com.blog.fashionblog.services;

import com.blog.fashionblog.DTOs.PostDTO;
import com.blog.fashionblog.DTOs.ResponseData;
import com.blog.fashionblog.models.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public interface PostService {
    PostDTO createPost(PostDTO postDTO);
    Post findPostById(Long postId);
    PostDTO updatePost(PostDTO postDTO, Long postId);
    ResponseData getAllPosts(Pageable pageable);

    void deletePost(Long postId);


}
