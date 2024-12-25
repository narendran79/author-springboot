package com.example.Author.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Blog.Model.Blog;

@Service
public class FindById {

private final RestTemplate restTemplate;
	
	public FindById() {
		this.restTemplate=new RestTemplate(); 	
		}
	 public List<Blog> getBlogsByAuthorId(Integer authorId) {
	     
	        String url = "http://localhost:8080/api/blog/authorId?authorId=" + authorId;

	        ResponseEntity<Blog[]> response = restTemplate.getForEntity(url, Blog[].class);
	        Blog[] blogArray = response.getBody();

	        return Arrays.asList(blogArray);
	    }
}
