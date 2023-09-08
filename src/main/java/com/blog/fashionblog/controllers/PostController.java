package com.blog.fashionblog.controllers;

import com.blog.fashionblog.DTOs.PostDTO;
import com.blog.fashionblog.models.Post;
import com.blog.fashionblog.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/posts")

public class PostController {
    private final PostService postService;

    @GetMapping("findPost/{postId}")
    public ResponseEntity<Post> findPostById(@PathVariable Long postId) {
        Post foundPost = postService.findPostById(postId);
        if (foundPost == null){
            throw new RuntimeException("Post not found");
        }
        return new ResponseEntity<>(foundPost, HttpStatus.OK);
    }






}
