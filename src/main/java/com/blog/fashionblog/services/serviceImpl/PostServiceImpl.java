package com.blog.fashionblog.services.serviceImpl;

import com.blog.fashionblog.DTOs.PostDTO;
import com.blog.fashionblog.DTOs.ResponseData;
import com.blog.fashionblog.models.Category;
import com.blog.fashionblog.models.Post;
import com.blog.fashionblog.repositories.PostRepository;
import com.blog.fashionblog.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    @Override
    public Post findPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(()->new RuntimeException("No such post found"));


    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setCategory(postDTO.getCategory());
        Post updatedPost = postRepository.save(post);

        return new PostDTO(updatedPost);

    }

    @Override
    public ResponseData getAllPosts(Pageable pageable) {
        Page<Post> page = postRepository.findAll(pageable);
        if(!page.hasContent()){
            throw new RuntimeException("No Posts");
        }
        List<PostDTO> postDTOList = convertToDTOList(page.getContent());
        ResponseData responseData = new ResponseData();
        responseData.setResponse(postDTOList);
        responseData.setFirst(page.isFirst());
        responseData.setLast(page.isLast());
        responseData.setPageSize(page.getSize());
        responseData.setPageNo(page.getNumber());
        responseData.setTotalPages(page.getTotalPages());
        responseData.setTotalItems(page.getNumberOfElements());
        System.out.println(responseData);

        return responseData;
    }
    private List<PostDTO>convertToDTOList(List<Post>postList){
        return postList.stream().map(this::map2PostDTO).collect(Collectors.toList());


    }
    public Post map2Post(PostDTO postDTO){
        Post posts = new Post();
        posts.setContent(postDTO.getContent());
        posts.setPostId(postDTO.getPostId());
        posts.setTitle(postDTO.getTitle());
        posts.setLikes(postDTO.getLikes());
        posts.setComments(postDTO.getComments());
        posts.setCategory(postDTO.getCategory());
        return posts;
    }
    public PostDTO map2PostDTO(Post post){
        PostDTO postDTO = new PostDTO();
        postDTO.setContent(post.getContent());
        postDTO.setPostId(post.getPostId());
        postDTO.setTitle(post.getTitle());
        postDTO.setComments(post.getComments());
        postDTO.setCategory(post.getCategory());
        return postDTO;

    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);

    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        Post posts = map2Post(postDTO);
       Post createdPost = postRepository.save(posts);
        return new PostDTO(createdPost);

    }

}
