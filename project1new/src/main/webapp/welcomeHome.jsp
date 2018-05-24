<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--  wish me luck-->  
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<!--  -->

<!--  -->
<%
String id = (String)session.getAttribute("username");

String userId = "root";
String password = "root";

try {
Class.forName("oracle.jdbc.driver.OracleDriver");
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
PreparedStatement pstmt = null;
%>

<!--  -->
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
		
	</form><br>
	<!-- table header -->
	Pending RE Table
	<table cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#611F6F">
<td><font color="white"><b>id</b></font></td>
<td><font color="white"><b>username</b></font></td>
<td><font color="white"><b>comment</b></font></td>
<td><font color="white"><b>Manager</b></font></td>
<td><font color="white"><b>Staus</b></font></td>
</tr>

	<!--  -->
	<!--  -->
<%
try{ 
connection = DriverManager.getConnection("jdbc:oracle:thin:@apr23java.cg5hazkndtda.us-east-2.rds.amazonaws.com:1521:ORCL", "jlmunoz4", "Utep**9900");
//statement=connection.createStatement();

String sql ="SELECT * FROM PENDINGRE2 WHERE EMP_USERBAME = ?";
pstmt = connection.prepareStatement(sql);
pstmt.setString(1, id);
//System.out.println("id is"+id);

resultSet = pstmt.executeQuery();
while(resultSet.next()){
%>
<tr bgcolor="#FBFBF8">

<td><%=resultSet.getInt("RE_ID") %></td>
<td><%=resultSet.getString("EMP_USERBAME") %></td>
<td><%=resultSet.getString("EMP_COMMENT") %></td>
<td><%=resultSet.getString("MNG_NAME") %></td>
<td><%=resultSet.getString("STATUS") %></td>

</tr>
<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table><br><br>
	<!--  -->
		<!-- table header -->
	Processed RE Table
	<table cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#000100">
<td><font color="white"><b>id</b></font></td>
<td><font color="white"><b>username</b></font></td>
<td><font color="white"><b>comment</b></font></td>
<td><font color="white"><b>Manager</b></font></td>
<td><font color="white"><b>Staus</b></font></td>
</tr>

	<!--  -->
	<!--  -->
<%
try{ 
connection = DriverManager.getConnection("jdbc:oracle:thin:@apr23java.cg5hazkndtda.us-east-2.rds.amazonaws.com:1521:ORCL", "jlmunoz4", "Utep**9900");
//statement=connection.createStatement();

String sql ="SELECT * FROM COMPLETEDRE2 WHERE EMP_USERBAME = ?";
pstmt = connection.prepareStatement(sql);
pstmt.setString(1, id);
//System.out.println("id is"+id);

resultSet = pstmt.executeQuery();
while(resultSet.next()){
%>
<tr bgcolor="#FBFBF8">

<td><%=resultSet.getInt("RE_ID") %></td>
<td><%=resultSet.getString("EMP_USERBAME") %></td>
<td><%=resultSet.getString("EMP_COMMENT") %></td>
<td><%=resultSet.getString("MNG_NAME") %></td>
<td><%=resultSet.getString("STATUS") %></td>

</tr>
<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</body>
</html>