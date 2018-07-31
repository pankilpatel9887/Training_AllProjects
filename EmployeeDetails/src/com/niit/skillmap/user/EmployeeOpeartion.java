package com.niit.skillmap.user;

import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.niit.skillmap.dao.EmployeeDao;
import com.niit.skillmap.daoimpl.EmployeeMethodImplementation;
import com.niit.skillmap.model.Employee;

public class EmployeeOpeartion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		EmployeeDao dao= (EmployeeDao) new EmployeeMethodImplementation();

		int ch=0;
		
		System.out.println("1.insert emp::");
		System.out.println("2.delete emp::");
		System.out.println("3.update emp::");
		System.out.println("4.get all data::");
		System.out.println("5.Get emp data by id::");
		
		System.out.println("enter opeartion choice id::");
		ch=sc.nextInt();
		
		switch(ch)
		{
		case 1:
//			INSERT EMPLOYEE DATA
			
			Employee emp=new Employee(3,"niit","niit@23",98);
			
				boolean insert=dao.insertEmployee(emp);
				
				if(insert)
				{
					System.out.println("Record Insert Successfully..");
				}
				break;
		case 2:
			//			DELETE EMPLOYEE
			boolean delete=dao.deleteEmployee(2);
			
			if(delete)
			{
				System.out.println("Record Delete Successfully..");
			}
			break;
		case 3:
			//			UPDATE EMPLOYEE DATA
			
				boolean update=dao.updateEmployee("minsi","minsi@123",25,1);
				
				if(update)
				{
					System.out.println("Record Update Successfully..");
				}
			break;
		case 4:
				//			GET	ALL EMPLOYEE DATA
							
			 List<Employee> emplist= dao.getAllEmployee();
				
				Iterator<Employee> it=emplist.iterator();
				
				while(it.hasNext())
				{
					Employee i=it.next();
					
					System.out.println(i.getId());
					System.out.println(i.getName());
					System.out.println(i.getPassowrd());
					System.out.println(i.getAge());
					
				}
				break;
		case 5:
				Employee empdata=new Employee();
				
				empdata=dao.getEmployeeById(1);				
				System.out.println("ID:"+empdata.getId());
				System.out.println("Name:"+empdata.getName());
				System.out.println("Password:"+empdata.getPassowrd());
				System.out.println("Age:"+empdata.getAge());
				break;
				
				
		}
		
//				INSERT EMPLOYEE DATA
		
//		Employee emp=new Employee(2,"minsi","m@23",23);
		
//		boolean insert=dao.insertEmployee(emp);
//		
//		if(insert)
//		{
//			System.out.println("Record Insert Successfully..");
//		}
		
		
//					DELETE EMPLOYEE
//		boolean delete=dao.deleteEmployee(2);
//		
//		if(delete)
//		{
//			System.out.println("Record Delete Successfully..");
//		}
//		
		
//					UPDATE EMPLOYEE DATA
		
//		boolean update=dao.updateEmployee("minsi","minsi@123",25,1);
//		
//		if(update)
//		{
//			System.out.println("Record Update Successfully..");
//		}
		
		
//					GET	ALL EMPLOYEE DATA
		
//		Set<Employee> rs=dao.getAllEmployee();
//		
//		Iterator<Employee> it=rs.iterator();
//		
//		while(it.hasNext())
//		{
//			Employee i=it.next();
//			
//			System.out.println(i.getId());
//			System.out.println(i.getName());
//			System.out.println(i.getPassowrd());
 //			System.out.println(i.getAge());
//			
//			
//			
//		}
//		
	
//					GET EMPLOYEE BY ID
		
//		Employee empdata=new Employee();
//		
//		empdata=dao.getEmployeeById(1);
//		
//		System.out.println("ID:"+empdata.getId());
//		System.out.println("Name:"+empdata.getName());
//		System.out.println("Password:"+empdata.getPassowrd());
//		System.out.println("Age:"+empdata.getAge());
//		
//		
	}

}
