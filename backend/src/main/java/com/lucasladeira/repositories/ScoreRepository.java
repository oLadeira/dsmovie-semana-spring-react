package com.lucasladeira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasladeira.entities.Score;
import com.lucasladeira.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{

}
