package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImp implements UserDao{

	@Override
	public UserModel getUserModel(String username)  {
		PreparedStatement pstmt = null;
//		User user = null;
		String email = "not found";
		UserModel um = new UserModel();

		
		try {
	
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@apr23java.cg5hazkndtda.us-east-2.rds.amazonaws.com:1521:ORCL", "jlmunoz4", "Utep**9900");
			String sql = "SELECT EMP_ID, EMP_USERBAME, EMP_PASSWORD, EMP_EMAIL, SUPERUSER FROM PROJ1EMPLOYEE WHERE EMP_USERBAME = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("query executed:");
			String result= "null oops";
			while(rs.next()) {
				System.out.println("testing, inside getUsermodel");
				//result = rs.getString("EMP_EMAIL");
				um.setId(rs.getString("EMP_ID"));
				um.setUsername(rs.getString("EMP_USERBAME"));
				um.setPassword(rs.getString("EMP_PASSWORD"));
				um.setEmail(rs.getString("EMP_EMAIL"));
				um.setSuperuser(rs.getString("SUPERUSER"));
			}
			
			
			return um;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return um;
	}

	@Override
	public String getIsAdmin(UserModel usermodel) {

			return usermodel.getSuperuser();
	}

	@Override
	public String getPassCheck(UserModel usermodel) {
		return usermodel.getPassword();
	}	
}

	

