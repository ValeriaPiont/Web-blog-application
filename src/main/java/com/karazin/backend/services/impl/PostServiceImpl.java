package com.karazin.backend.services.impl;

import com.karazin.backend.dto.PostDTO;
import com.karazin.backend.dto.ResultDTO;
import com.karazin.backend.dto.mapper.PostMapper;
import com.karazin.backend.dto.mapper.ResultMapper;
import com.karazin.backend.exceptions.EntityAlreadyExistExpection;
import com.karazin.backend.exceptions.EntityIsNullException;
import com.karazin.backend.exceptions.EntityNotFoundException;
import com.karazin.backend.model.Post;
import com.karazin.backend.model.User;
import com.karazin.backend.repositories.PostRepository;
import com.karazin.backend.repositories.UserRepository;
import com.karazin.backend.services.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostMapper postMapper;
    private final ResultMapper resultMapper;


    // in use
    public PostDTO savePost(PostDTO postDTO) {
        if(Objects.isNull(postDTO)) {
            throw new EntityIsNullException("Incoming post is null");
        }
        String username = postDTO.getUsername();

        Post postToSave = postMapper.postDTOToPost(postDTO);
        postToSave.setCreatedOn(LocalDateTime.now());
        postToSave.setUser(getUser(username));

        Post post = postRepository.save(postToSave);
        log.info("Saved post: {}", post);
        return postMapper.postToPostDTO(post);
    }

    // in use
    private User getUser(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent()) {
            log.info("Get existing user");
            return user.get();
        } else {
            User newUser = User.builder()
                    .username(username)
                    .build();
            log.info("Create new user {} ", newUser);
            return userRepository.save(newUser);
        }
    }

    // in use
    public List<ResultDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        log.info("All posts: {}", posts);
        return posts.stream().map(resultMapper::postToResultDTO).collect(Collectors.toList());
    }

    // code isn't used
    public void updatePost(PostDTO postDTO) {
        Optional<Post> optionalPost = postRepository.findById(postDTO.getId());
        if(optionalPost.isEmpty()) {
            throw new EntityNotFoundException("Post with id " + postDTO.getId() + " not found");
        }
        Post post = optionalPost.get();
        post.setText(postDTO.getText());
        postRepository.save(post);
    }

    // code isn't used
    public void deletePost(Long postId) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if(optionalPost.isEmpty()) {
            throw new EntityNotFoundException("Post with id " + postId + " not found");
        }
        postRepository.deleteById(optionalPost.get().getId());
    }

    // code isn't used
    public List<PostDTO> getAllPostsByUserId(Long id) {
        List<Post> posts = postRepository.findAllByUserIdOrderByCreatedOnDesc(id);
        log.info("All posts: {}", posts);
        return posts.stream().map(postMapper::postToPostDTO).collect(Collectors.toList());
    }

}
