package pl.krystian.TwiFac.Token;

import java.util.concurrent.ThreadLocalRandom;

import pl.krystian.TwiFac.config.Config;

class TokenGenerator {

	private String allowedSignInToken;
	private int tokenLength;
	
	String Generate() {
		SetUp();
		
		String generatedToken = "";
		
		for(int i = 0; i < tokenLength; i++) {
			generatedToken = generatedToken + allowedSignInToken.charAt(ThreadLocalRandom
					.current().nextInt(0, allowedSignInToken.length()+1));
			
			if(ListOfTokenUser.isTokeAvailable(generatedToken)) {
				return null;
			}
		}
		return generatedToken;
	}
	
	
	private void SetUp() {
		allowedSignInToken = Config.TOKEN_ALLOWED_SIGNS;
		tokenLength = Config.TOKEN_LENGTH;
	}
}
