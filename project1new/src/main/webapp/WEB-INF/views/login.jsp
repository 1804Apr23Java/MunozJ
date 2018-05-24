<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hi from login jsp</title>
</head>
<body>
<div>
	<p><font color="red">${errorMessage}</font></p>
	<form action="login.do" method="POST">
		Username<input name="name" type="text" /> <br>
		Password  <input name="password" type="password" /> <input type="submit" />
		<br>
		<p><font color ="red">${problem}</font></p>
	</form>
	</div>
</body>
</html>