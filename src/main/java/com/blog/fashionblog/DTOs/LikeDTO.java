package com.blog.fashionblog.DTOs;

import com.blog.fashionblog.models.Comment;
import com.blog.fashionblog.models.Post;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LikeDTO {
    private Long Id;
    private Post post;
    private Comment comment;

}
