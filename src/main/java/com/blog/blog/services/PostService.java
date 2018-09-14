package com.blog.blog.services;

import com.blog.blog.models.Post;
import com.blog.blog.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    // auto-wire Repo, w/ variable
    PostRepository postDao;

    // Constructor for PostRepo above
    public PostService(PostRepository postDao) {
        this.postDao = postDao;
    }

    public List<Post> findAll() {
        return postDao.findAll();
    }

//    public List<Post> createPosts() {
//        Post post = new Post("t4 post", "4 lskfgj dsflkgj");
//        return findAll();
//    }

    public Post save(Post post) {
        //post.setId(posts.size() + 1); // only used for List, NOT using DB yet
        postDao.save(post);
        return post;
    }

    public Post findOne(long id) {
        return postDao.findOne(id);
    }


    public void deletePosts(long id) {
        postDao.delete(id);
    }
}
