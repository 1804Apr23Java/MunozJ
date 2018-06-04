package webapp.Dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import webapp.exceptions.InvalidLoginException;
import webapp.tables.Account;
import webapp.tables.User;



public class UserDaoImp implements UserDao{
private String filename = "connection.properties";
/*
 * 	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:
			oracle:thin:@apr23java.cg5hazkndtda.us-east-2.rds.amazonaws.com:1521:ORCL", "jlmunoz4", "Utep**9900");
			;*/	


	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<>();
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection("jdbc:"
				+ "oracle:thin:@apr23java.cg5hazkndtda.us-east-2.rds.amazonaws.com:1521:ORCL", "jlmunoz4", "Utep**9900")) {

			String sql = "SELECT EMP_ID, EMP_USERBAME, EMP_PASSWORD, SUPERUSER FROM PROJ1EMPLOYEE";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int userId = rs.getInt("EMP_ID");
				String username = rs.getString("EMP_USERBAME");
				String password = rs.getString("EMP_PASSWORD");
				String email = rs.getString("EMP_EMAIL");
				String superUser = rs.getString("SUPERUSER");
				users.add(new User(userId, username, password, email, superUser));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	@Override
	public User getUserById(int userId) {
		User user = null;
		PreparedStatement pstmt = null;

		try (Connection conn = DriverManager.getConnection("jdbc:"
				+ "oracle:thin:@apr23java.cg5hazkndtda.us-east-2.rds.amazonaws.com:1521:ORCL", "jlmunoz4", "Utep**9900")) {

			// using a Statement - beware SQL injection
			String sql = "SELECT EMP_ID, EMP_USERBAME, EMP_PASSWORD, SUPERUSER FROM PROJ1EMPLOYEE WHERE EMP_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			if (!rs.next()) {
				throw new InvalidLoginException();
			}
			
			int userID = rs.getInt("EMP_ID");
			String username = rs.getString("EMP_USERBAME");
			String password = rs.getString("EMP_PASSWORD");
			String email = rs.getString("EMP_EMAIL");
			String superUser = rs.getString("SUPERUSER");

			user = new User(userID, username, password, email, superUser);
			
			conn.close();
		} catch (InvalidLoginException e) {
			System.out.println(e.getMessage());
			return user;
		}
		catch (SQLException e) {
			e.printStackTrace();
		} 
		return user;
	}
	
	@Override
	public User getUserByName(String username) {
		User user = null;
		PreparedStatement pstmt = null;

		try (Connection conn = DriverManager.getConnection("jdbc:"
				+ "oracle:thin:@apr23java.cg5hazkndtda.us-east-2.rds.amazonaws.com:1521:ORCL", "jlmunoz4", "Utep**9900")) {

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
			String email = rs.getString("EMP_EMAIL");
			String superUser = rs.getString("SUPERUSER");

			user = new User(userID, username, password, email, superUser);
			
			conn.close();
		} catch (InvalidLoginException | SQLException e) {
			System.out.println(e.getMessage());
			return user;
		} 
		return user;	
	}

	
	@Override
	public boolean updateUser(int userId, String userOrPass, String option) {
		PreparedStatement pstmt = null;
			

		try (Connection conn = DriverManager.getConnection("jdbc:"
				+ "oracle:thin:@apr23java.cg5hazkndtda.us-east-2.rds.amazonaws.com:1521:ORCL", "jlmunoz4", "Utep**9900")) {
			
			if ( (option.toLowerCase().equals("username") && getUserByName(userOrPass) != null)) {
				throw new InvalidLoginException();
			} else if (getUserById(userId) == null) {
				throw new InvalidLoginException();
			}
			
			String sql = null;
			if (option.toLowerCase().equals("password")) {
				sql = "UPDATE USERS SET EMP_PASSWORD = ? WHERE EMP_ID = ?";
			} else if (option.toLowerCase().equals("username")) {
				sql = "UPDATE PROJ1EMPLOYEE SET EMP_USERBAME = ? WHERE EMP_ID = ?";
			} 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userOrPass);
			pstmt.setInt(2, userId);
			int i = pstmt.executeUpdate();
			conn.close();
			
			if (i > 0) return true;
			
		
		} catch (InvalidLoginException e) {
			System.out.println(e.getMessage() + " ( "+ userOrPass +" )");
			return false;
		}
		catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}


	@Override
	public boolean updateAccount(int userId, String accountName, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public String getEmailbyName(String username) {
		User user = null;
		String email ="email not found";
		PreparedStatement pstmt = null;

		try (Connection conn = DriverManager.getConnection("jdbc:"
				+ "oracle:thin:@apr23java.cg5hazkndtda.us-east-2.rds.amazonaws.com:1521:ORCL", "jlmunoz4", "Utep**9900")) {

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
			return "not found";
		} 
		return email;	
	}




}



