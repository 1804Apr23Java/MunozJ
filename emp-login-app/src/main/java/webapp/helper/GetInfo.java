package webapp.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import webapp.exceptions.InvalidLoginException;
import webapp.tables.User;

public class GetInfo {
	private String name;
	private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String grabEmail(String username) {
		PreparedStatement pstmt = null;
		User user = null;
		String email = "not found";

		try {	Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:"
				+ "oracle:thin:@apr23java.cg5hazkndtda.us-east-2.rds.amazonaws.com:1521:ORCL", "jlmunoz4", "Utep**9900") ;

			// using a Statement - beware SQL injection
			String sql = "SELECT EMP_ID, EMP_USERBAME, EMP_PASSWORD, SUPERUSER FROM PROJ1EMPLOYEE WHERE EMP_USERBAME = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			if (!rs.next()) {
				throw new InvalidLoginException();
			}
			// move through result set
			
			int userID = rs.getInt("EMP_ID");
			String password = rs.getString("EMP_PASSWORD");
			email = rs.getString("EMP_EMAIL");
			String superUser = rs.getString("SUPERUSER");

			user = new User(userID, username, password, email, superUser);
			
			conn.close();
		} catch (InvalidLoginException | SQLException e) {
			System.out.println(e.getMessage());
			return email;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return email;	
	}
	
}
