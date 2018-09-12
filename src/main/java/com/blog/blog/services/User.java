package com.blog.blog.services;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100)
    private String username;

    @Column(nullable = false, length = 100)
    private String passowrd;

    @Column(nullable = false, length = 100)
    private String email;
}
