package webapp.Dao;

import java.util.List;

import webapp.tables.Account;
import webapp.tables.User;


public interface UserDao {
	List<User> getUsers();
	User getUserById(int userId);
	User getUserByName(String username);
	String getEmailbyName(String username);
	boolean updateAccount(int userId,String accountName, double amount);
	boolean updateUser(int userId, String userOrPass, String option);

}
