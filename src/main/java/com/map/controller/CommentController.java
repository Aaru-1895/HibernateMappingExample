package com.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.map.exception.ResourceNotFoundException;
import com.map.model.Comment;
import com.map.repository.CommentRepository;
import com.map.repository.TutorialRepository;

@RestController
@RequestMapping("/api")
public class CommentController {
	
	@Autowired
	TutorialRepository tutorialRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	
	@PostMapping("/tutorials/{tutorialId}")
	public ResponseEntity<Comment> createComment(@PathVariable(value = "tutorialId") Long tutorialId,
			@RequestBody Comment commentRequest){
		System.out.println("commentRequest..."+commentRequest);
		Comment comment = tutorialRepository.findById(tutorialId).map(tutorial ->{
			commentRequest.setTutorial(tutorial);
			return commentRepository.save(commentRequest);
		}).orElseThrow(() ->new ResourceNotFoundException("Resouce Not Found"));
		
		return new ResponseEntity<>(comment, HttpStatus.CREATED);
		
	}
	
	 
	

}
