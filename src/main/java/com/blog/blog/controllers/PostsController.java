package com.blog.blog.controllers;

import com.blog.blog.Post;
import com.blog.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
// Controller does not does not know about Lists
public class PostsController {
    private final PostService postServ; // has lists of posts

    public PostsController(PostService postServ) {
        this.postServ = postServ;
    }

    @GetMapping("/posts")
    public String showAll(Model vModel) {
        vModel.addAttribute("posts", postServ.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}") // Get to the view - url
    public String showPost(@PathVariable long id, Model vModel) {
        Post post = postServ.findOne(id);
        vModel.addAttribute("post", post);
        return "posts/show1";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    // When form is submitted, a Post Obj is created
    @PostMapping("posts/save")
    public String createAd(@ModelAttribute Post post) {
        postServ.save(post);
        // return "redirect:/ads/" + post.getId();
        // return "redirect:/ads"; => will route to all ads view
        return "redirect:/posts"; // REDIRECT IS => a url

    }

//    @GetMapping("/posts/{id}/edit")
//    public String postEditForm(@PathVariable long id, Model vModel) {
//        vModel.addAllAttributes("post", postServ.findOne(id));
//
//    }

}
