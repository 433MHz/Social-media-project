package pl.krystian.TwiFac.register_new_user;

import org.springframework.stereotype.Component;

@Component
class CheckData {

	final private int LOGIN_MAX_LENGTH = 30;
	final private int LOGIN_MIN_LENGTH = 5;
	final private int PASSWORD_MAX_LENGTH = 30;
	final private int PASSWORD_MIN_LENGTH = 5;
	final private String LOGIN_ALLOWED_SIGNS = "0123456789QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
	final private String PASSWORD_ALLOWED_SIGNS = LOGIN_ALLOWED_SIGNS + "!@#$%^&*()_-+=";

	public RegistrationStatus Check(UserData userData) {

		String password = userData.getPassword();
		String rPassword = userData.getRPassword();
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

	private boolean CheckIfContainOnlyAllowedSigns(String text, String signs) {
		for (int i = 0; i < text.length(); i++) {
			if (!signs.contains(text.charAt(i) + "")) {
				return false;
			}
		}
		return true;
	}
}
