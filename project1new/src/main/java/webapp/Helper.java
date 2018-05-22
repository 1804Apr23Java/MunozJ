package webapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Helper {

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
	
	public String grabEmail(String username) throws ClassNotFoundException{
		PreparedStatement pstmt = null;
//		User user = null;
		String email = "not found";

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@apr23java.cg5hazkndtda.us-east-2.rds.amazonaws.com:1521:ORCL", "jlmunoz4", "Utep**9900");
			String sql = "SELECT EMP_EMAIL FROM PROJ1EMPLOYEE WHERE EMP_USERBAME = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("query executed:");
			String result= "null oops";
			while(rs.next()) {
				System.out.println("testing, inside while");
				result = rs.getString("EMP_EMAIL");
			}
			
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

	

