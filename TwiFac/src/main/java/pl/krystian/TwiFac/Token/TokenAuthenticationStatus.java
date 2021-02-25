package pl.krystian.TwiFac.Token;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
public class TokenAuthenticationStatus{
	
	
	private String message;
	private boolean isSuccessed;
	
}
