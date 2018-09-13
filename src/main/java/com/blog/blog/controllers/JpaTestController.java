package com.blog.blog.controllers;

import com.blog.blog.Post;
import com.blog.blog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JpaTestController {

    PostRepository postDao;

    public JpaTestController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/jpa/find")
    @ResponseBody
    public String jpaFindTest() {
        return postDao.findOne(2L).toString();
    }

    @GetMapping("/jpa/findall")
    @ResponseBody
    public String jpaFindAllTest() {
        List<Post> posts = postDao.findAll();
        String output = "";
        for (Post post: posts) {
            output += post.getTitle() + "<br>";
        }
        return output;
    }

//    @GetMapping("/jpa/create")
//    @ResponseBody
//    public String jpaCreateTest() {
//        Post post = new Post("new p 3", "Test testy post");
//        return jpaFindAllTest();
//    }
//
//    @GetMapping("/jpa/update")
//    @ResponseBody
//    public String jpaUpdateeTest() {
//        Post post = new Post(2,"update 2post", "This is update 2post");
//        postDao.save(post);
//        return jpaFindAllTest();
//    }

    @GetMapping("/jpa/delete")
    @ResponseBody
    public String jpaDeleteTest() {
        postDao.delete(3L);
        return jpaFindAllTest();
    }

    @GetMapping("/jpa/search")
    @ResponseBody
    public String jpaSearchTest() {
        List<Post> posts = postDao.findByTitleContaining("post");

        String output = "";
        for (Post post: posts) {
            output += post.toString() + "<br>";
        }
    return output;
    }

//    @GetMapping("/jpa/custom")
//    @ResponseBody
//    public String jpaCustomTest() {
//        List<Post> posts = postDao.findCustom(2);
//
//        String output = "";
//        for (Post post: posts) {
//            output += post.toString() + "<br>";
//        }
//        return output;
//    }
}
