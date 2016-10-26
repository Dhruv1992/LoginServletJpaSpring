package com.antra.services;

import java.util.List;

import com.antra.entity.Department;
import com.antra.entity.Users;

public interface LoginService {
	public String checkUser(String userName, String password);
	public List<Department> getDeptName();
	public List<Users> getUsers();
}
