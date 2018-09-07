package com.blog.blog.services;

import com.blog.blog.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private List<Post> posts; // 1st STEP, instantiate Post Obj

    public PostService() {  // Initialize Post List
        posts = new ArrayList<>();

        createPosts(); // method below
    }

    private void createPosts() {
                            // => from Constructor in Post Class
        posts.add(new Post("Post1", "Brand new")); // this line create a new OBJ of NEW Post
        posts.add(new Post("test2", "used testylk "));
        posts.add(new Post("posty 3", "lorem ipsum skdjf skl testylk "));
    }

    public Post save(Post post) {
        post.setId(posts.size() + 1); // only used for List, NOT using DB yet
        posts.add(post);
        return post;
    }

    public Post findOne(long id) {
        return posts.get((int) (id - 1));
    }

    public List<Post> findAll() {
        return posts;
    }


}
