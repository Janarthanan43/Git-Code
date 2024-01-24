package com.demo.blog.repository;

import com.demo.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findByBlogCreationDateOrderByBlogCreationDate(LocalDate date);

    List<Blog> findByOrderByNumberOfPostsDesc();

    List<Blog> findByBlogStatus(String status);

    List<Blog> findByBlogStatusAndBlogCreationDateBefore(String status, LocalDate date);

    List<Blog> findBlogOwnerByOrderByNumberOfPostsDesc();

    // Custom Query:
    // Date-wise blog list
    @Query("SELECT b FROM Blog b WHERE b.blogCreationDate = :date ORDER BY b.blogCreationDate")
    List<Blog> findDateWiseBlogs(@Param("date") LocalDate date);

    // Custom Query: Active blogs in the last 6 months
    @Query("SELECT b FROM Blog b WHERE b.blogStatus = 'Active' AND b.blogCreationDate >= :date")
    List<Blog> findActiveBlogsLast6Months(@Param("date") LocalDate sixMonthsAgo);

    // Custom Query: Inactive blogs in the last 6 months
    @Query("SELECT b FROM Blog b WHERE b.blogStatus = 'Dormant' AND b.blogCreationDate >= :date")
    List<Blog> findInactiveBlogsLast6Months(@Param("date") LocalDate sixMonthsAgo);

    // Custom Query: Total members
    @Query("SELECT COUNT(DISTINCT b.blogOwner) FROM Blog b")
    Long findTotalMembers();
}
