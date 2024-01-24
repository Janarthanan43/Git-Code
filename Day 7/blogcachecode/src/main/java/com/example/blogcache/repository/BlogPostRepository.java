package com.example.blogcache.repository;

import com.example.blogcache.model.BlogPostMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPostMethod, Long> {
}
