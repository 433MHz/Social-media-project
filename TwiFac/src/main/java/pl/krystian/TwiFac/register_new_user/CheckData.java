package pl.krystian.TwiFac.register_new_user;

class CheckData {
	
	final private int LOGIN_MAX_LENGTH = 5;
	final private int LOGIN_MIN_LENGTH = 5;
	final private int PASSWORD_MAX_LENGTH = 5;
	final private int PASSWORD_MIN_LENGTH = 5;

	
	public RegistrationStatus start(UserData userData) {
		String password = userData.getPassword();
		String rPassword = userData.getRPassword();
		String login = userData.getLogin();
		
		passwordsCorrect(password, rPassword);
		loginCorrect(login);
	}
	
	
	
	
	
	
	private boolean passwordsCorrect(String password, String rPassword) {
		Boolean passwordStatus[] = {
				passwordTooLong(password),
				passwordTooShort(password),
				passwordContainForbiddenSigns(password),
				passwordsAreDifferent(password, rPassword)
		};
		
		for (Boolean status : passwordStatus) {
			if(status) return false;
		}
		return true;
	}
	
	
	
	
	
	
	private boolean loginCorrect(String login) {
		Boolean loginStatus[] = {
				loginTooLong(login),
				loginTooShort(login),
				loginContainForbiddenSigns(login),
				loginIsNotInDatabase(login)
		};
		
		for (Boolean status : loginStatus) {
			if(status) return false;
		}
		return true;
	}
	
	
	
	
	
	
	private boolean passwordTooLong(String password) {
		if(password.length() >= PASSWORD_MAX_LENGTH) return true;
		else return false;
	}
	
	
	
	
	
	
	private boolean passwordTooShort(String password) {
		if(password.length() <= PASSWORD_MIN_LENGTH) return true;
		else return false;
	}
	
	
	
	
	
	
	private boolean passwordContainForbiddenSigns(String password){
		
	}
	
	
	
	
	
	
	private boolean passwordsAreDifferent(String password, String rPassword) {
		if(password.equals(rPassword)) return false;
		else return true;
	}
	
	
	
	
	
	
	private boolean loginTooLong(String login) {
		if(login.length() >= LOGIN_MAX_LENGTH) return true;
		else return false;
	}
	
	
	
	
	
	
	private boolean loginTooShort(String login) {
		if(login.length() <= LOGIN_MIN_LENGTH) return true;
		else return false;
	}
	
	
	
	
	
	
	private boolean loginContainForbiddenSigns(String login) {
		
	}
	
	
	
	
	
	
	private boolean loginIsNotInDatabase(String login) {
		
	}
}
