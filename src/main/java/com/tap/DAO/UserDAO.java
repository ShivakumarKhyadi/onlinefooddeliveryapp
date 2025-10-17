package com.tap.DAO;

import java.util.List;

import com.tap.models.User;

public interface UserDAO {
	
	void addUser(User user);
	int updateUser(User user);
	int deleteUser(int id);
	User getUser(int id);
	List<User> getAllUsers();
}
