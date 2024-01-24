package com.demo.blog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blogId;
    private String blogName;
    private LocalDate blogCreationDate;
    private String blogOwner;
    private int numberOfPosts;
    private String blogStatus;

    public Blog(){

    }

    public Blog(String blogName, LocalDate blogCreationDate, String blogOwner, int numberOfPosts, String blogStatus){
        this.blogName=blogName;
        this.blogCreationDate= blogCreationDate;
        this.blogOwner=blogOwner;
        this.numberOfPosts=numberOfPosts;
        this.blogStatus=blogStatus;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public LocalDate getBlogCreationDate() {
        return blogCreationDate;
    }

    public void setBlogCreationDate(LocalDate blogCreationDate) {
        this.blogCreationDate = blogCreationDate;
    }

    public String getBlogOwner() {
        return blogOwner;
    }

    public void setBlogOwner(String blogOwner) {
        this.blogOwner = blogOwner;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public void setNumberOfPosts(int numberOfPosts) {
        this.numberOfPosts = numberOfPosts;
    }

    public String getBlogStatus() {
        return blogStatus;
    }

    public void setBlogStatus(String blogStatus) {
        this.blogStatus = blogStatus;
    }
}
