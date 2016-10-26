package com.antra.vo;

public class EmployeeVO {
	
	private Integer empId;
	private String empFirstName;
	private String empLastName;
	private int empAge;
	private int dept_id;
	
	public EmployeeVO(Integer empId, String firstName, String lastName, int age, int dept_id) {
		// TODO Auto-generated constructor stub
		this.empId = empId;
		this.empFirstName = firstName;
		this.empLastName = lastName;
		this.empAge = age;
		this.dept_id = dept_id;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	
	
}
