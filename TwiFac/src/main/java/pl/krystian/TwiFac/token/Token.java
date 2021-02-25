package pl.krystian.TwiFac.token;

public class Token {
	
	public TokenAuthenticationStatusExtended GetUserIDUsingToken(String token) {
		return new TokenProceed().GetUserIDByToken(token);
	}
	
	public TokenAuthenticationStatusWithToken GenerateToken(LoginAndPassword loginAndPassword) {
		return new TokenProceed().AddNewToken(loginAndPassword);
	}
}
