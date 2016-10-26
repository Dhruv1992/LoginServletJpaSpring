package com.antra.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.antra.entity.Users;
import com.antra.services.LoginService;
import com.antra.validations.CheckUploadFiles;
import com.antra.validations.CheckUserValidations;
import com.antra.vo.UploadFiles;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	LoginService logServ;

	@Autowired
	CheckUserValidations ckUser;
	
	@Autowired
	CheckUploadFiles uploadFile;

	private static final Logger log = Logger.getLogger(UserController.class);
	
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String CheckLogin(
			@RequestParam(name = "loginname") String userName,
			@RequestParam(name = "password") String password,
			HttpServletRequest request) {

		String validError = ckUser.checkUser(userName, password);
		if (validError == null) {
			try {
				request.getSession().setAttribute("user",
						logServ.checkUser(userName, password));
				request.getSession().setAttribute("deptName",
						logServ.getDeptName());

				return "Welcome";

			} catch (Exception e) {
				request.setAttribute("error",
						"Please check your username / password");
				 return "forward:/index.jsp";
			}
		} else {
			request.setAttribute("error", validError);
			return "forward:/index.jsp";
		}

	}
	
	@RequestMapping(value="/userData")
	public @ResponseBody List<Users> getUserData(){
		return logServ.getUsers();
	}
	
	@RequestMapping(value="/fileUpload",method=RequestMethod.POST)
	public @ResponseBody ModelMap fileUpload(@ModelAttribute MultipartFile file, ModelMap modelMap) throws IllegalStateException, IOException{
		String fileMessage = uploadFile.processFiles(file);
		modelMap.addAttribute("fileMessage",fileMessage);
		return modelMap;
	}
	
	

}
