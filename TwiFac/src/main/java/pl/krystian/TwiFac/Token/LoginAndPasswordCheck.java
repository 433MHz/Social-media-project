package pl.krystian.TwiFac.Token;

import pl.krystian.TwiFac.config.Config;

class LoginAndPasswordCheck {

	boolean CanLoginAndPasswordBeUsed(LoginAndPassword loginAndPassword) {
		String login = loginAndPassword.getLogin();
		String password = loginAndPassword.getPassword();

		int loginLength = login.length();
		int passwordLength = password.length();
		int loginMaxLength = Config.LOGIN_MAX_LENGTH;
		int loginMinLength = Config.LOGIN_MIN_LENGTH;
		int passwordMaxLength = Config.PASSWORD_MAX_LENGTH;
		int passwordMinLength = Config.PASSWORD_MIN_LENGTH;
		String loginAllowedSigns = Config.LOGIN_ALLOWED_SIGNS;
		String passwordAllowedSigns = Config.PASSWORD_ALLOWED_SIGNS;

		if (loginLength <= loginMaxLength && loginLength >= loginMinLength)
		if (passwordLength < passwordMaxLength && passwordLength > passwordMinLength)
		if (DataContainOnlyAllowedSign(login, loginAllowedSigns))
		if (DataContainOnlyAllowedSign(password, passwordAllowedSigns))
		return true;

		return false;
	}

	private boolean DataContainOnlyAllowedSign(String variable, String allowedSigns) {
		for (int i = 0; i < variable.length(); i++) {
			if (!allowedSigns.contains(variable.charAt(i) + ""))	return false;
		}
		
		return true;
	}
}
