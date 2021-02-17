package pl.krystian.TwiFac.register_new_user;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CheckDataTest {
	String LOGIN_ALLOWED_SIGNS = "0123456789QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
	String PASSWORD_ALLOWED_SIGNS = LOGIN_ALLOWED_SIGNS + "!@#$%^&*()_-+=";
	CheckData checkData;
	UserData userData;
	
	@Test
	@DisplayName("Send 1000 correct logins")
	void testCheck_correctLogin() {
		String password = "123456789";
		checkData = new CheckData();
		userData = new UserData();
		
		for(int i = 0; i < 1000; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(5,30+1);
			String login = "";
			for(int x = 0; x < randomNum; x++) {
				login = login + LOGIN_ALLOWED_SIGNS.charAt(ThreadLocalRandom.current().nextInt(0,LOGIN_ALLOWED_SIGNS.length()));
			}
			userData.setLogin(login);
			userData.setPassword(password);
			userData.setRPassword(password);
			assertEquals("User sucessfully created", checkData.Check(userData).getMessage());
			assertEquals(true, checkData.Check(userData).isSuccess());
		}
	}
	
	void testCheck_tooLongLogin() {
		
	}
	
	void testCheck_tooShortLogin() {
		
	}
	
	void testCheck_tooLongPassword() {
		
	}
	
	@Test
	@DisplayName("Send 1000 too short passwords")
	void testCheck_tooShortPassword() {
		checkData = new CheckData();
		userData = new UserData();
		
		for(int i = 0; i < 1000; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(1,4+1);
			String password = "";
			for(int x = 0; x < randomNum; x++) {
				password = password + PASSWORD_ALLOWED_SIGNS.charAt(ThreadLocalRandom.current().nextInt(0, PASSWORD_ALLOWED_SIGNS.length()));
			}
			userData.setLogin("1234567");
			userData.setPassword(password);
			userData.setRPassword(password);
			
			assertEquals("Password is too short", checkData.Check(userData).getMessage());
			assertEquals(false, checkData.Check(userData).isSuccess());
		}
	}
	
	void testCheck_passwordsNotEqual() {
		
	}
}
