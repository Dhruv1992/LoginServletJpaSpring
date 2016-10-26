package com.antra.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@XmlRootElement
public class Department {

	private Integer deptId;
	private String deptName;
	private String deptEmail;
	
	@JsonIgnore
	private Set<Employee> empList;
	@JsonIgnore
	private Set<DeptSubject> deptSubList;

	public Department() {

	}

	public Department(Integer deptId, String deptName, String deptEmail,
			Set<Employee> empList, Set<DeptSubject> deptSubList) {
		// TODO Auto-generated constructor stub
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptEmail = deptEmail;
		this.empList = empList;
		this.deptSubList = deptSubList;
	}

	@Column(name = "dept_name")
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Column(name = "dept_email")
	public String getDeptEmail() {
		return deptEmail;
	}

	public void setDeptEmail(String deptEmail) {
		this.deptEmail = deptEmail;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dept_id")
	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	@OneToMany(mappedBy = "department",cascade=CascadeType.ALL)
	public Set<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(Set<Employee> empList) {
		this.empList = empList;
	}

	/*@ManyToMany(mappedBy="deptList",fetch=FetchType.EAGER)
	public List<Subject> getSubList() {
		return subList;
	}

	public void setSubList(List<Subject> subList) {
		this.subList = subList;
	}
*/
	@OneToMany(mappedBy="department")
	public Set<DeptSubject> getDeptSubList() {
		return deptSubList;
	}

	public void setDeptSubList(Set<DeptSubject> deptSubList) {
		this.deptSubList = deptSubList;
	}
	
	@Override
	public String toString() {
		return "[DeptId:"+deptId+", DepartmentName:"+deptName+", DepartmentEmail:"+deptEmail+", EmployeeList:"+empList+
				", SubjectList:"+deptSubList+"]";
	}

}
