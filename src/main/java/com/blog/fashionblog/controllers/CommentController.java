package com.blog.fashionblog.controllers;

import com.blog.fashionblog.DTOs.CommentDTO;
import com.blog.fashionblog.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/comments")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/comment")
    public ResponseEntity<CommentDTO> saveComment(@RequestBody CommentDTO commentDTO){
       CommentDTO savedComment = commentService.saveComment(commentDTO);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }
    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
        return new ResponseEntity<>("Comment deleted!", HttpStatus.OK);

    }

}
