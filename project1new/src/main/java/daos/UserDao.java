package daos;

public interface UserDao {

	UserModel getUserModel(String username);
	String getIsAdmin(UserModel usermodel);
	String getPassCheck(UserModel usermodel);
}
