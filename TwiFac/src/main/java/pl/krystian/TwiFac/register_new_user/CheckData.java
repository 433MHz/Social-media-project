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

	public RegistrationStatus start(UserData userData) {

		String password = userData.getPassword();
		String rPassword = userData.getRPassword();
		String login = userData.getLogin();

		boolean passwordOk = passwordsCorrect(password, rPassword);
		boolean loginOk = loginCorrect(login);
		RegistrationStatus registrationStatus = new RegistrationStatus();

		if (loginOk) {
			if (passwordOk) {
				if (loginIsNotInDatabase(login)) {
					String message = "Succesfully created";
					registrationStatus.setMessage(message);
					registrationStatus.setSuccess(true);
				} else {
					String message = "Username " + login + " is currently in use";
					registrationStatus.setMessage(message);
					registrationStatus.setSuccess(false);
				}
			} else {
				String message = "Check if password is correct (" + PASSWORD_MIN_LENGTH + " - " + PASSWORD_MAX_LENGTH
						+ " digits or used forbidden signs)";
				registrationStatus.setMessage(message);
				registrationStatus.setSuccess(false);
			}
		} else {
			String message = "Check if login is correct (" + LOGIN_MIN_LENGTH + " - " + LOGIN_MAX_LENGTH
					+ " digits or used forbidden signs)";
			registrationStatus.setMessage(message);
			registrationStatus.setSuccess(false);
		}

		return registrationStatus;
	}

	private boolean passwordsCorrect(String password, String rPassword) {
		Boolean passwordStatus[] = { passwordTooLong(password), passwordTooShort(password),
				passwordContainForbiddenSigns(password), passwordsAreDifferent(password, rPassword) };

		for (Boolean status : passwordStatus) {
			if (status)
				return false;
		}
		return true;
	}

	private boolean loginCorrect(String login) {
		Boolean loginStatus[] = { loginTooLong(login), loginTooShort(login), loginContainForbiddenSigns(login), };

		for (Boolean status : loginStatus) {
			if (status)
				return false;
		}
		return true;
	}

	private boolean passwordTooLong(String password) {
		if (password.length() >= PASSWORD_MAX_LENGTH)
			return true;
		else
			return false;
	}

	private boolean passwordTooShort(String password) {
		if (password.length() <= PASSWORD_MIN_LENGTH)
			return true;
		else
			return false;
	}

	private boolean passwordContainForbiddenSigns(String password) {

		for (int i = 0; i < password.length(); i++) {
			String letter = password.charAt(i) + "";

			if (PASSWORD_ALLOWED_SIGNS.contains(letter)) {

			} else
				return true;
		}
		return false;
	}

	private boolean passwordsAreDifferent(String password, String rPassword) {
		if (password.equals(rPassword))
			return false;
		else
			return true;
	}

	private boolean loginTooLong(String login) {
		if (login.length() >= LOGIN_MAX_LENGTH)
			return true;
		else
			return false;
	}

	private boolean loginTooShort(String login) {
		if (login.length() <= LOGIN_MIN_LENGTH)
			return true;
		else
			return false;
	}

	private boolean loginContainForbiddenSigns(String login) {

		for (int i = 0; i < login.length(); i++) {
			String letter = login.charAt(i) + "";

			if (LOGIN_ALLOWED_SIGNS.contains(letter)) {

			} else
				return true;
		}
		return false;
	}

	private boolean loginIsNotInDatabase(String login) {
		return false;
	}

}
