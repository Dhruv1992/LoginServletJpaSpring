package com.antra.services;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.transaction.Transactional;

import org.apache.activemq.command.ActiveMQQueue;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Service;

import com.antra.dao.DepartmentDao;
import com.antra.entity.Department;
import com.antra.vo.DepartmentVO;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentDao deptDao;
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	private static final String ORDER_QUEUE = "order-queue";
	private static final String ORDER_RESPONSE_QUEUE = "order-response-queue";
	
	@Transactional
	@Override
	public String insertDepartmentRecords(DepartmentVO dVO) {
		return deptDao.insertDepartmentData(dVO);
		
	}

	@Transactional
	@Override
	public List<Department> getDepartmentData() {
		return deptDao.getDepartmentData();
	}
	/*
	public List<Department> getDistinctDepartmentData() {
		List<Department> deptList = new ArrayList<Department>();

		DepartmentDao deptDao = new DepartmentDao();
		deptList = deptDao.getDistinctDepartment();

		return deptList;
	}*/

	@Override
	@Transactional
	public List<Department> getDepartment() {
		// TODO Auto-generated method stub
		List<Department> deptList = deptDao.getDepartment();
		for(Department dept : deptList){
			Hibernate.initialize(dept.getEmpList());
			Hibernate.initialize(dept.getDeptSubList());
		}
		return deptList;
	}

	
	@Override
	@Transactional
	public int deleteDepartment(String deptName) {
		// TODO Auto-generated method stub
		return deptDao.deleteDepartment(deptName);
	}

	@Override
	@Transactional
	public List<Department> getDeptName(DepartmentVO dvo) {
		// TODO Auto-generated method stub
		List<Department> deptList = deptDao.getDeptName(dvo);
		for(Department dept : deptList){
			Hibernate.initialize(dept.getEmpList());
			Hibernate.initialize(dept.getDeptSubList());
		}
		return deptList;
	}

	@Override
	@Transactional
	public List<Department> getSubDept() {
		List<Department> deptList = deptDao.getSubDept();
		for(Department dept : deptList){
			Hibernate.initialize(dept.getDeptSubList());
		}
		return deptList;		
	}

	
	/*
	@Override
	public String sendMessage() {
		// TODO Auto-generated method stub
		jmsTemplate.send(new MessageCreator() {
			
			@Override
			public ObjectMessage createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				ObjectMessage msg = session.createObjectMessage();
				msg.setObject("Hello");
				msg.setJMSReplyTo(new ActiveMQQueue(ORDER_RESPONSE_QUEUE));
				return msg;
			}
		});
		
		return "Message has been sent";
	}

	@Override
	@JmsListener(destination=ORDER_QUEUE)
	public String recieveMessage(String msg) {
		// TODO Auto-generated method stub
		
		return msg;
	}
*/

}
