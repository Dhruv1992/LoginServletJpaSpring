package com.antra.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DepartmentVO {
	
	private Integer deptId;
	private String deptName;
	private String deptEmail;
	private String subName;
	
	public DepartmentVO(){
		
	}
	
	public DepartmentVO(Integer deptId, String deptName, String deptEmail, String subName){
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptEmail = deptEmail;
		this.subName = subName;
	}
	
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptEmail() {
		return deptEmail;
	}
	public void setDeptEmail(String deptEmail) {
		this.deptEmail = deptEmail;
	}
	
	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public String toString(){
		return "[DeptId:"+deptId+" DeptName:"+deptName+" DeptEmail:"+deptEmail+"SubjectName:"+subName+"]";
	}
}
