package pl.krystian.TwiFac.Token;

public class TokenProceed {
	
	public TokenAuthenticationStatus getUserIDByToken(String token) {
		
		TokenAuthenticationStatus tokenAuthenticationStatus = new TokenAuthenticationStatus();
		int id;
		
		if(ListOfTokenUser.getList().containsKey(token)) {
			tokenAuthenticationStatus.setMessage("Id returned");
			tokenAuthenticationStatus.setSuccessed(true);
			tokenAuthenticationStatus.setId(id = ListOfTokenUser.getId(token));
		}
		else {
			tokenAuthenticationStatus.setMessage("Token has expired");
			tokenAuthenticationStatus.setSuccessed(false);
			tokenAuthenticationStatus.setId(-1);
		}
		
		return tokenAuthenticationStatus;
	}
	
	
	public TokenAuthenticationStatus LoginNewToken(LoginAndPassword loginAndPassword) {
		
		TokenAuthenticationStatus tokenAuthenticationStatus = new TokenAuthenticationStatus();
		
		String login = loginAndPassword.getLogin();
		String password = loginAndPassword.getPassword();
				
	}
	
	
	
}
