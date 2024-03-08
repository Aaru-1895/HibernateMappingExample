package com.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.map.exception.ResourceNotFoundException;
import com.map.model.Tutorial;
import com.map.repository.TutorialRepository;

@RestController
@RequestMapping("/api")
public class TutorialController {
	
	
	@Autowired
	TutorialRepository tutorialRepository;
	
	@PostMapping("/tutorials")
	  public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
	    //Tutorial _tutorial = tutorialRepository.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), true));
	    Tutorial _tutorial = tutorialRepository.save(tutorial);

		return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
	  }
	
	@GetMapping("/tutorials/{id}")
	public ResponseEntity<Tutorial> getTutorialById(@PathVariable(value = "id") long id){
		Tutorial tutorial = tutorialRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = "+id));
	return new ResponseEntity<Tutorial>(tutorial,HttpStatus.OK);
	}
	
	@PutMapping("/tutorials/{id}")
	//@PatchMapping("/tutorials/{id}")
	 public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
		Tutorial _tutorial = tutorialRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = "+id));
		_tutorial.setTitle(tutorial.getTitle());
		//_tutorial.setDescription(tutorial.getDescription());
		//_tutorial.setPublished(tutorial.isPublished());
		
		return new ResponseEntity<Tutorial>(tutorialRepository.save(_tutorial),HttpStatus.OK);
		
	}
	
	

}
