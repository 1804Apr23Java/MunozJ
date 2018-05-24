<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--  -->
<%@page import="java.sql.*" %>
<%


Connection connection = null;
ResultSet resultSet = null;
PreparedStatement pstmt = null;

try{ 
connection = DriverManager.getConnection("jdbc:oracle:thin:@apr23java.cg5hazkndtda.us-east-2.rds.amazonaws.com:1521:ORCL", "jlmunoz4", "Utep**9900");
//Copy Row
String sql ="SELECT EMP_USERBAME, EMP_COMMENT, IMG_URL FROM PENDINGRE2 fetch first row only";
pstmt = connection.prepareStatement(sql);


resultSet = pstmt.executeQuery();
String n = null;
String c = null;
String u = null;
while(resultSet.next()) {
	System.out.println("testing, Approve, set new Q vars");
	//result = rs.getString("EMP_EMAIL");
	n = (resultSet.getString("EMP_USERBAME"));
	c = (resultSet.getString("EMP_COMMENT"));
	u = (resultSet.getString("IMG_URL"));
}
//Insert into Completed, Update to Approved
 sql = "INSERT INTO COMPLETEDRE2 (EMP_USERBAME, EMP_COMMENT, IMG_URL, MNG_NAME, STATUS) VALUES (?, ?, ?, 'ADMIN', 'D')"; 
 pstmt = connection.prepareStatement(sql);
 pstmt.setString(1, n);
 pstmt.setString(2, c);
 pstmt.setString(3, u);

resultSet = pstmt.executeQuery();
//delete from pending
sql = "DELETE FROM PENDINGRE2 WHERE ROWNUM = 1"; 
pstmt = connection.prepareStatement(sql);
System.out.println("inserted in completed");
resultSet = pstmt.executeQuery();
} catch (Exception e) {
e.printStackTrace();
}
%>  
<!--  -->
    
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Done!</title>
</head>
<body>
Thank you, request complete.
  	<form action="ManagerHome.jsp" method="GET">
		<br>
		 <input type="submit" value="Go back to Homepage"/>
		<br>
		
	</form>
</body>
</html>