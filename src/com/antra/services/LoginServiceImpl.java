package com.antra.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antra.dao.DepartmentDao;
import com.antra.dao.UserDao;
import com.antra.entity.Department;
import com.antra.entity.Users;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	UserDao userDao;
	
	@Autowired
	DepartmentDao deptDao;
	
	@Override
	@Transactional
	public String checkUser(String userName, String password){
		return userDao.checkUser(userName, password);
	}
	
	@Transactional
	@Override
	public List<Department> getDeptName(){
		return deptDao.getDepartmentNames();
	}

	@Override
	public List<Users> getUsers() {
		// TODO Auto-generated method stub
		return userDao.getUsers();
	} 
	
}
