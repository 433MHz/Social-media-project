package pl.krystian.TwiFac.register_new_user;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pl.krystian.TwiFac.config.Config;

class CheckDataTest {
	static String LOGIN_ALLOWED_SIGNS;
	static String PASSWORD_ALLOWED_SIGNS;
	static int LOGIN_MIN_LENGTH;
	static int LOGIN_MAX_LENGTH;
	static int PASSWORD_MIN_LENGTH;
	static int PASSWORD_MAX_LENGTH;
	
	CheckData checkData;
	UserData userData;
	
	@BeforeAll
	static void setVariables() {
		LOGIN_ALLOWED_SIGNS = Config.LOGIN_ALLOWED_SIGNS;
		PASSWORD_ALLOWED_SIGNS = Config.PASSWORD_ALLOWED_SIGNS;
		LOGIN_MIN_LENGTH = Config.LOGIN_MIN_LENGTH;
		PASSWORD_MIN_LENGTH = Config.PASSWORD_MIN_LENGTH;
		LOGIN_MAX_LENGTH = Config.LOGIN_MAX_LENGTH;
		PASSWORD_MAX_LENGTH = Config.PASSWORD_MAX_LENGTH;
	}
	
	@Test
	@DisplayName("Send 1000 correct logins")
	void testCheck_correctLogin() {
		String password = "123456789";
		checkData = new CheckData();
		userData = new UserData();
		
		for(int i = 0; i < 1000; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(LOGIN_MIN_LENGTH,LOGIN_MAX_LENGTH+1);
			String login = "";
			for(int x = 0; x < randomNum; x++) {
				login = login + LOGIN_ALLOWED_SIGNS.charAt(ThreadLocalRandom.current().nextInt(0,LOGIN_ALLOWED_SIGNS.length()));
			}
			userData.setLogin(login);
			userData.setPassword(password);
			userData.setrPassword(password);
			assertEquals("User sucessfully created", checkData.Check(userData).getMessage());
			assertEquals(true, checkData.Check(userData).isSuccess());
		}
	}
	
	@Test
	@DisplayName("Send 1000 too long logins")
	void testCheck_tooLongLogin() {
		checkData = new CheckData();
		userData = new UserData();
		
		for(int i = 0; i < 1000; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(LOGIN_MAX_LENGTH + 1,1000+1);
			String login = "";
			for(int x = 0; x < randomNum; x++) {
				login = login + LOGIN_ALLOWED_SIGNS.charAt(ThreadLocalRandom.current().nextInt(0, LOGIN_ALLOWED_SIGNS.length()));
			}
			userData.setLogin(login);
			userData.setPassword("1234567");
			userData.setrPassword("1234567");
			
			assertEquals("Login is too long", checkData.Check(userData).getMessage());
			assertEquals(false, checkData.Check(userData).isSuccess());
		}
	}
	
	@Test
	@DisplayName("Send 1000 too short logins")
	void testCheck_tooShortLogin() {
		checkData = new CheckData();
		userData = new UserData();
		
		for(int i = 0; i < 1000; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(LOGIN_MIN_LENGTH - 4, LOGIN_MIN_LENGTH);
			String login = "";
			for(int x = 0; x < randomNum; x++) {
				login = login + LOGIN_ALLOWED_SIGNS.charAt(ThreadLocalRandom.current().nextInt(0, LOGIN_ALLOWED_SIGNS.length()));
			}
			userData.setLogin(login);
			userData.setPassword("1234567");
			userData.setrPassword("1234567");
			
			assertEquals("Login is too short", checkData.Check(userData).getMessage());
			assertEquals(false, checkData.Check(userData).isSuccess());
		}
	}
	
	@Test
	@DisplayName("Send 1000 too long passwords")
	void testCheck_tooLongPassword() {
		checkData = new CheckData();
		userData = new UserData();
		
		for(int i = 0; i < 1000; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(LOGIN_MAX_LENGTH + 1,1000+1);
			String password = "";
			for(int x = 0; x < randomNum; x++) {
				password = password + PASSWORD_ALLOWED_SIGNS.charAt(ThreadLocalRandom.current().nextInt(0, PASSWORD_ALLOWED_SIGNS.length()));
			}
			userData.setLogin("1234567");
			userData.setPassword(password);
			userData.setrPassword(password);
			
			assertEquals("Password is too long", checkData.Check(userData).getMessage());
			assertEquals(false, checkData.Check(userData).isSuccess());
		}
	}
	
	@Test
	@DisplayName("Send 1000 too short passwords")
	void testCheck_tooShortPassword() {
		checkData = new CheckData();
		userData = new UserData();
		
		for(int i = 0; i < 1000; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(PASSWORD_MIN_LENGTH - 4, PASSWORD_MIN_LENGTH);
			String password = "";
			for(int x = 0; x < randomNum; x++) {
				password = password + PASSWORD_ALLOWED_SIGNS.charAt(ThreadLocalRandom.current().nextInt(0, PASSWORD_ALLOWED_SIGNS.length()));
			}
			userData.setLogin("1234567");
			userData.setPassword(password);
			userData.setrPassword(password);
			
			assertEquals("Password is too short", checkData.Check(userData).getMessage());
			assertEquals(false, checkData.Check(userData).isSuccess());
		}
	}
	
	void testCheck_passwordsNotEqual() {
		
	}
}
