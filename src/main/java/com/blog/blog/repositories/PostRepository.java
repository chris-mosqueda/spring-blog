package com.blog.blog.repositories;

import com.blog.blog.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findAll();

    List<Post> findByTitleContaining(String string1);

//    finding id from Post Obj
//    hybernate Query language
//    @Query("from Post where Post.id > ?1")
//    List<Post> findCustom(long id);

}
