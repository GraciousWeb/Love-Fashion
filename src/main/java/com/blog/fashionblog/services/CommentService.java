package com.blog.fashionblog.services;

import com.blog.fashionblog.DTOs.CommentDTO;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    public CommentDTO saveComment(CommentDTO commentDTO);
    public void deleteComment(Long commentId);
}
