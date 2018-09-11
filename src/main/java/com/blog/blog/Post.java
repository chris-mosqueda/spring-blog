package com.blog.blog;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String body;

//    @Column(columnDefinition = "VARCHAR(200) NOT NULL DEFAULT")
//    private String callToAction;

    public Post() {
    }

    // used for creating a Post (you don't know the id yet)
    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    // used for editing or deleting (when you know the id)
    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
