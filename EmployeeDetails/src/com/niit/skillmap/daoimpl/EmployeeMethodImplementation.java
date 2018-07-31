package com.niit.skillmap.daoimpl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.niit.skillmap.config.ConnectionDetails;
import com.niit.skillmap.dao.EmployeeDao;
import com.niit.skillmap.model.Employee;

public class EmployeeMethodImplementation implements EmployeeDao{
	
//GET All Reocrds
	
//	public Set getAllEmployee()
//	{
//		ConnectionDetails condt=new ConnectionDetails();
//		
//		try{  
//			Class.forName(condt.driver);  
//			Connection con=DriverManager.getConnection(condt.url,condt.username,condt.password);  
//			
//			//here sonoo is database name, root is username and password  
//			Statement stmt=con.createStatement();  
//			ResultSet rs=stmt.executeQuery("select * from EMP");  
//			
//			
//			con.close();  
//			
//			return 
//			
//		}catch(Exception e){ System.out.println(e);}  
//		
//		
//	}
	

//INSERT EMPLOYEE DATA
	public boolean insertEmployee(Employee emp)
	{
		
		
		//ConnectionDetails condt=new ConnectionDetails();
		
		try {
			Class.forName(ConnectionDetails.driver);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(ConnectionDetails.url,ConnectionDetails.username,ConnectionDetails.password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		

		try
		{
		        PreparedStatement ps = con.prepareStatement("INSERT INTO EMPLOYEE VALUES (?, ?, ?,?)");
		        ps.setInt(1, emp.getId());
		        ps.setString(2, emp.getName());
		        ps.setString(3, emp.getPassowrd());
		        ps.setInt(4, emp.getAge());
		        
		        int i = ps.executeUpdate();
		      if(i == 1) {
		        return true;
		      }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		return false;
		
	}

	
//GET EMPLOYEEDATA BY ID
@Override
public Employee getEmployeeById(int id) {
	
	// TODO Auto-generated method stub
//ConnectionDetails condt=new ConnectionDetails();
	
	try {
		Class.forName(ConnectionDetails.driver);
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	Connection con = null;
	try {
		con = DriverManager.getConnection(ConnectionDetails.url,ConnectionDetails.username,ConnectionDetails.password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	
	try {
		 Employee emp=new Employee();
		 
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE WHERE ID="+id);
        //Set emps = new HashSet();
        while(rs.next())
        {
             emp = extractUserFromResultSet(rs);
          
        }
        return  emp;
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }	
	
	
	return null;
}


//GET ALL EMPLOYEEDATA
//@Override
//public List<Employee> getAllEmployee() {
//	// TODO Auto-generated method stub
//	//ConnectionDetails condt=new ConnectionDetails();
//	
//	return null;
//}


//EXTRACT DATA FROM RESULT SET FOR ALL EMPLOYEE DATA
private Employee extractUserFromResultSet(ResultSet rs)throws SQLException
{
	// TODO Auto-generated method stub
	
	 Employee user = new Employee();
	    user.setId( rs.getInt("id") );
	    user.setName( rs.getString("name") );
	    user.setPassowrd( rs.getString("password") );
	    user.setAge( rs.getInt("age") );
	    return user;
}


//@Override
//public boolean updateEmployee(Employee emp) {
//	// TODO Auto-generated method stub
//
//
//	
//	return false;
//}

//DELETE EMPLOYEE DATA
@Override
public boolean deleteEmployee(int id) {
	// TODO Auto-generated method stub
	
	//ConnectionDetails condt=new ConnectionDetails();
	
	try {
		Class.forName(ConnectionDetails.driver);
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	Connection con = null;
	try {
		con = DriverManager.getConnection(ConnectionDetails.url,ConnectionDetails.username,ConnectionDetails.password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	
	
	 try {
	        Statement stmt = con.createStatement();
	        int i = stmt.executeUpdate("DELETE FROM EMPLOYEE WHERE id=" + id);
	      if(i == 1) {
	    return true;
	      }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }

	
	
	return false;
}

//UPDATE EMPLOYEE DATA
@Override
public boolean updateEmployee(String name, String password, int age, int id) {
	// TODO Auto-generated method stub
	
//ConnectionDetails condt=new ConnectionDetails();
	
	try {
		Class.forName(ConnectionDetails.driver);
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	Connection con = null;
	try {
		con = DriverManager.getConnection(ConnectionDetails.url,ConnectionDetails.username,ConnectionDetails.password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	
	 try {
		 Employee emp=new Employee(id, name, password, age);
		 PreparedStatement ps = con.prepareStatement("UPDATE EMPLOYEE SET name=?, password=?, age=? WHERE id=?");
	        ps.setString(1, emp.getName());
	        ps.setString(2, emp.getPassowrd());
	        ps.setInt(3, emp.getAge());
	        ps.setInt(4, emp.getId());
	        int i = ps.executeUpdate();
	      if(i == 1) {
	    return true;
	      }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	return false;
}


@Override
public List<Employee> getAllEmployee() {
	// TODO Auto-generated method stub
	

	try {
		Class.forName(ConnectionDetails.driver);
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	Connection con = null;
	try {
		con = DriverManager.getConnection(ConnectionDetails.url,ConnectionDetails.username,ConnectionDetails.password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	
	try {
		  List<Employee> emplist = new ArrayList<>();
		  
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");
        
        while(rs.next())
        {
        	 int eid = rs.getInt("id");
             String ename = rs.getString("name");
             String epassword = rs.getString("password");
             int eage = rs.getInt("age");
              
            Employee emp=new Employee(eid, ename, epassword, eage);
             emplist.add(emp);
        }
        return emplist;
    } catch (SQLException ex) {
        ex.printStackTrace();
    }	
	return null;
}


//@Override
//public List<Employee> getAllEmployee() {
//	// TODO Auto-generated method stub
//	return null;
//}
//

//@Override
//public boolean updateEmployee(Employee emp) {
//	// TODO Auto-generated method stub
//	return false;
//}

}
