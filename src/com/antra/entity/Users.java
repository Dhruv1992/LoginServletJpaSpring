package com.antra.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String username;
	private String password;
	private int status;

	public Users() {
		// TODO Auto-generated constructor stub
	}
	
	public Users(String username, String password) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.password = password;
	}

	@Column(name="user_name")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="user_id")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column(name="status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
