package com.antra.services;

import java.util.List;

import com.antra.entity.Employee;

public interface EmployeeService {
	public void insertEmployeeData(String empFirstName, String empLastName, int age, String deptName);
	public List<Employee> getEmpData();
}
