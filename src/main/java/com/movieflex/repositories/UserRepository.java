package com.movieflex.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieflex.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	//method to find User by using the email
	public User findByEmail(String email);
	//
	List<User> findByEmailNot(String email);
}
