<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit employee</title>
</head>
<body>

<form action="EmployeeController" method="post">
			<table border="2">
			
				<tr>
					<td>Employee Id</td>
					<td><input type="text" name="empid"  value="${emp.id}"/></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" value="${emp.name}" /></td>
				</tr>
				<tr>
					<td>Role</td>
					<td><input type="radio" name="type" value="m"/>Manager   
						<input type="radio" name="type" value="e"/>Employee</td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" value="${emp.email}" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" value="${emp.password}" /></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><input type="text" name="phone" value="${emp.phone}"/></td>
				</tr>
				
			</table>
			<input type="submit" value="register" />
		</form>
</body>
</html>