package com.blog.fashionblog.services.serviceImpl;

import com.blog.fashionblog.DTOs.CommentDTO;
import com.blog.fashionblog.models.Comment;
import com.blog.fashionblog.models.Post;
import com.blog.fashionblog.repositories.CommentRepository;
import com.blog.fashionblog.repositories.PostRepository;
import com.blog.fashionblog.repositories.UserRepository;
import com.blog.fashionblog.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private  final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    @Override
    public CommentDTO saveComment(CommentDTO commentDTO) {
        Comment comment = map2Comment(commentDTO);
        Comment savedComment = commentRepository.save(comment);
        return new CommentDTO(savedComment);

    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);

    }
    public Comment map2Comment(CommentDTO commentDTO){
        Comment comments = new Comment();
        comments.setCommentId(commentDTO.getCommentId());
        comments.setContent(commentDTO.getContent());

        comments.setPost( postRepository.findById(commentDTO.getPostId())
                .orElseThrow(() -> new RuntimeException("Post not found")));
        comments.setUsers(userRepository.findById(commentDTO.getUsers().getId()).orElseThrow());


        return comments;
    }
}
