package com.niit.skillmap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.skillmap.dao.EmployeeDao;
import com.niit.skillmap.daoimpl.EmployeeDaoImpl;
import com.niit.skillmap.model.Employee;
import com.sun.xml.internal.ws.wsdl.DispatchException;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet
//(name="EmployeeController",urlPatterns="/")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private EmployeeDaoImpl dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
        dao=new EmployeeDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		  String action = request.getServletPath();
		  System.out.println(action);
	        switch (action) {
//			case "/":
//			    RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/home.jsp");
//			    dispatcher.forward(request, response);
//		    break;
			case "/":
			    RequestDispatcher dispatcher1=request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			    dispatcher1.forward(request, response);
			    break;    
			case "/display":
				
			    listemp(request, response);
			    break;
			case "/index1":
				RequestDispatcher dispatcher2=request.getRequestDispatcher("/WEB-INF/views/index1.jsp");
			    dispatcher2.forward(request, response);
			    break;
			case "/EmployeeController":
				insertemp(request, response);
			    break;
			
			case "/delete":
				try {
					deleteemp(request, response);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    break;
			    
			case "/login":
				checkuser(request, response);
			    break;
			    
			case "/edit":
				try {
					showEditForm(request, response);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    break;   
			case "/update":
			    try {
					updateemp(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    break;
			case "/active":
			    activeuser(request, response);
			    break;   
			case "/sreach":
			    sreachuser(request, response);
			    break;   
			default:
			   
			    break;
			}
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	 private void insertemp(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
	     {
		// HttpSession session=request.getSession();
			
			Employee emp=new Employee();
			
			emp.setId(Integer.parseInt(request.getParameter("empid")));
			emp.setName(request.getParameter("name"));
			emp.setType(request.getParameter("type"));
			emp.setEmail(request.getParameter("email"));
			emp.setPassword(request.getParameter("password"));
			emp.setPhone(request.getParameter("phone"));
			emp.setFlag(Boolean.parseBoolean(request.getParameter("flag")));
			
			boolean rs=dao.insertEmployee(emp);
			 System.out.println(rs);
			//PrintWriter out = response.getWriter();
			if(rs)
			{
				response.setContentType("text/html");

			      // Actual logic goes here.
			      System.out.println("instred");
			      
			}
			else
			{
				 System.out.println("not");
			}
			
			listemp(request, response);
	    }
	 private void deleteemp(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException
	 {
	        int id = Integer.parseInt(request.getParameter("id"));
	 
	        Employee emp=new Employee();
	        emp.setId(id);
	       boolean rs= dao.deleteEmployee(emp);
	       System.out.println(rs);
	       if(rs)
	       {
	    	   listemp(request, response);
	       }
	 
	    }
	 
	 
	 private void updateemp(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("name");
	        String type = request.getParameter("type");
	        String email =request.getParameter("email");
	        String password=request.getParameter("password");
	        String phon=request.getParameter("phone");
	 
	        Employee emp= new Employee();
	        dao.updateEmployee(emp);
	        
	    }
	 
	  private void listemp(HttpServletRequest request, HttpServletResponse response)
	            throws  IOException, ServletException {
		  EmployeeDao dao=new EmployeeDaoImpl();
	        List<Employee> listemp = dao.getAllEmployee();
	        request.setAttribute("listemp", listemp);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/display.jsp");
	        dispatcher.forward(request, response);
	        
	        //return listemp;
	    }
	  private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/editfrom.jsp");
	        dispatcher.forward(request, response);
	    }
	  
	  private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, ServletException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Employee emp = dao.getEmployeeById(id);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/editfrom.jsp");
	        request.setAttribute("emp", emp);
	        dispatcher.forward(request, response);
	  }
	        private void activeuser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	        {
	        
	        	int id = Integer.parseInt(request.getParameter("id"));
	       	 
		        Employee emp=new Employee();
		        emp.setId(id);
		        emp.setFlag(true);
		       boolean rs= dao.setflage(emp);
		       System.out.println(rs);
		       if(rs)
		       {
		    	   listemp(request, response);
		       }
		 
	        
	        }
	        
	        
	        private void checkuser(HttpServletRequest request, HttpServletResponse response)
		            throws  IOException, ServletException {
	        	
	        	System.out.println("checkuser");
	        	String type=request.getParameter("type");
				String email=request.getParameter("email");
				String password=request.getParameter("password");
				System.out.println(password);
			  EmployeeDao dao=new EmployeeDaoImpl();
			  Employee empl= dao.validateuser(email,password,type);
			  System.out.println(empl);
		        request.setAttribute("empl", empl);
		        
		        if(empl.getType().equals("m"))
		        {
		        	System.out.println("manager");
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/profile.jsp");
		        dispatcher.forward(request, response);
		        }
		        if(empl.getType().equals("e"))
		        {
		        	System.out.println("employee");
		        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/display.jsp");
			        dispatcher.forward(request, response);
		        }
		        //return listemp;
		    }
	        
	        private void sreachuser(HttpServletRequest request, HttpServletResponse response)
		            throws  IOException, ServletException {
	        	
	        	String name=request.getParameter("sreach");
	        	
			  EmployeeDao dao=new EmployeeDaoImpl();
			  
			  Employee emp=dao.getEmployeeByName(name);
			  System.out.println(name);
		        request.setAttribute("emp", emp);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/sreachdisplay.jsp");
		        dispatcher.forward(request, response);
		        
		        //return listemp;
		    }
}
