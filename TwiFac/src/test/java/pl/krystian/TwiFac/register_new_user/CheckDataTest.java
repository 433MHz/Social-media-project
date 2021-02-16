package pl.krystian.TwiFac.register_new_user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CheckDataTest {

	@Test
	@DisplayName("Correct values case")
	void testStart_Correct_Values() {
		CheckData checkData = new CheckData();
		UserData userData = new UserData();
		userData.setLogin("Krystian");
		userData.setPassword("Password123");
		userData.setRPassword("Password123");
		
		
		assertEquals("Succesfully created", checkData.Start(userData).getMessage());
		assertEquals(true, checkData.Start(userData).isSuccess());
	}
	
	@Test
	@DisplayName("Password is too long case")
	void testStart_Password_Too_Long() {
		CheckData checkData = new CheckData();
		UserData userData = new UserData();
		userData.setLogin("Krystian");
		userData.setPassword("pppppasswordwithmorethan30digits");
		userData.setRPassword("pppppasswordwithmorethan30digits");
		
		assertEquals("Check if password is correct (5 - 30 digits or used forbidden signs)", checkData.Start(userData).getMessage());
		assertEquals(false, checkData.Start(userData).isSuccess());
	}
	
	@Test
	@DisplayName("Password is too short case")
	void testStart_Password_Too_Short() {
		
		CheckData checkData = new CheckData();
		UserData userData = new UserData();
		userData.setLogin("Krystian");
		userData.setPassword("jjjj");
		userData.setRPassword("jjjj");
		
		assertEquals("Check if password is correct (5 - 30 digits or used forbidden signs)", checkData.Start(userData).getMessage());
		assertEquals(false, checkData.Start(userData).isSuccess());
	}
	
	@Test
	@DisplayName("Passwords are not same")
	void testStart_PasswordsNotSame() {
		
		CheckData checkData = new CheckData();
		UserData userData = new UserData();
		userData.setLogin("Krystian");
		userData.setPassword("krystian");
		userData.setRPassword("tomekk");
		
		assertEquals("Check if password is correct (5 - 30 digits or used forbidden signs)", checkData.Start(userData).getMessage());
		assertEquals(false, checkData.Start(userData).isSuccess());
	}
	
	@Test
	@DisplayName("Login is too long")
	void testStart_LoginTooLong() {
		
		CheckData checkData = new CheckData();
		UserData userData = new UserData();
		userData.setLogin("11111111111111111111111111111122222");
		userData.setPassword("aaaaaaaaaa");
		userData.setRPassword("aaaaaaaaaa");
		
		assertEquals("Check if login is correct (5 - 30 digits or used forbidden signs)", checkData.Start(userData).getMessage());
		assertEquals(false, checkData.Start(userData).isSuccess());
	}
	
	@Test
	@DisplayName("Login is too short")
	void testStart_LoginTooShort() {
		
		CheckData checkData = new CheckData();
		UserData userData = new UserData();
		userData.setLogin("krys");
		userData.setPassword("aaaaaaaaaa");
		userData.setRPassword("aaaaaaaaaa");
		
		assertEquals("Check if login is correct (5 - 30 digits or used forbidden signs)", checkData.Start(userData).getMessage());
		assertEquals(false, checkData.Start(userData).isSuccess());
	}
	
}
