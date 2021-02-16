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

	public RegistrationStatus Start(UserData userData) {

		String password = userData.getPassword();
		String rPassword = userData.getRPassword();
		String login = userData.getLogin();

		boolean passwordOk = PasswordsCorrect(password, rPassword);
		boolean loginOk = LoginCorrect(login);
		RegistrationStatus registrationStatus = new RegistrationStatus();

		if (loginOk) {
			if (passwordOk) {
				if (LoginIsNotInDatabase(login)) {
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

	private boolean PasswordsCorrect(String password, String rPassword) {
		Boolean passwordStatus[] = { PasswordTooLong(password), PasswordTooShort(password),
				PasswordContainForbiddenSigns(password), PasswordsAreDifferent(password, rPassword) };

		for (Boolean status : passwordStatus) {
			if (status)
				return false;
		}
		return true;
	}

	private boolean LoginCorrect(String login) {
		Boolean loginStatus[] = { LoginTooLong(login), LoginTooShort(login), LoginContainForbiddenSigns(login), };

		for (Boolean status : loginStatus) {
			if (status)
				return false;
		}
		return true;
	}

	private boolean PasswordTooLong(String password) {
		if (password.length() >= PASSWORD_MAX_LENGTH)
			return true;
		else
			return false;
	}

	private boolean PasswordTooShort(String password) {
		if (password.length() <= PASSWORD_MIN_LENGTH)
			return true;
		else
			return false;
	}

	private boolean PasswordContainForbiddenSigns(String password) {

		for (int i = 0; i < password.length(); i++) {
			String letter = password.charAt(i) + "";

			if (PASSWORD_ALLOWED_SIGNS.contains(letter)) {

			} else
				return true;
		}
		return false;
	}

	private boolean PasswordsAreDifferent(String password, String rPassword) {
		if (password.equals(rPassword))
			return false;
		else
			return true;
	}

	private boolean LoginTooLong(String login) {
		if (login.length() >= LOGIN_MAX_LENGTH)
			return true;
		else
			return false;
	}

	private boolean LoginTooShort(String login) {
		if (login.length() <= LOGIN_MIN_LENGTH)
			return true;
		else
			return false;
	}

	private boolean LoginContainForbiddenSigns(String login) {

		for (int i = 0; i < login.length(); i++) {
			String letter = login.charAt(i) + "";

			if (LOGIN_ALLOWED_SIGNS.contains(letter)) {

			} else
				return true;
		}
		return false;
	}

	private boolean LoginIsNotInDatabase(String login) {
		Database database = new Database();
		return database.CheckIfUserIsInDatabase(login);
	}

}
