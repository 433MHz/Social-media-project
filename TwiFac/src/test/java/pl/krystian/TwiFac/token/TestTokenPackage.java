package pl.krystian.TwiFac.token;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import pl.krystian.TwiFac.config.Config;
import pl.krystian.TwiFac.token.LoginAndPassword;
import pl.krystian.TwiFac.token.LoginAndPasswordCheck;

class TestTokenPackage {

	
		@Nested
		@TestInstance(Lifecycle.PER_CLASS)
		class TestLoginAndPassword {
			
			int LOGIN_MAX_LENGTH;
			int LOGIN_MIN_LENGTH;
			int PASSWORD_MAX_LENGTH;
			int PASSWORD_MIN_LENGTH;
			String LOGIN_ALLOWED_SIGNS;
			String PASSWORD_ALLOWED_SIGNS;
			
			@BeforeAll
			void setUpOnce() {
				LOGIN_MAX_LENGTH = Config.LOGIN_MAX_LENGTH;
				LOGIN_MIN_LENGTH = Config.LOGIN_MIN_LENGTH;
				PASSWORD_MAX_LENGTH = Config.PASSWORD_MAX_LENGTH;
				PASSWORD_MIN_LENGTH = Config.PASSWORD_MIN_LENGTH;
				LOGIN_ALLOWED_SIGNS = Config.LOGIN_ALLOWED_SIGNS;
				PASSWORD_ALLOWED_SIGNS = Config.PASSWORD_ALLOWED_SIGNS;
			}
			
			@Nested
			@DisplayName("Nested login tests")
			@TestInstance(Lifecycle.PER_CLASS)
			class TestLogin{
				LoginAndPassword loginAndPassword;
				LoginAndPasswordCheck loginAndPasswordCheck;
				String textToCut;
				String password;
				
				@BeforeAll
				void setUpOnce() {
					int randomNum = ThreadLocalRandom.current().nextInt(PASSWORD_MIN_LENGTH, PASSWORD_MAX_LENGTH+1);
					password = "";
					for(int i = 0; i < randomNum; i++) {
						char randomChar = PASSWORD_ALLOWED_SIGNS.charAt(ThreadLocalRandom.current().nextInt(0, PASSWORD_ALLOWED_SIGNS.length()));
						password = password + randomChar+"";
					}
				}
				
				@BeforeEach
				void setUpForAll() {
					loginAndPassword = new LoginAndPassword();
					loginAndPasswordCheck = new LoginAndPasswordCheck();
					textToCut = "";
					int allowedSignsLength = LOGIN_ALLOWED_SIGNS.length();

					for(int i = 0; i < 300; i++) {
						int randomNum = ThreadLocalRandom.current().nextInt(0, allowedSignsLength);
						textToCut = textToCut + LOGIN_ALLOWED_SIGNS.charAt(randomNum);
					}
					
				}
				
				@Test
				@DisplayName("Login too long case")
				void TestLoginTooLong() {
					for(int i = 0; i < 1000; i++) {
					int randomNum = ThreadLocalRandom.current().nextInt(LOGIN_MAX_LENGTH + 1, 200);
					String login = textToCut.substring(0, randomNum);
					loginAndPassword.setLogin(login);
					loginAndPassword.setPassword(password);
					
					System.out.println(login + " | " + password);
					assertEquals(false, loginAndPasswordCheck.CanLoginAndPasswordBeUsed(loginAndPassword));
					}
				}
				
				@Test
				@DisplayName("Login too short case")
				void TestLoginTooShort() {
					for(int i = 0; i < 1000; i++) {
						int randomNum = ThreadLocalRandom.current().nextInt(0, LOGIN_MIN_LENGTH);
						String login = textToCut.substring(0, randomNum);
						loginAndPassword.setLogin(login);
						loginAndPassword.setPassword(password);
						
						System.out.println(login + " | " + password);
						assertEquals(false, loginAndPasswordCheck.CanLoginAndPasswordBeUsed(loginAndPassword));
						}
				}
				
				@Test
				@DisplayName("Login contain disallowed signs case")
				void TestLoginContainDisallowedSigns() {
					for(int i = 0; i < 1000; i++) {
						int randomNum = ThreadLocalRandom.current().nextInt(LOGIN_MIN_LENGTH - 1, LOGIN_MAX_LENGTH);
						String login = textToCut.substring(0, randomNum) + "*";
						loginAndPassword.setLogin(login);
						loginAndPassword.setPassword(password);
						
						System.out.println(login + " | " + password);
						assertEquals(false, loginAndPasswordCheck.CanLoginAndPasswordBeUsed(loginAndPassword));
						}
				}
				
				@Test
				@DisplayName("Login is OK")
				void TestLoginIsWorking() {
					for(int i = 0; i < 1000; i ++) {
					loginAndPassword.setPassword(password);
					
					int rangeNum = ThreadLocalRandom.current().nextInt(LOGIN_MIN_LENGTH, LOGIN_MAX_LENGTH + 1);
					int randomNum = ThreadLocalRandom.current().nextInt(0, textToCut.length() - rangeNum);
					
					String login = textToCut.substring(randomNum, randomNum + rangeNum);
					
					loginAndPassword.setLogin(login);
					System.out.println("Working Login " + login + " | " + password + " Login length: " + login.length() + " Password length: " + password.length());
					assertEquals(true, loginAndPasswordCheck.CanLoginAndPasswordBeUsed(loginAndPassword));
					}
				}
			}
			
			@Nested
			class TestPassword{
				void TestPasswordTooLong() {
					
				}
				
				void TestPasswordTooShort() {
					
				}
				
				void TestPasswordContainDisallowedSigns() {
					
				}
			}
		}
}
