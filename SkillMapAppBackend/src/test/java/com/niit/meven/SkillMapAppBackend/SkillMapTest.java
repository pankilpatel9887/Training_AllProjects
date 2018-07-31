package com.niit.meven.SkillMapAppBackend;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Spring;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.skill.config.ConfigrationDetails;
import com.niit.skill.dao.EmployeeDao;
import com.niit.skill.daoimpl.EmployeedaoImpl;
import com.niit.skill.model.Employee;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=ConfigrationDetails.class)
public class SkillMapTest {

	@Autowired
	 EmployeeDao empDao;
	
	@Before
	public void setUp()
	{
		//empDao=new EmployeedaoImpl();
	}
	@After
	public void tearDow()
	{
		
	}
	
	@Ignore
	@Test
	public void testInsert()
	{
		Employee emp=new Employee();
		emp.setId(2);
		emp.setFristName("minsi");
		emp.setType("employee");
		emp.setEmail("minsi@gmail.com");
		emp.setPassword("443gfds");
		emp.setPhone("463464");
		emp.setFlag(false);
		
		assertEquals(true,empDao.insertEmployee(emp));
		
	}
	
	@Ignore
	@Test
	public void testDelete()
	{
		Employee emp=new Employee();
		emp.setId(1);
		assertEquals(true,empDao.deleteEmployee(emp));
	}
	
	@Ignore
	@Test
	public void tesupdate()
	{
		Employee emp=new Employee();
		emp.setId(2);
		emp.setFristName("jiya");
		emp.setType("employee");
		emp.setEmail("minsi@gmail.com");
		emp.setPassword("443gfds");
		emp.setPhone("99999");
		emp.setFlag(false);
		
		assertEquals(true,empDao.updateEmployee(emp));
		
	}
	
	
	@Test	
	 public void testEmpdata() {					
	        
	ArrayList list=new ArrayList<>();
	
		 
		 						
	       // assertFalse(list.isEmpty());			
	        assertEquals(1, list.size());			
	    }	
	
	
}
