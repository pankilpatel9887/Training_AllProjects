<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%-- <%String m=(String)session.getAttribute("msg"); %>
<%=m %>

<% request.getParameter("empid"); %>
 --%>

 
    <div align="center">
        <table border="1" cellpadding="5">
        <h1>Welcome</h1>
            <caption><h2>List of Employee for Approval</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>type</th>
                <th>Email</th>
                <th>password</th>
                <th>phone</th>
                <th>Flag</th>
                <th>Status</th>
               
            </tr>
            
                <tr>
                
                    <td><c:out value="${empl.id}" /></td>
                    <td><c:out value="${empl.name}" /></td>
                    <td><c:out value="${empl.type}" /></td>
                    <td><c:out value="${empl.email}" /></td>
                     <td><c:out value="${empl.password}" /></td>
                     <td><c:out value="${empl.phone}" /></td>
                     <td><c:out value="${empl.flag}" /></td>
                    
                      <td> 
                        <a href="delete?id=<c:out value='${empl.id}' />">Delete</a>                     
                    </td>
                </tr>
         
        </table>
    </div>   
</body>
</html>