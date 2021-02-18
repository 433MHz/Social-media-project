package pl.krystian.TwiFac.Token;

import java.util.concurrent.ThreadLocalRandom;

class TokenGenerator {

	private String allowedSignInToken = "0123456789qwertyuiopasdfghjklzxcvbnm!@#$%^&*()";
	private int tokenLength = 160;
	
	String Generate() {
		String generatedToken = "";
		
		for(int i = 0; i < tokenLength; i++) {
			generatedToken = generatedToken + allowedSignInToken.charAt(ThreadLocalRandom
					.current().nextInt(0, allowedSignInToken.length()+1));
		}
		return generatedToken;
	}
}
