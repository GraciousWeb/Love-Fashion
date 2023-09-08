package com.blog.fashionblog.models;

import com.blog.fashionblog.DTOs.CommentDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private String content;
    @ManyToOne
    @JoinColumn(name = "post_id")//Reference to post entity
    @ToString.Exclude
//    @JsonBackReference
    private Post post;
    @ManyToOne
    private Users users;
    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Like> likes;

    public Comment(CommentDTO commentDTO){
        this.commentId = commentDTO.getCommentId();
        this.content = commentDTO.getContent();

    }

}
