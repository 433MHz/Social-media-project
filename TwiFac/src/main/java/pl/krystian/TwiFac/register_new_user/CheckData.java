package pl.krystian.TwiFac.register_new_user;

import org.springframework.stereotype.Component;

import pl.krystian.TwiFac.config.Config;

@Component
class CheckData {

	private int LOGIN_MAX_LENGTH;
	private int LOGIN_MIN_LENGTH;
	private int PASSWORD_MAX_LENGTH;
	private int PASSWORD_MIN_LENGTH;
	private String LOGIN_ALLOWED_SIGNS;
	private String PASSWORD_ALLOWED_SIGNS;

	RegistrationStatus Check(UserData userData) {
		
		SetValues();

		String password = userData.getPassword();
		String rPassword = userData.getrPassword();
		String login = userData.getLogin();

		RegistrationStatus registrationStatus;

		int optionNum = 0;

		if (!CheckIfContainOnlyAllowedSigns(login, LOGIN_ALLOWED_SIGNS))
			registrationStatus = new RegistrationStatus("Login contain unallowed signs", false);
		else {
			if (!CheckIfContainOnlyAllowedSigns(password, PASSWORD_ALLOWED_SIGNS))
				registrationStatus = new RegistrationStatus("Password contain unallowed signs", false);
			else {
				if (!password.equals(rPassword))
					registrationStatus = new RegistrationStatus("Passwords are not equals", false);
				else {
					if (login.length() > LOGIN_MAX_LENGTH)
						registrationStatus = new RegistrationStatus("Login is too long", false);
					else {
						if (login.length() < LOGIN_MIN_LENGTH)
							registrationStatus = new RegistrationStatus("Login is too short", false);
						else {
							if (password.length() > PASSWORD_MAX_LENGTH)
								registrationStatus = new RegistrationStatus("Password is too long", false);
							else {
								if (password.length() < PASSWORD_MIN_LENGTH)
									registrationStatus = new RegistrationStatus("Password is too short", false);
								else {
									registrationStatus = new RegistrationStatus("User sucessfully created", true);
								}
							}
						}
					}
				}
			}
		}
		return registrationStatus;
	}
	
	private void SetValues() {
		LOGIN_MAX_LENGTH = Config.LOGIN_MAX_LENGTH;
		LOGIN_MIN_LENGTH = Config.LOGIN_MIN_LENGTH;
		LOGIN_ALLOWED_SIGNS = Config.LOGIN_ALLOWED_SIGNS;
		PASSWORD_MAX_LENGTH = Config.PASSWORD_MAX_LENGTH;
		PASSWORD_MIN_LENGTH = Config.PASSWORD_MIN_LENGTH;
		PASSWORD_ALLOWED_SIGNS = Config.PASSWORD_ALLOWED_SIGNS;
		
	}

	private boolean CheckIfContainOnlyAllowedSigns(String text, String signs) {
		for (int i = 0; i < text.length(); i++) {
			if (!signs.contains(text.charAt(i) + "")) {
				return false;
			}
		}
		return true;
	}
}
