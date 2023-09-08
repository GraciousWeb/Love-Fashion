package com.blog.fashionblog.models;

import com.blog.fashionblog.DTOs.PostDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne
    private Users users;
    @OneToMany
    private List<Like> likes;
    @Column(nullable = false)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post", fetch = FetchType.EAGER)
    @ToString.Exclude
//    @JsonManagedReference
    private List<Comment> comments;

    public Post(PostDTO postDTO) {
        this.postId = postDTO.getPostId();
        this.content = postDTO.getContent();
        this.title = postDTO.getTitle();
        this.comments = postDTO.getComments();
        this.category = postDTO.getCategory();

    }
}
