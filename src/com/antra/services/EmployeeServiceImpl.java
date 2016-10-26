package com.antra.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antra.dao.EmployeeDao;
import com.antra.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao empDao;
	
	@Transactional
	@Override
	public void insertEmployeeData(String empFirstName, String empLastName, int age, String deptName){
		empDao.insertEmployee(empFirstName,empLastName, age, deptName);
	}
	
	@Transactional
	@Override
	public List<Employee> getEmpData(){
		return empDao.getEmpData();
	}
}
