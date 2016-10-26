package com.antra.services;

import java.util.List;

import org.springframework.messaging.Message;

import com.antra.entity.Department;
import com.antra.vo.DepartmentVO;

public interface DepartmentService {
	public String insertDepartmentRecords(DepartmentVO dVO);
	public List<Department> getDepartmentData();
	public List<Department> getDepartment();
	public List<Department> getSubDept();
	public int deleteDepartment(String deptName);
	public List<Department> getDeptName(DepartmentVO dvo);
	/*public String sendMessage();
	public String recieveMessage(String msg);
*/}
