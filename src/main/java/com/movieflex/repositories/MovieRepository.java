package com.movieflex.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieflex.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
	List<Movie> findTop5ByOrderByCreatedAtDesc();
}
