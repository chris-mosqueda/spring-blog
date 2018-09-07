package com.blog.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String index(Model viewModel){
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("title1", "111 long description slkfj sdlkfj sdlkf"));
        posts.add(new Post("title2", "222 long description slkfj sdlkfj sdlkf"));

        viewModel.addAttribute("posts", posts);

        return "posts/index";
    }

    @RequestMapping("/posts/{id}")
    public String show(@PathVariable int id, Model viewModel){
        Post post = new Post("test", "try new test");
        viewModel.addAttribute("post", post);
        return "posts/show";
    }

    @RequestMapping("/posts/create")
    @ResponseBody
    public String route(){
        return "Create a post.";
    }

    @PostMapping(path="/posts/create")
    @ResponseBody
    public String postRoute(){
        return "New post";
    }
}
