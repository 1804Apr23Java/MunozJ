<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>>
<%

String nameUp = request.getParameter("nameUp");
String commUp = request.getParameter("commUp");
String urelUp = request.getParameter("urelUp");

Connection connection = null;
ResultSet resultSet = null;
PreparedStatement pstmt = null;

try{ 
connection = DriverManager.getConnection("jdbc:oracle:thin:@apr23java.cg5hazkndtda.us-east-2.rds.amazonaws.com:1521:ORCL", "jlmunoz4", "Utep**9900");
//statement=connection.createStatement();

String sql ="INSERT INTO PENDINGRE2 (EMP_USERBAME, EMP_COMMENT, IMG_URL, MNG_NAME, STATUS) VALUES (?, ?, ?, 'empty', 'P')";
pstmt = connection.prepareStatement(sql);
pstmt.setString(1, nameUp);
pstmt.setString(2, commUp);
pstmt.setString(3, urelUp);
//System.out.println("id is"+id);

resultSet = pstmt.executeQuery();
System.out.println("inserted in db");
} catch (Exception e) {
e.printStackTrace();
}
%>    
    
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thank You</title>
</head>
<body>
Thank you for your request
  	<form action="welcomeHome.jsp" method="GET">
		<br>
		 <input type="submit" value="Go back to Homepage"/>
		<br>
		
	</form>
</body>
</html>