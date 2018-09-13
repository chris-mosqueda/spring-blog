package com.blog.blog.repositories;

import com.blog.blog.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    // Set up a method below
    User findByUsername(String username);
}
