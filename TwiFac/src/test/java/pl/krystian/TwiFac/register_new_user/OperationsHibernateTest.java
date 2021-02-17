package pl.krystian.TwiFac.register_new_user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperationsHibernateTest {

	@Test
	@DisplayName(value = "Database is online")
	void testIsDbActive_Active() {
		OperationsHibernate operationsHibernate = new OperationsHibernate();
		assertEquals(true, operationsHibernate.isDbActive());
	}
	
	@Test
	@DisplayName(value = "Database is offline")
	void testIsDbActive_NotActive(){
		
	}

}
