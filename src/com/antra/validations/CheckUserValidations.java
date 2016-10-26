package com.antra.validations;

import org.springframework.stereotype.Component;

@Component
public class CheckUserValidations {

	public String checkUser(String userName, String password){
		
		if(!userName.isEmpty()){
			if(!password.isEmpty()){
				return null;
			}else{
				return "Please enter the password";
			}
		}
		return "Please enter the user name";
	}
}
