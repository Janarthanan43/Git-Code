package com.example.blogcache.service;

import com.example.blogcache.model.BlogPostMethod;
import com.example.blogcache.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Cacheable(value = "blogPosts", key = "#id")
    public BlogPostMethod getBlogPostById(Long id) {
        return blogPostRepository.findById(id).orElse(null);
    }

    @CacheEvict(value = "blogPosts", key = "#id")
    public void deleteBlogPost(Long id) {
        blogPostRepository.deleteById(id);
    }

    public void createBlogPost(BlogPostMethod blogPost){
        blogPostRepository.save(blogPost);
    }
}