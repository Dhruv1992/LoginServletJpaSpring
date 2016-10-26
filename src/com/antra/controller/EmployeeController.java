package com.antra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.antra.services.EmployeeService;

@Controller
@RequestMapping("/")
public class EmployeeController {

	@Autowired
	private EmployeeService empServ;
	
	@RequestMapping(value="/insertEmpData",method=RequestMethod.POST)
	public String insertEmployeeData(ModelMap modelMap,
			@RequestParam("emp_fname") String empFirstName,
			@RequestParam("emp_lname") String empLastName,
			@RequestParam("emp_age") int age,
			String deptName){
		try{
			empServ.insertEmployeeData(empFirstName, empLastName, age, deptName);
			modelMap.addAttribute("emp_response","Record is inserted successfully");
		}catch(Exception e){
			modelMap.addAttribute("emp_response","Record is not added");
		}
		
		return "forward:"+"/getEmpData";
	}
	
	@RequestMapping(value="/getEmpData")
	public String getEmpData(ModelMap modelMap){
		modelMap.addAttribute("empList",empServ.getEmpData());
		return "forward:/Welcome.jsp";
	}

	
	/*@RequestMapping(value="/getEmpData")
	public @ResponseBody List<Employee> getEmpData(){
		return empServ.getEmpData();
		
	}*/

}
