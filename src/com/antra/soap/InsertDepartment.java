package com.antra.soap;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface InsertDepartment {
	public String insertDepartment(@WebParam(name = "dept_name") String deptName,
								   @WebParam(name = "dept_name") String deptEmail);
}
