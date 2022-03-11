package com.lucasladeira.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucasladeira.dto.MovieDTO;
import com.lucasladeira.dto.ScoreDTO;
import com.lucasladeira.entities.Movie;
import com.lucasladeira.entities.Score;
import com.lucasladeira.entities.User;
import com.lucasladeira.repositories.MovieRepository;
import com.lucasladeira.repositories.ScoreRepository;
import com.lucasladeira.repositories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private ScoreRepository scoreRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO scoreDTO) {
		
		Optional<User> opt  = userRepository.findByEmail(scoreDTO.getEmail());
		User user = new User();
		
		if (opt.isEmpty()) {
			user.setEmail(scoreDTO.getEmail());
			user.setId(null);
			user = userRepository.saveAndFlush(user); //saveAndFlush garante a devolucao do objeto atualizado
		}
		
		Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(scoreDTO.getScore());
		score = scoreRepository.saveAndFlush(score);
		
		//soma a nota inserida com todas notas ja feitas
		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum += s.getValue();
		}
		
		//calcula a media
		double avg = sum/movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}
	
	
}
