package com.niit.skillmap.config;

import java.sql.*;

public class DBConnection  {

	Connection conn=null;
	
	
		
	
	public static final String driver= "org.h2.Driver";
	public static final String url= "jdbc:h2:tcp://localhost/~/test";
    public static final String username = "sa";
    public static final String password= "pankil";
    
    public static Connection getconnection()
    {
    	try
    	{
    	Class.forName(driver);
        
       return DriverManager.getConnection(url, username, password);
    	}
    	catch(Exception e)
    	{
    		System.out.println("Exception"+e);
    	}
		return null;
    }
    
    
	
}
