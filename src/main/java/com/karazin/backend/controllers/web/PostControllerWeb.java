package com.karazin.backend.controllers.web;

import com.karazin.backend.dto.PostDTO;
import com.karazin.backend.dto.ResultDTO;
import com.karazin.backend.model.Post;
import com.karazin.backend.services.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/posts")
@Slf4j
public class PostControllerWeb {

    private final PostService postService;

    @Autowired
    public PostControllerWeb(PostService postService) {
        this.postService = postService;
    }

    // in use
    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String getLatestSnippets(Model model) {
        List<ResultDTO> posts = postService.getAllPosts();
        log.info("Posts: {}", posts);
        model.addAttribute("all_posts", posts);
        return "index";
    }

}
