package pl.krystian.TwiFac.register_new_user;

import org.springframework.stereotype.Component;
import pl.krystian.TwiFac.config.Config;

@Component
class CheckData {

	
	RegistrationStatus Check(UserData userData) {
		
		String password = userData.getPassword();
		String rPassword = userData.getRPassword();
		String login = userData.getLogin();

		RegistrationStatus registrationStatus;


		if 		(!HasAllowedSigns(login, Config.LOGIN_ALLOWED_SIGNS))						registrationStatus = new RegistrationStatus("Login contain unallowed signs", false);
		else if (!HasAllowedSigns(password, Config.PASSWORD_ALLOWED_SIGNS))					registrationStatus = new RegistrationStatus("Password contain unallowed signs", false);
		else if (!password.equals(rPassword))												registrationStatus = new RegistrationStatus("Passwords are not equals", false);
		else if (login.length() > Config.LOGIN_MAX_LENGTH)									registrationStatus = new RegistrationStatus("Login is too long", false);
		else if (login.length() < Config.LOGIN_MIN_LENGTH)									registrationStatus = new RegistrationStatus("Login is too short", false);
		else if (password.length() > Config.PASSWORD_MAX_LENGTH)							registrationStatus = new RegistrationStatus("Password is too long", false);
		else if (password.length() < Config.PASSWORD_MIN_LENGTH)							registrationStatus = new RegistrationStatus("Password is too short", false);
		else 																				registrationStatus = new RegistrationStatus("User sucessfully created", true);
		
		return registrationStatus;
	}
	

	private boolean HasAllowedSigns(String text, String signs) {
		
		for (int i = 0; i < text.length(); i++)		
			if (!signs.contains(text.charAt(i) + "")) return false;
		
		return true;
	}
}
