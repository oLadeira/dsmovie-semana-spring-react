package com.lucasladeira.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasladeira.dto.MovieDTO;
import com.lucasladeira.dto.ScoreDTO;
import com.lucasladeira.services.ScoreService;

@RestController
@RequestMapping("/scores")
public class ScoreController {

	@Autowired
	private ScoreService scoreService;
	
	
	@PutMapping
	public ResponseEntity<MovieDTO> saveScore(@RequestBody ScoreDTO scoreDTO){
		MovieDTO movieDTO = scoreService.saveScore(scoreDTO);
		return ResponseEntity.status(HttpStatus.OK).body(movieDTO);
	}
}
