package com.antra.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.antra.entity.Users;

@Repository
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public String checkUser(String userName, String password){
		Query q  = (Query) em.createNativeQuery("select user_name from users where user_name = ? and password = ?");
		q.setParameter(1, userName);
		q.setParameter(2, password);
		String user = (String) q.getSingleResult();
		
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getUsers() {
		// TODO Auto-generated method stub
		Query q = em.createNativeQuery("select * from users");
		return q.getResultList();
	}
	
}

