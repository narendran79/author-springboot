package com.example.Author.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Author.Model.Author;
import com.example.Blog.Model.Blog;



@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{

	List<Blog> getBlogsByAuthorId(Integer authorId);
 
}