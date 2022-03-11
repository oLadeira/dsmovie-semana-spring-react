package com.lucasladeira.dto;

public class ScoreDTO {

	private Long movieId;
	private String email;
	private Double value;
	
	
	public ScoreDTO() {
		
	}

	public ScoreDTO(Long movieId, String email, Double value) {
		super();
		this.movieId = movieId;
		this.email = email;
		this.value = value;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}
