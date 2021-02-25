package pl.krystian.TwiFac.Token;

import pl.krystian.TwiFac.config.Config;

class LoginAndPasswordCheck {

	boolean CanLoginAndPasswordBeUsed(LoginAndPassword loginAndPassword) {
		String login = loginAndPassword.getLogin();
		String password = loginAndPassword.getPassword();


		if (login.length() <= Config.LOGIN_MAX_LENGTH && login.length() >= Config.LOGIN_MIN_LENGTH)
		if (password.length() < Config.PASSWORD_MAX_LENGTH && password.length() > Config.PASSWORD_MIN_LENGTH)
		if (DataContainOnlyAllowedSign(login, Config.LOGIN_ALLOWED_SIGNS))
		if (DataContainOnlyAllowedSign(password, Config.PASSWORD_ALLOWED_SIGNS))
		return true;

		return false;
	}

	private boolean DataContainOnlyAllowedSign(String variable, String allowedSigns) {
		for (int i = 0; i < variable.length(); i++)		
			if (!allowedSigns.contains(variable.charAt(i) + ""))	return false;
		
		return true;
	}
}
