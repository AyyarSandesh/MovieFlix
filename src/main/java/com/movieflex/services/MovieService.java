package com.movieflex.services;

import java.util.List;
import java.util.Optional;

import com.movieflex.entities.Movie;

public interface MovieService {
	public String addMovie(Movie mov);
	public List<Movie> viewMovie();
	public String deleteMovie(int id);
	public Movie viewMovie(int id);
	public List<Movie> getLast5Products();
}
