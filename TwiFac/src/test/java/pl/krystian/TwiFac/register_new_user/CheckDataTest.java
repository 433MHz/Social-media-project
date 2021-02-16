package pl.krystian.TwiFac.register_new_user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CheckDataTest {

	@Test
	@DisplayName("Correct values, should return true and \"Succesfully created\" message")
	void testStart_Correct_Values() {
		CheckData checkData = new CheckData();
		UserData userData = new UserData();
		userData.setLogin("Krystian");
		userData.setPassword("Password123");
		userData.setRPassword("Password123");
		
		
		assertEquals("Succesfully created", checkData.start(userData).getMessage());
		assertEquals(true, checkData.start(userData).isSuccess());
	}
	
	@Test
	@DisplayName("Password is too long")
	void testStart_Password_Too_Long() {
		CheckData checkData = new CheckData();
		UserData userData = new UserData();
		userData.setLogin("Krystian");
		userData.setPassword("pppppasswordwithmorethan30digits");
		userData.setRPassword("pppppasswordwithmorethan30digits");
		
		assertEquals("Check if password is correct (5 - 30 digits or used forbidden signs)", checkData.start(userData).getMessage());
		assertEquals(false, checkData.start(userData).isSuccess());
	}

}
