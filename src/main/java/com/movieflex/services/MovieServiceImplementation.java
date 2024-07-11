package com.movieflex.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieflex.entities.Movie;
import com.movieflex.repositories.MovieRepository;
@Service
public class MovieServiceImplementation implements MovieService {
	@Autowired
	MovieRepository movrepo;
	@Override
	public String addMovie(Movie mov) {
		movrepo.save(mov);
		return "Movie is Added";
	}

	@Override
	public List<Movie> viewMovie() {
		List<Movie> movieList=movrepo.findAll();
		return movieList;
	}

	@Override
	public String deleteMovie(int id) {
		movrepo.deleteById(id);
		return "Movie Deleted";
	}

	@Override
	public Movie viewMovie(int id) {
		Movie movie=movrepo.getById(id);
		return movie;
	}
	public List<Movie> getLast5Products() {
        return movrepo.findTop5ByOrderByCreatedAtDesc();
    }

}
