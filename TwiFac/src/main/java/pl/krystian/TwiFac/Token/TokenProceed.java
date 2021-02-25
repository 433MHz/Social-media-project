package pl.krystian.TwiFac.Token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

class TokenProceed {
	 
	@Autowired
	ApplicationContext context;
	
	TokenAuthenticationStatusExtended GetUserIDByToken(String token) {
		
		TokenAuthenticationStatusExtended tokenAuthenticationStatus = context.getBean(TokenAuthenticationStatusExtended.class);
		
		if(ListOfTokenUser.getList().containsKey(token)) {
			tokenAuthenticationStatus.setMessage("Id returned");
			tokenAuthenticationStatus.setSuccessed(true);
			tokenAuthenticationStatus.setId(ListOfTokenUser.getId(token));
		}
		
		else {
			tokenAuthenticationStatus.setMessage("Token has expired");
			tokenAuthenticationStatus.setSuccessed(false);
			tokenAuthenticationStatus.setId(-1);
		}
		
		return tokenAuthenticationStatus;
	}
	
	
	
	
	
	
	TokenAuthenticationStatusWithToken AddNewToken(LoginAndPassword loginAndPassword) {		
		
			// If login and password passed check successfully
		if(new LoginAndPasswordCheck().CanLoginAndPasswordBeUsed(loginAndPassword)) {
			
			// Get userID from database by parsing login and password
			int userID = new CheckLoginAndPasswordInDatabase().GetUserId(loginAndPassword);
			
			// When data to get id from database was invalid, then return this object
			if(userID == -1) {
				TokenAuthenticationStatusWithToken tokenAuthenticationStatus = context.getBean(TokenAuthenticationStatusWithToken.class);
				tokenAuthenticationStatus.setMessage("Incorrect data");
				tokenAuthenticationStatus.setSuccessed(false);
				tokenAuthenticationStatus.setToken(null);
				
				return tokenAuthenticationStatus;
			}
			
			// Generate token
			String token = new TokenGenerator().Generate();
			
			// Save token and user ID in HashMap list with token as a key and userID as a value
			ListOfTokenUser.Add(token, userID);
			
			TokenAuthenticationStatusWithToken tokenAuthenticationStatus = context.getBean(TokenAuthenticationStatusWithToken.class);
			tokenAuthenticationStatus.setMessage("Added successfully");
			tokenAuthenticationStatus.setSuccessed(true);
			tokenAuthenticationStatus.setToken(token);
			
			return tokenAuthenticationStatus;
		}
		
		TokenAuthenticationStatusWithToken tokenAuthenticationStatus = context.getBean(TokenAuthenticationStatusWithToken.class);
		tokenAuthenticationStatus.setMessage("Wrong data format provided");
		tokenAuthenticationStatus.setSuccessed(false);
		tokenAuthenticationStatus.setToken(null);
		
		return tokenAuthenticationStatus;
				
	}
	
	
	
}
