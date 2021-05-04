package com.in28minutes.rest.webservices.restfulwebservices.post;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class PostResource {
	@Autowired
	private PostDaoService service;

	@GetMapping("/posts")
	public List<Post> retrieveAllPosts() {
		return service.findAll();
	}

	@GetMapping("/posts/{title}")
	public Post retrievePost(@PathVariable String title) {
		Post post = service.findByTitle(title);
		
		if(post==null)
			throw new PostNotFoundException("Title-"+ title);
		
		return post;
	}

	@DeleteMapping("/posts/{title}")
	public void deletePost(@PathVariable String title) {
		Post post = service.deleteByTitle(title);
		
		if(post==null)
			throw new PostNotFoundException("title-"+ title);		
	}

	//
	// input - details of user
	// output - CREATED & Return the created URI
	@PostMapping("/posts")
	public ResponseEntity<Object> createPost(@RequestBody Post post) {
		post.setCreateDate();   
		Post savedPost = service.save(post);
		// CREATED
		// /user/{id}     savedUser.getId()
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedPost.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
}
