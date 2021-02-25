package pl.krystian.TwiFac.register_new_user;

import org.springframework.stereotype.Component;

import pl.krystian.TwiFac.hibernate.UserDataDAO;

@Component
public class User {

	public RegistrationStatus addNew(UserData userData) {
		/*
		 * 1. Check if userData is correct 
		 * 2. Check if database is active 
		 * 3. Send data
		 * to database 
		 * 4. Send message to frontend
		 */

		
		// Pre.
		OperationsHibernate operationsHibernate = new OperationsHibernate();
		RegistrationStatus registrationStatus;
		
		// 1.
		CheckData checkData = new CheckData();
		registrationStatus = checkData.Check(userData);
		
		// 2.
		if(!operationsHibernate.isDbActive()) {
			registrationStatus = new RegistrationStatus("Database error", false);
		}
		
		// 3.
		if(registrationStatus.isSuccess()) {
			UserDataDAO userDataDAO = new UserDataDAO();
			operationsHibernate.setUserData(userDataDAO);
		}
		
		// 4.
		return registrationStatus;
	}
}
