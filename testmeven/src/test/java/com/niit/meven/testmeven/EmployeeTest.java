package com.niit.meven.testmeven;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.niit.skillmap.daoimpl.EmployeeDaoImpl;
import com.niit.skillmap.model.Employee;

public class EmployeeTest {

	Employee emp;
	EmployeeDaoImpl dao;  
	
	
	Connection conn=null;
	@Before
	public void setup()
	{
		emp=new Employee();
		dao=new EmployeeDaoImpl();
		
	}
	
	@After
	public void tearDown()
	{
		emp=null;
		dao=null;
	}
	
	@Ignore
	@Test
		public void testInsert()
		{
			emp.setId(22);
			emp.setName("kavya");
			emp.setType("m");
			emp.setEmail("abc@gmail.com");
			emp.setPassword("abc@123");
			emp.setPhone("6843934689");
			emp.setFlag(true);
			
			assertEquals(true,dao.insertEmployee(emp));
		
		}
	
		@Ignore
		@Test
		public void testDelete()
		{
			emp.setId(900);
			assertEquals(true,dao.deleteEmployee(emp));
		}
		
		@Ignore
		@Test	
		 public void testEmpdata() {					
		        
		ArrayList list=new ArrayList<>();
		
			 
			 	list.add("test");					
		       // assertFalse(list.isEmpty());			
		        assertEquals(1, list.size());			
		    }	
		
		@Test
		public void testUpdate()
		{
			
			emp.setName("bhavya1");
			emp.setType("f");
			emp.setEmail("abc@gmail.com");
			emp.setPassword("abc@123");
			emp.setPhone("6843934689");
			emp.setFlag(false);
			emp.setId(2);
			assertEquals(true,dao.updateEmployee(emp));
		
			
		}
}
