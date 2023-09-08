package com.blog.fashionblog.repositories;

import com.blog.fashionblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
