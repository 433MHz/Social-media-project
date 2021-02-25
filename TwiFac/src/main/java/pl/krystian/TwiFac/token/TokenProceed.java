package pl.krystian.TwiFac.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

class TokenProceed {
	 
	@Autowired
	ApplicationContext context;
	
	TokenAuthenticationStatusExtended GetUserIDByToken(String token) {
		TokenAuthenticationStatusExtended tokenAuthenticationStatus;
		
		if(ListOfTokenUser.getList().containsKey(token))	tokenAuthenticationStatus = context.getBean(TokenAuthenticationStatusExtended.class, "Id returned", true, ListOfTokenUser.getId(token));
		else												tokenAuthenticationStatus = context.getBean(TokenAuthenticationStatusExtended.class, "Token has expired", false, -1);
		
		return tokenAuthenticationStatus;
	}
	
	
	
	TokenAuthenticationStatusWithToken AddNewToken(LoginAndPassword loginAndPassword) {		
		
			// If login and password passed check successfully
		if(new LoginAndPasswordCheck().CanLoginAndPasswordBeUsed(loginAndPassword)) {
			
			// Get userID from database by parsing login and password
			int userID = new CheckLoginAndPasswordInDatabase().GetUserId(loginAndPassword);
			
			// When data to get id from database was invalid, then return this object
			if(userID == -1) {
				TokenAuthenticationStatusWithToken tokenAuthenticationStatus = context.getBean(TokenAuthenticationStatusWithToken.class, "Incorrect data", false, null);
				return tokenAuthenticationStatus;
			}
			
			// Generate token
			String token = new TokenGenerator().Generate();
			
			// Save token and user ID in HashMap list with token as a key and userID as a value
			ListOfTokenUser.Add(token, userID);
			
			TokenAuthenticationStatusWithToken tokenAuthenticationStatus = context.getBean(TokenAuthenticationStatusWithToken.class, "Added successfully", true, token);
			return tokenAuthenticationStatus;
		}
		
		TokenAuthenticationStatusWithToken tokenAuthenticationStatus = context.getBean(TokenAuthenticationStatusWithToken.class, "Wrong data format provided", false, null);
		return tokenAuthenticationStatus;	
	}	
}
