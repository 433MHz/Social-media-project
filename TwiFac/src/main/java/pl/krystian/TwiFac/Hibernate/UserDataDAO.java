package pl.krystian.TwiFac.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "user_Data")
@Setter
@Getter
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
}
