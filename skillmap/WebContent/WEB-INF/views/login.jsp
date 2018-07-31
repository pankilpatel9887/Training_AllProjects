<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<script>
function check()
{
	var eml=document.getElementById("email").value;
	var pass=document.getElementById("password").value;
	if(emil=='' && pass=='')
		{
		alert("Email And Password Require");
		}
	}
</script>
</head>
<body>

<form action="login" method="post">
			<table border="2">
			
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" id="email"/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" id="password" /></td>
				</tr>
				<tr>
					<td>Role</td>
					<td><input type="radio" name="type" value="m" />Manager   
						<input type="radio" name="type" value="e" checked/>Employee</td>
				</tr>
				
			</table>
			<input type="submit" value="Login" onclick="check()" />
		</form>

</body>
</html>