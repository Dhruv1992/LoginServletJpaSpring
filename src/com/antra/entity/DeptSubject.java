package com.antra.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="subject_dept")
public class DeptSubject {

	private int subDeptId;
	private Subject subject;
	private Department department;
	
	public DeptSubject() {
		// TODO Auto-generated constructor stub
	}
	
	public DeptSubject(int subDeptId, Subject subject, Department department) {
		// TODO Auto-generated constructor stub
		this.subDeptId = subDeptId;
		this.department = department;
		this.subject = subject;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sub_dept_id")
	public int getSubDeptId() {
		return subDeptId;
	}

	public void setSubDeptId(int subDeptId) {
		this.subDeptId = subDeptId;
	}

	@ManyToOne
	@JoinColumn(name="subject_id")
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	@ManyToOne
	@JoinColumn(name="dept_id")
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
