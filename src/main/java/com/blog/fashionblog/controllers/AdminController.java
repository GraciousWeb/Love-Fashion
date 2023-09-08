package com.blog.fashionblog.controllers;

import com.blog.fashionblog.DTOs.PostDTO;
import com.blog.fashionblog.DTOs.ResponseData;
import com.blog.fashionblog.models.Post;
import com.blog.fashionblog.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/admin")
public class AdminController {
    private final PostService postService;
    @PostMapping("/post")
    public ResponseEntity<?> createPost(@RequestBody PostDTO postDTO){
        PostDTO createdPost = postService.createPost(postDTO);
        return new ResponseEntity<>( createdPost, HttpStatus.CREATED);

    }
    @PutMapping("/updatePost/{postId}")
    public ResponseEntity<PostDTO> updatePost (@PathVariable Long postId, @RequestBody PostDTO postDTO){
      PostDTO updatedPostDTO = postService.updatePost(postDTO,postId);
        return new ResponseEntity<>(updatedPostDTO, HttpStatus.OK);
    }
    @GetMapping("/viewPosts")
    public ResponseEntity<ResponseData> getAllPosts(@RequestParam (defaultValue = "1") int pageNo,
                                               @RequestParam(defaultValue = "5") int pageSize) throws RuntimeException{
        Pageable pageable = PageRequest.of( pageNo -1, pageSize);
        ResponseData responseData = postService.getAllPosts(pageable);
        return ResponseEntity.ok(responseData);

    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId){
        postService.deletePost(postId);
        return new ResponseEntity<>("Post deleted!", HttpStatus.OK);

    }
}
