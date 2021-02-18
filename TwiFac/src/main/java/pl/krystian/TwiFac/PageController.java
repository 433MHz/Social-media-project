package pl.krystian.TwiFac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import pl.krystian.TwiFac.register_new_user.RegistrationStatus;
import pl.krystian.TwiFac.register_new_user.User;
import pl.krystian.TwiFac.register_new_user.UserDataDAO;

@RestController
public class PageController {
	
	@Autowired
	User user;

	public RegistrationStatus addUser(UserDataDAO userData) {
		return user.addNew(userData);
	}
}
