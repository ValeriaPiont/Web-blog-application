package com.karazin.backend.controllers;

import com.karazin.backend.dto.PostDTO;
import com.karazin.backend.services.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/v1/posts/api")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    //in use
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostDTO> savePost(@Valid @RequestBody PostDTO postDTO) {
        log.info("Incoming post: {}", postDTO);
        PostDTO saved = postService.savePost(postDTO);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    // in use
    @GetMapping("/users/{user-Id}")
    public ResponseEntity<List<PostDTO>> getAllPosts(@PathVariable("user-Id") Long userId) {
        List<PostDTO> posts = postService.getAllPostsByUserId(userId);
        log.info("All posts: {}", posts.toString());
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // code isn't used
    @DeleteMapping("/{post-Id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePostById(@PathVariable("post-Id") Long postID) {
        log.info("Delete by id {}", postID);
        postService.deletePost(postID);
    }

    // code isn't used
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(@RequestBody PostDTO postDTO) {
        log.info("Incoming post {}", postDTO);
        postService.updatePost(postDTO);
    }

}
