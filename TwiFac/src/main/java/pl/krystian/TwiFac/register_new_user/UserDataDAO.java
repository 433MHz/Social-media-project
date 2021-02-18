package pl.krystian.TwiFac.register_new_user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "user_Data")
public class UserDataDAO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	
	@Column(name = "user_login")
	private String login;
	@Column(name = "user_password")
	private String password;

	
	
	public UserDataDAO() {
		
	}
	
	
	
	public UserDataDAO(int id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
	}



	public int getId() {
		return id;
	}
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
