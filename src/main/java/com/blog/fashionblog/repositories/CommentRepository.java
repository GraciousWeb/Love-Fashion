package com.blog.fashionblog.repositories;

import com.blog.fashionblog.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
