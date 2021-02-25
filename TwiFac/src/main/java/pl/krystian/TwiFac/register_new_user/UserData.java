package pl.krystian.TwiFac.register_new_user;

public class UserData {
	private String login;
	private String password;
	private String rPassword;
	
	
	
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	public String getrPassword() {
		return rPassword;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setrPassword(String rPassword) {
		this.rPassword = rPassword;
	}
}
