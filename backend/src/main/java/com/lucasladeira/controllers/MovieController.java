package com.lucasladeira.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasladeira.dto.MovieDTO;
import com.lucasladeira.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	
	@GetMapping
	public ResponseEntity<Page<MovieDTO>> getAllMovies(Pageable pageable){
		return ResponseEntity.status(HttpStatus.OK).body(movieService.getAllMovies(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MovieDTO> getByIdMovie(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(movieService.getByIdMovie(id));
	}
	
}
