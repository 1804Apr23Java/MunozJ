<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>User Homepage!!</title>
</head>
<body>
Welcome to your homepage ${username}
<br><br>
This is your user info:
<br>
Email: ${email}
<br><br><br>

	<form action="Logout.jsp" method="POST">
		<br>
		 <input type="submit" value="Logout"/>
		<br>
		
	</form>
</body>
</html>