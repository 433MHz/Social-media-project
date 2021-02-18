package pl.krystian.TwiFac.Token;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pl.krystian.TwiFac.Hibernate.Operation;
import pl.krystian.TwiFac.Hibernate.UserDataDAO;

class CheckLoginAndPassword {

	int check(LoginAndPassword loginAndPassword) {
		String login = loginAndPassword.getLogin();
		String password = loginAndPassword.getPassword();
		
		Operation operation = new Operation();
		
		SessionFactory sessionFactory = null;;
		
		try {
			sessionFactory = operation.setUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<UserDataDAO> result = session.createQuery("from user_data").list();
		
		for (UserDataDAO userData : result) {
			if(login.equals(userData.getLogin())) {
				if(password.equals(userData.getPassword())) {
					return userData.getId();
				}
			}
		}
		return -1;
	}
}
