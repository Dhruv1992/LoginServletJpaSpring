package com.antra.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.antra.entity.Department;
import com.antra.entity.DeptSubject;
import com.antra.services.DepartmentService;
import com.antra.vo.DepartmentVO;
import com.antra.vo.UsersVO;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
@RequestMapping("/")
public class DepartmentController {
	
	private static final Logger log = Logger.getLogger(DepartmentController.class);
	
	@Autowired
	DepartmentService deptService;

	@RequestMapping(value = "/delDeptData", method = RequestMethod.POST)
	public String delDept(@RequestParam(name = "dept_name") String deptName, ModelMap model){
		deptService.deleteDepartment(deptName);
		return "Welcome";
	}
	
	@RequestMapping(value = "/insertDeptData", method = RequestMethod.POST)
	public String insertDepartmentdata(
			@RequestParam(name = "dept_name") String deptName,
			@RequestParam(name = "dept_email") String deptEmail,
			ModelMap modelMap) {

		DepartmentVO dVo = new DepartmentVO(null, deptName, deptEmail, null);

		try {
			modelMap.addAttribute("dept_response",
					deptService.insertDepartmentRecords(dVo));
		} catch (Exception e) {
			modelMap.addAttribute("dept_response", "Could not insert the data");
		}

		return "forward:/sendMessage";
	}

	/*@RequestMapping(value="/sendMessage")
	public String sendMessage(){
		return deptService.sendMessage();
	}
*/
	@POST
	@Consumes(value="application/json")
	@RequestMapping(value = "/restDept", method = RequestMethod.POST)
	public @ResponseBody String insertThroughPost(@RequestBody DepartmentVO deptVO, 
			ModelMap modelMap) {

		/*DepartmentVO deptVO = new DepartmentVO(null, deptName, deptEmail);*/
		log.info(deptVO);
		
		try {
			modelMap.addAttribute("dept_response",
					deptService.insertDepartmentRecords(deptVO));
		} catch (Exception e) {
			modelMap.addAttribute("dept_response", "Could not insert the data");
		}

		
		return "forward:/Welcome.jsp";
	}
	
	@DELETE
	@RequestMapping(value="/delDept/{deptName}")
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody String delPostDept(@PathVariable("deptName") String deptName, ModelMap modelMap){
		try{
			System.out.println(deptService.deleteDepartment(deptName));
			return "Record deleted successfully";
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	
	@RequestMapping(value = "/getDeptData")
	public String getDepartmentRecords(ModelMap modelMap) {
		modelMap.addAttribute("deptList", deptService.getDepartmentData());
		return "Welcome";
	}

	
	@RequestMapping(value = "/restData")
	public String getWaetherRecords(ModelMap modelMap) throws JsonParseException, JsonMappingException, IOException {
		RestTemplate rest = new RestTemplate();
		String url = "http://services.groupkt.com/country/get/all";
		UsersVO users = rest.getForObject(url, UsersVO.class);
		log.info(users.toString());
		modelMap.addAttribute("users",users);
		return "forward:/Welcome.jsp";
	}
	
	@RequestMapping(value="/deptData")
	public String getDepartment(ModelMap modelmap){
		modelmap.addAttribute("dept",deptService.getDepartment()); 
		return "forward:/Welcome.jsp";
		
	}

	
	//@GET
	@RequestMapping(value="/ajaxDeptName")
	//@Produces(value={"application/json"})
	public @ResponseBody List<Department> getAjaxData(HttpServletRequest req){
		String ip = req.getRemoteAddr();
		System.out.println("Ip address is:"+ip);
		return deptService.getDepartment();
	}

	
	
	/*@RequestMapping(value="/ajaxDeptName")
	public @ResponseBody Users getAjaxData(){
		Users u = new Users("sdf","sdf");
		u.setUsername("ddd");
		return u;
	}
	*/
	
	@RequestMapping(value="/getDeptSearch",method=RequestMethod.POST)
	public @ResponseBody List<Department> getDeptName(@RequestBody DepartmentVO dvo){
		return deptService.getDeptName(dvo);
	}
		
	@RequestMapping(value="/getSubDeptList")
	public String getSubDepartment(ModelMap modelmap){
		
		List<DepartmentVO> dvoList = new ArrayList<DepartmentVO>();
		List<Department> deptList = deptService.getSubDept();
		for(Department dept: deptList){
			DepartmentVO dvo = new DepartmentVO();
			//System.out.println(dept.getDeptName());
			dvo.setDeptName(dept.getDeptName());
			for(DeptSubject sub : dept.getDeptSubList()){
				dvo.setSubName(sub.getSubject().getSubjectName());
			}
			dvoList.add(dvo);
		}

		modelmap.addAttribute("SubDeptList",dvoList);
		return "forward:/Welcome.jsp";
	}
	
	/*@RequestMapping(value="/getJmsMsg")
	public String getJmsMessage(ModelMap modelMap){
		String msg = null;
		modelMap.addAttribute("Your Message",deptService.recieveMessage(msg));
		return "forward:/Welcome.jsp";
	}*/
}
