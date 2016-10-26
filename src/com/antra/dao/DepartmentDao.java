package com.antra.dao;

import java.util.List;

import com.antra.entity.Department;
import com.antra.vo.DepartmentVO;

public interface DepartmentDao {
	
	public String insertDepartmentData(DepartmentVO dVO);
	public int getDeptId(String deptName);
	public List<Department> getDepartmentNames();
	public List<Department> getDeptName(DepartmentVO dvo);
	public List<Department> getDepartmentData();
	public List<Department> getDepartment();
	public int deleteDepartment(String deptName);
	public List<Department> getSubDept();
}
