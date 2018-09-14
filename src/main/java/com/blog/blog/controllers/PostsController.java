package com.blog.blog.controllers;

import com.blog.blog.models.Post;
import com.blog.blog.models.User;
import com.blog.blog.repositories.UserRepository;
import com.blog.blog.services.PostService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
// Controller does not does not know about Lists
public class PostsController {
    private final PostService postServ; // has lists of posts
    private final UserRepository userRepo;

    public PostsController(PostService postServ, UserRepository userRepo) {
        this.postServ = postServ;
        this.userRepo = userRepo;
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
//        User user = userRepo.findOne((long) 1);
//        vModel.addAttribute("user", user);
        return "posts/show1";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    // When form is submitted, a Post Obj is created
    @PostMapping("posts/save")
    // uses form binding with @ModelAttribute
    public String createAd(@ModelAttribute Post post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        post.setUser(userRepo.findOne((user.getId())));
        postServ.save(post);
        // return "redirect:/ads/" + post.getId();
        // return "redirect:/ads"; => will route to all ads view
        return "redirect:/posts"; // REDIRECT IS => a url
    }

    @GetMapping("/posts/{id}/edit")
    public String postEditForm(@PathVariable long id, Model vModel) {
        vModel.addAttribute("post", postServ.findOne(id));
        return "posts/editPost";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@ModelAttribute Post post) {
        // needs the {id} to update/ save
        postServ.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete") // gets name param(id) from the form
    public String deletePost(@RequestParam(name = "id") long id) {
        postServ.deletePosts(id);
        return "redirect:/posts";
    }

//    @GetMapping("find-user/{usern}")
//    public String findUser(@PathVariable String usern) {
//        User user = userRepo.findByUsername(usern);
//
////        System.out.println("user.getEmail() = " + user.getEmail()); // to test
//
//        return "";
//    }
}
