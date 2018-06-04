package webapp.tables;

public class User {

	private int id;
	private String username;
	private String password;
	private String email;
	private String superUser;

	public User(int id, String username, String password, String email, String superUser) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.superUser = superUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSuperUser() {
		return superUser;
	}

	public void setSuperUser(String superUser) {
		this.superUser = superUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
