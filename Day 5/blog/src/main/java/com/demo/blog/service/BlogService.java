package com.demo.blog.service;

import com.demo.blog.model.Blog;
import com.demo.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> getBlogsByDate(LocalDate date){
        return blogRepository.findByBlogCreationDateOrderByBlogCreationDate(date);
    }

    public List<Blog> getBlogsSortedByPosts(){
        return blogRepository.findByOrderByNumberOfPostsDesc();
    }

    public List<Blog> getActiveBlogs(){
        return blogRepository.findByBlogStatus("Active");
    }

    public List<Blog> getDormantBlogs(){
        LocalDate sixMonthsAgo = LocalDate.now().minusMonths(6);
        return blogRepository.findByBlogStatusAndBlogCreationDateBefore("dormant", sixMonthsAgo);
    }

    public List<Blog> getBlogOwnersSortedByPosts(){
        return blogRepository.findBlogOwnerByOrderByNumberOfPostsDesc();
    }

    public Blog saveBlog(Blog blog){
        return blogRepository.save(blog);
    }

    public List<Blog> getDateWiseBlogs(LocalDate date) {
        return blogRepository.findDateWiseBlogs(date);
    }
    public List<Blog> getActiveBlogsLast6Months() {
        LocalDate sixMonthsAgo = LocalDate.now().minusMonths(6);
        return blogRepository.findActiveBlogsLast6Months(sixMonthsAgo);
    }
    public List<Blog> getInactiveBlogsLast6Months() {
        LocalDate sixMonthsAgo = LocalDate.now().minusMonths(6);
        return blogRepository.findInactiveBlogsLast6Months(sixMonthsAgo);
    }

    public Long getTotalMembers() {
        return blogRepository.findTotalMembers();
    }
}
