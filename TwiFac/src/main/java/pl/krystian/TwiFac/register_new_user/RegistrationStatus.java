package pl.krystian.TwiFac.register_new_user;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Component
@Setter
@Getter
@AllArgsConstructor
public class RegistrationStatus {
	private String message;
	private boolean isSuccess;
}
