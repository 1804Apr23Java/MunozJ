<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thank you</title>
</head>
<body>
<br><br>
Thank you, <br>
you have been logged out
<br>
  <% session.invalidate(); %>
  
  	<form action="login.do" method="GET">
		<br>
		 <input type="submit" value="Go back to Login"/>
		<br>
		
	</form>
</body>
</html>