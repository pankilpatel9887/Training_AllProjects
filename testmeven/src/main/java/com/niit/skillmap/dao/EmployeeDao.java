package com.niit.skillmap.dao;

import java.util.List;

import com.niit.skillmap.model.Employee;

public interface EmployeeDao {

	public Employee getEmployeeById(int id);
	
	public List<Employee> getAllEmployeeFormanager();
	public boolean insertEmployee(Employee emp);
	public boolean deleteEmployee(Employee emp);
	public boolean updateEmployee(Employee emp);
	
	public Employee validateuser(String email,String password,String type);
	public Employee getEmployeeByName(String name);
}
