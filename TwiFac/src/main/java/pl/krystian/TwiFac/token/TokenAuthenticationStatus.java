package pl.krystian.TwiFac.token;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Component
public class TokenAuthenticationStatus{
	
	
	private String message;
	private boolean isSuccessed;
	
}
