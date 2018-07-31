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
 
 
 <form action="sreach" method="post">
<center> 
 Sreach:<input type="text" name="sreach"><br>
 <input type="submit" value="click">
 </center>
 </form>

 
    <div align="center">
        <table border="1" cellpadding="5">
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
                <th>Action</th>
            </tr>
            <c:forEach var="emp" items="${requestScope.listemp}">
                <tr>
                
                    <td><c:out value="${emp.id}" /></td>
                    <td><c:out value="${emp.name}" /></td>
                    <td><c:out value="${emp.type}" /></td>
                    <td><c:out value="${emp.email}" /></td>
                     <td><c:out value="${emp.password}" /></td>
                     <td><c:out value="${emp.phone}" /></td>
                     <td><c:out value="${emp.flag}" /></td>
                     <td> <a href="active?id=<c:out value='${emp.id}' />">Active</a>
                 
                    </td>
                      <td> 
                        <a href="delete?id=<c:out value='${emp.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>