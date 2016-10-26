package com.antra.dao;

import java.util.List;

import com.antra.entity.Employee;

public interface EmployeeDao {

	public void insertEmployee(String empFirstName, String empLastName, int age, String deptName);
	public List<Employee> getEmpData();
	
}
