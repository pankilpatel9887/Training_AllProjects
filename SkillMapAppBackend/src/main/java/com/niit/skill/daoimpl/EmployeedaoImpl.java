package com.niit.skill.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.skill.dao.EmployeeDao;
import com.niit.skill.model.Employee;


@Transactional
@Repository
public class EmployeedaoImpl implements EmployeeDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		Employee emp=new Employee();
		//emp=(Employee) session.getCurrentSession().createQuery("from Employee where id"+id).list().get(0);
		emp=(Employee) sessionFactory.getCurrentSession().createQuery("from Employee where id"+id).uniqueResult();
		return emp;
	}

	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		
		return null;
	}

	public List<Employee> getAllEmployeeFormanager() {
		// TODO Auto-generated method stub
		
			List<Employee> list;
		list=sessionFactory.getCurrentSession().createQuery("from Employee").list();

			return list;
	
		
	}

	
	public boolean insertEmployee(Employee emp) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(emp);
	    return true;
		
	}

	public boolean deleteEmployee(Employee emp) {
		try {
			sessionFactory.getCurrentSession().delete(emp);

	return true;
	}catch(Exception e)
	{
		return false;
	}
	}

	public boolean updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(emp);

	return true;
	}catch(Exception e)
	{
		return false;
	}
		
	}

	public boolean setflage(Employee emp) {
		// TODO Auto-generated method stub
		return false;
	}

	public Employee validateuser(String email, String password, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
