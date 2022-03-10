package com.lucasladeira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasladeira.entities.Movie;


public interface MovieRepository extends JpaRepository<Movie, Long>{
	
}
