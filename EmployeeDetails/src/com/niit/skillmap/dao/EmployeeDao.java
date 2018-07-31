package com.niit.skillmap.dao;

import java.util.List;
import java.util.Set;

import com.niit.skillmap.model.Employee;

public interface EmployeeDao {

	public Employee getEmployeeById(int id);
	public List<Employee> getAllEmployee();
	public boolean insertEmployee(Employee emp);
	//boolean updateEmployee(Employee emp);
	public boolean deleteEmployee(int id);
	public boolean updateEmployee(String string, String string2, int i, int j);
	//public List<Employee> getAllEmployee(int id, String name, String password, int age);
		
	
}
