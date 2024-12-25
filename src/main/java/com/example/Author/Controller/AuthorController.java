package com.example.Author.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Author.Exception.ResourceNotFound;
import com.example.Author.Model.Author;
import com.example.Author.Repository.AuthorRepository;
import com.example.Author.service.BlogService;
import com.example.Author.service.FindById;
import com.example.Blog.Model.Blog;


@RestController
@RequestMapping("/api/author")
public class AuthorController {
	
	@Autowired
	BlogService service;
	
    @Autowired
    FindById findbyId;
	
	@GetMapping("/blog")
	public List<Blog> getAllBlog(){
		List<Blog> blog=service.extractingData();
		return blog;
	}
	
	@GetMapping("/getBlogsByAuthorId")
    public List<Blog> getBlogsByAuthorId(@RequestParam Integer authorId) {
       
        List<Blog> blogs = findbyId.getBlogsByAuthorId(authorId);
        return blogs;
    }
	
	
	@Autowired
	public AuthorRepository authorRepository;
	
	@GetMapping("/getAllAuthor")
	public List<Author> getAllAuthor() {
	     return this.authorRepository.findAll();
	}
	
	@PostMapping("/createAuthor")
	public Author createAdmin(@RequestBody Author author) {
		return this.authorRepository.save(author);
	}
	
	@GetMapping("/getAuthor/{id}")
	public Author getAuthorById(@PathVariable(value="id")Integer authorId) {
		return this.authorRepository.findById(authorId)
				.orElseThrow(() -> new ResourceNotFound("authorId is not found"));
	}
	
	@PutMapping("/updateAuthor/{id}")
	public Author updateAuthor(@RequestBody Author author, @PathVariable(value = "id") Integer authorId) {
	    Optional<Author> optionalAuthor = this.authorRepository.findById(authorId);
	    if(optionalAuthor.isPresent()) {
	    	this.authorRepository.save(author);
	    	return author;
	    } else {
	    	throw new ResourceNotFound("authorId you looking for not found");
	    }
	}

	
	@DeleteMapping("/deleteAuthor/{id}")
	public void deleteAuthor(@PathVariable ("id") Integer authorId){
	    Optional<Author> optionalAuthor = this.authorRepository.findById(authorId);
		  if (optionalAuthor.isPresent()) {
		 this.authorRepository.deleteById(authorId);
		
		  }else {
			  throw new ResourceNotFound("authorId you looking for not found");
		  }
	}
	
	
}
