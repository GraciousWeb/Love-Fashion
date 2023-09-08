package com.blog.fashionblog.DTOs;

import com.blog.fashionblog.models.Comment;
import com.blog.fashionblog.models.Like;
import com.blog.fashionblog.models.Post;
import com.blog.fashionblog.models.Users;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class CommentDTO {
    private Long commentId;
    private Long postId;
    private String content;
    private Users users;
    private Post post;

    public CommentDTO(Comment comment){
        this.commentId = comment.getCommentId();
        this.content = comment.getContent();
    }
}
