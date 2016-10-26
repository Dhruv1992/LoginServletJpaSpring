package com.antra.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.antra.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	DepartmentDao deptDao;
	
	@Override
	public void insertEmployee(String empFirstName, String empLastName, int age, String deptName) {
		// TODO Auto-generated method stub
	
		Query q = em.createNativeQuery("insert into employee(first_name, last_name, age, dept_id) values(?,?,?,?)");
		q.setParameter(1, empFirstName);
		q.setParameter(2, empLastName);
		q.setParameter(3, age);
		q.setParameter(4, deptDao.getDeptId(deptName));
		q.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmpData(){
		Query q = em.createNativeQuery("select e.first_name, e.last_name, e.age, d.dept_name from employee e, department d "
				+ "where e.dept_id = d.dept_id");
		return q.getResultList();
	}

}
