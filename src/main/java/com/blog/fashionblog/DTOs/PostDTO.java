package com.blog.fashionblog.DTOs;

import com.blog.fashionblog.models.Category;
import com.blog.fashionblog.models.Comment;
import com.blog.fashionblog.models.Like;
import com.blog.fashionblog.models.Post;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private Long postId;
    private String title;
    private String content;
    private List<Like> likes;
    private List<Comment> comments;
    private Category category;



    public PostDTO(Post post){
        this.postId = post.getPostId();
        this.content = post.getContent();
        this.title = post.getTitle();
        this.comments = post.getComments();
        this.category = post.getCategory();

    }

    }

