package com.lucasladeira.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucasladeira.dto.MovieDTO;
import com.lucasladeira.entities.Movie;
import com.lucasladeira.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> getAllMovies(Pageable pageable){
		Page<Movie> result = movieRepository.findAll(pageable);
		Page<MovieDTO> page = result.map(movie -> new MovieDTO(movie));
		return page;
	}
	
	@Transactional(readOnly = true)
	public MovieDTO getByIdMovie(Long id) {
		MovieDTO result = new MovieDTO(movieRepository.findById(id).get());
		return result;
	}
	
	/*
	 * public MovieDTO saveMovie(MovieDTO movieDTO) { return
	 * movieRepository.save(movieDTO); }
	 */
	
}
