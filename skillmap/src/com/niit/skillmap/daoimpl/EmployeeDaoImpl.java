package com.niit.skillmap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.niit.skillmap.config.DBConnection;
import com.niit.skillmap.dao.EmployeeDao;
import com.niit.skillmap.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	Connection conn;
	public EmployeeDaoImpl() {
		conn=DBConnection.getconnection();
	}
	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
	
		
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		try {
			
			  List<Employee> emplist = new ArrayList<>();
			  
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM EMP where flag=false");
	        
	        while(rs.next())
	        {
	        	 int eid = rs.getInt("id");
	             String ename = rs.getString("name");
	             String etype = rs.getString("type");
	             String eemail = rs.getString("email");
	             String epassword = rs.getString("password");
	             String ephone = rs.getString("phon");
	             boolean flag=rs.getBoolean("flag");
	             
	              
	            Employee emp=new Employee(eid,ename,etype,eemail,epassword,ephone,flag);
	            
	             emplist.add(emp);
	        }
	        return emplist;
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }	
		
		return null;
	}

	@Override
	public boolean insertEmployee(Employee emp){
		// TODO Auto-generated method stub
		
		try
		{
		        PreparedStatement ps = conn.prepareStatement("INSERT INTO EMP VALUES (?,?,?,?,?,?,?)");
		        ps.setInt(1, emp.getId());
		        ps.setString(2, emp.getName());
		        ps.setString(3, emp.getType());
		        ps.setString(4, emp.getEmail());
		        ps.setString(5,emp.getPassword());
		        ps.setString(6,emp.getPhone());
		        ps.setInt(7, 0);
		        
		        
		        int i = ps.executeUpdate();
		      
		        System.out.println("instred"+i);
		        if(i == 1) {
		        return true;
		      }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		return false;
	}

	

	

	@Override
	public boolean deleteEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
		String sql = "DELETE emp where id = ?";
       
        PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			 stmt.setInt(1, emp.getId());
	         
		    int rowDeleted = stmt.executeUpdate();
		     if(rowDeleted>0)
		    	 return true;
		     else
		    	 return false;
		       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
			
		}
       
		
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		
		String sql = "UPDATE emp SET name = ?, type = ?, email = ?,password= ?,phon= ?";
        sql += " WHERE id = ?";
        
         try {
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, emp.getName());
        statement.setString(2, emp.getType());
        statement.setString(3, emp.getEmail());
        statement.setString(4, emp.getPassword());
        statement.setString(5, emp.getPhone());
        statement.setInt(6, emp.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
         }
         catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
         
		return false;
	}
	@Override
	public boolean setflage(Employee emp) {
		// TODO Auto-generated method stub
		String sql = "UPDATE emp SET flag = ? WHERE id = ?";
        
         try {
        PreparedStatement statement = conn.prepareStatement(sql);
       
        statement.setBoolean(1,emp.isFlag());
        statement.setInt(2, emp.getId());
         
        int rowUpdated = statement.executeUpdate();
        
        if(rowUpdated>0)
         
         return true;
        else
        {
        	return false;
        }
         }
         catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
		
		
		return false;
	}
	@Override
	public Employee validateuser(String email, String password, String type) {
		 Employee empl=null;

		try {
			
			 
			empl = new Employee();
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM EMP where email='"+email+"'and password='"+password+"' and type='"+type+"'");
	        System.out.println(rs);
	        while(rs.next())
	        {
	        	 
	            
	            empl.setId(rs.getInt(1));
	            empl.setName(rs.getString(2));
	            empl.setType(rs.getString(3));
	             
	             empl.setEmail(rs.getString(4));
	            empl.setPassword(rs.getString(5));
	            empl.setPhone(rs.getString(6));
	            
	             
	        }
	        if(empl!=null)
	        {
	        	System.out.println("success");
	        	
	        	if(empl.getType().equals("m"))
	        	{
	        		
	        		System.out.println("manager"+empl.getType());
	        	}
	        	else
	        	{
	        		System.out.println("employee"+empl.getType());
	        	}
	        	return empl;
	        	
	        	
	        }
	        else
	        {
	        	System.out.println("error");
	        }
	        
	    } catch (SQLException ex) {
	        ex.printStackTrace();	
	}
		return empl;
		
	}
	@Override
	public Employee getEmployeeByName(String name) {
		  Employee emp = null;
		try {
			
			  
			  
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM EMP where name  like '"+name+"'");
	        
	        while(rs.next())
	        {
	        	 int eid = rs.getInt("id");
	             String ename = rs.getString("name");
	             String etype = rs.getString("type");
	             String eemail = rs.getString("email");
	             String epassword = rs.getString("password");
	             String ephone = rs.getString("phon");
	             boolean flag=rs.getBoolean("flag");
	             
	              
	             emp=new Employee(eid,ename,etype,eemail,epassword,ephone,flag);
	            
	             
	        }
	        return emp;
	    } catch (SQLException ex) {
	        ex.printStackTrace();
		return null;
	}
}
	@Override
	public List<Employee> getAllEmployeeFormanager() {
		// TODO Auto-generated method stub
		try {
			
			  List<Employee> emplist = new ArrayList<>();
			  
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM EMP");
	        
	        while(rs.next())
	        {
	        	 int eid = rs.getInt("id");
	             String ename = rs.getString("name");
	             String etype = rs.getString("type");
	             String eemail = rs.getString("email");
	             String epassword = rs.getString("password");
	             String ephone = rs.getString("phon");
	             boolean flag=rs.getBoolean("flag");
	             
	              
	            Employee emp=new Employee(eid,ename,etype,eemail,epassword,ephone,flag);
	            
	             emplist.add(emp);
	        }
	        return emplist;
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }	
		
		return null;
	}}
