package com.example.blogcache.controller;

import com.example.blogcache.model.BlogPostMethod;
import com.example.blogcache.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/{id}")
    public ResponseEntity<String> getBlogPost(@PathVariable Long id) {
        blogService.getBlogPostById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body("Blog post found!!!");
    }

    @PostMapping("/create")
    public ResponseEntity<String> createBlogPost(@RequestBody BlogPostMethod blogPost){
        blogService.createBlogPost(blogPost);
        return ResponseEntity.status(HttpStatus.CREATED).body("Blog post created successfully");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBlogPost(@PathVariable Long id) {
        blogService.deleteBlogPost(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Blog post deleted successfully");
    }
}