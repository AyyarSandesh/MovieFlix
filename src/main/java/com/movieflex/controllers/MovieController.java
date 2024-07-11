package com.movieflex.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.movieflex.entities.Movie;
import com.movieflex.entities.User;
import com.movieflex.services.MovieService;
import com.movieflex.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MovieController {
	
	@Autowired
	MovieService movserv;

	@Autowired
	UserService usSr;
	
	@PostMapping("addmovie")
	public String addMovie(@ModelAttribute Movie mov,Model model,RedirectAttributes redirect) {
		movserv.addMovie(mov);
		redirect.addFlashAttribute("message", "Movie added successfully");
		return "redirect:/view-movies";
	}
	
	@GetMapping("view-movies")
	public String viewMovie(Model model) {
		List<Movie> movieList=movserv.viewMovie();
		model.addAttribute("movies",movieList);
		return "viewmovie";
	}
	
	@GetMapping("admin")
	public String viewMovieAd(Model model) {
//		List<Movie> movieList=movserv.viewMovie();
//		List<Movie> lastFive=movserv.getLast5Products();
//		model.addAttribute("last",lastFive);
//		model.addAttribute("movies",movieList);
		view(model);
		return "adminhome";
	}
	@GetMapping("home")
	public String viewMovieHome(Model model) {
//		List<Movie> movieList=movserv.viewMovie();
//		List<Movie> lastFive=movserv.getLast5Products();
//		model.addAttribute("last",lastFive);
//		model.addAttribute("movies",movieList);
		view(model);
		return "home";
	}
	
	public Model view(Model model) {
		List<Movie> movieList=movserv.viewMovie();
		List<Movie> lastFive=movserv.getLast5Products();
		model.addAttribute("last",lastFive);
		model.addAttribute("movies",movieList);
		return model;
	}
	@GetMapping("/delete-movie/{id}")
	 public String deleteMovie(@PathVariable(name="id") int id,Model model,RedirectAttributes redirect) {
		 movserv.deleteMovie(id);
		 redirect.addFlashAttribute("message", "Product deleted successfully");
		 return "redirect:/view-movies";
	 }
	@GetMapping("/view-movie/{id}")
	public String viewMovie(@PathVariable(name="id") int id,Model model,HttpSession session) {
		String email=(String)session.getAttribute("email");
		User usr=usSr.getUser(email);
		if(usr.isPremium()==true || email.equals("admin@gmail.com")) {
			Movie movie=movserv.viewMovie(id);
			model.addAttribute("movie",movie);
			return "viewOneMovie";
		}else {
			//otherwise , make payment
			return "redirect:/payment"; 
		}
	}

	@GetMapping("payment")
	public String redirect(){
		return "payment";
	}
    
}
