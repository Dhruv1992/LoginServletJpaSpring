package com.antra.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.antra.entity.Department;
import com.antra.vo.DepartmentVO;

@Repository
public class DepartmentDaoImpl implements DepartmentDao{

	Logger log = Logger.getLogger(DepartmentDaoImpl.class);
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public String insertDepartmentData(DepartmentVO dVO) {
		// TODO Auto-generated method stub
		int count;
		Query q = em.createNativeQuery("insert into department(dept_name, dept_email) values(?,?)");
		q.setParameter(1, dVO.getDeptName());
		q.setParameter(2, dVO.getDeptEmail());
		count = q.executeUpdate();
		
		if(count>0){
			return "Record inserted successfully";
		}else{
			return "Record is not inserted";
		}
		
	}

	@Override
	public int getDeptId(String deptName) {
		Query q = em.createNativeQuery("select dept_id from department where dept_name = ?");
		q.setParameter(1, deptName);
		int deptId = (int) q.getSingleResult();
	
		return deptId;
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getDepartmentNames(){
		Query q  = (Query) em.createNativeQuery("select dept_name from department");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getDepartmentData() {

		Query q = em.createNativeQuery("select d.dept_name, d.dept_email, e.first_name, e.last_name from "
				+ "department d left join employee e on d.dept_id = e.dept_id");
		return q.getResultList();	
	}
/*
	public List<Department> getDistinctDepartment(){
		
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Query q = entityManager.createNativeQuery("select distinct dept_name from department");
		
		@SuppressWarnings("unchecked")
		List<Department> deptName = q.getResultList();
		entityManager.getTransaction().commit();
		
		return deptName;
	}*/

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getDepartment() {
		// TODO Auto-generated method stub
		Query q = em.createNativeQuery("Select * from department",Department.class);
		return q.getResultList();
	}

	@Override
	public int deleteDepartment(String deptName) {
		// TODO Auto-generated method stub
		Query q = em.createNativeQuery("delete from department where dept_name = ?");
		q.setParameter(1, deptName);
		int count = q.executeUpdate(); 
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getDeptName(DepartmentVO dvo) {
		// TODO Auto-generated method stub
		Query q = em.createNativeQuery("select * from department where dept_name like ?",Department.class);
		q.setParameter(1, "%"+dvo.getDeptName()+"%");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getSubDept() {
		// TODO Auto-generated method stub
		Query q = em.createNativeQuery("select * from subject as s , "
				+ "department as d, subject_dept as sd where s.subject_id = sd.subject_id "
				+ "and d.dept_id = sd.dept_id",Department.class);
		return q.getResultList();
	}

	
}
