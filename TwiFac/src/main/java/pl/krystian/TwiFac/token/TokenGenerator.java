package pl.krystian.TwiFac.token;

import java.util.concurrent.ThreadLocalRandom;

import pl.krystian.TwiFac.config.Config;

class TokenGenerator {

	
	String Generate() {
		
		String generatedToken = "";
		
		for(int i = 0; i < Config.TOKEN_LENGTH; i++) {
			generatedToken = generatedToken + Config.TOKEN_ALLOWED_SIGNS.charAt(ThreadLocalRandom.current().nextInt(0, Config.TOKEN_ALLOWED_SIGNS.length()+1));
			
			if(ListOfTokenUser.isTokeAvailable(generatedToken))		return null;
		}
		return generatedToken;
	}
}
