package pl.krystian.TwiFac.Token;

public class Token {
	
	public TokenAuthenticationStatusExtended GetUserIDUsingToken(String token) {
		return new TokenProceed().GetUserIDByToken(token);
	}
	
	public TokenAuthenticationStatusWithToken GenerateToken(LoginAndPassword loginAndPassword) {
		return new TokenProceed().AddNewToken(loginAndPassword);
	}
}
