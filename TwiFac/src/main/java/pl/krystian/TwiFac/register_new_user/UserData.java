package pl.krystian.TwiFac.register_new_user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserData {
	private String login;
	private String password;
	private String rPassword;
}
