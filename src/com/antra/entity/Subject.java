package com.antra.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Subject {

	private int subjectId;
	private String subjectName;
	private String subjectDesc;
	private Set<DeptSubject> deptSubList;

	public Subject(int subjectId, String subjectName, String subjectDesc, Set<DeptSubject> deptSubList){
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.subjectDesc = subjectDesc;
		this.deptSubList = deptSubList;
	}
	
	public Subject(){
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="subject_id")
	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	@Column(name="subject_name")
	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Column(name="subject_desc")
	public String getSubjectDesc() {
		return subjectDesc;
	}

	public void setSubjectDesc(String subjectDesc) {
		this.subjectDesc = subjectDesc;
	}
	
	@OneToMany(mappedBy="subject")
	public Set<DeptSubject> getDeptSubList() {
		return deptSubList;
	}

	public void setDeptSubList(Set<DeptSubject> deptSubList) {
		this.deptSubList = deptSubList;
	}

	/*@ManyToMany
	@JoinTable(name="subject_dept",
	joinColumns=@JoinColumn(name="subject_id"),
	inverseJoinColumns=@JoinColumn(name="dept_id"))
	public List<Department> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Department> deptList) {
		this.deptList = deptList;
	}
*/
	@Override
	public String toString() {
		return "[subejctId:"+subjectId+", subjectName:"+subjectName+", subjectDesc:"+subjectDesc+"]";
	}
}
