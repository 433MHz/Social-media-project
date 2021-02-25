package pl.krystian.TwiFac.Token;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
public class TokenAuthenticationStatusWithToken extends TokenAuthenticationStatus{

	public TokenAuthenticationStatusWithToken(String message, boolean isSuccessed, String token) {
		super(message, isSuccessed);
		this.token = token;
	}

	private String token;
}
