package com.movieflex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.movieflex.entities.User;
import com.movieflex.services.UserService;

@Controller
public class NavController {
	@Autowired
	UserService sr;
	@GetMapping("map-signup")
	public String mapSignUp() {
		return "signup";
	}
	@GetMapping("map-signin")
	public String mapSignIn() {
		return "signin";
	}
	@GetMapping("map-addmovie")
	public String mapAddMovie() {
		return "addmovie";
	}
}
