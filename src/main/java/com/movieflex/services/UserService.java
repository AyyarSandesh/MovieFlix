package com.movieflex.services;

import java.util.List;

import com.movieflex.entities.User;

public interface UserService {
	public String addUsers(User usr);
	public boolean emailExists(String email);
	public boolean checkUser(String email,String password);
	public List<User> viewUser(String email);
	public String deleteUser(int id);
	public User getUser(String  email);
	public User getUser(int  id);
	public void updateUser(User usr);
}
