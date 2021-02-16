package pl.krystian.TwiFac.register_new_user;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Setter
@Getter
public class RegistrationStatus {
	private String message;
	private boolean isSuccess;
}
