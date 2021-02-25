package pl.krystian.TwiFac.Token;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
public class TokenAuthenticationStatusExtended extends TokenAuthenticationStatus{

	

	public TokenAuthenticationStatusExtended(String message, boolean isSuccessed, int id) {
		super(message, isSuccessed);
		this.id = id;
	}

	private int id;
}
