package com.antra.dao;

import java.util.List;

import com.antra.entity.Users;

public interface UserDao {
	public String checkUser(String userName, String password);
	public List<Users> getUsers();
}
