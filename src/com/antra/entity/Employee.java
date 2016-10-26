package com.antra.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Employee {

	private Integer empId;
	private String empFirstName;
	private String empLastName;
	private int empAge;
	private Department department;

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(Integer empId, String firstName, String lastName, int age,
			Department department) {
		// TODO Auto-generated constructor stub
		this.empId = empId;
		this.empFirstName = firstName;
		this.empLastName = lastName;
		this.empAge = age;
		this.department = department;
	}

	@Column(name = "first_name")
	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	@Column(name = "last_name")
	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	@Column(name = "age")
	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emp_id")
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	@ManyToOne
	@JoinColumn(name = "dept_id")
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
