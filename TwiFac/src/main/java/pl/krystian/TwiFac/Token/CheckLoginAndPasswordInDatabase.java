package pl.krystian.TwiFac.Token;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import pl.krystian.TwiFac.Hibernate.Operation;
import pl.krystian.TwiFac.Hibernate.UserDataDAO;

class CheckLoginAndPasswordInDatabase {
	
	@Autowired
	ApplicationContext context;

	int GetUserId(LoginAndPassword loginAndPassword) {
		String login = loginAndPassword.getLogin();
		String password = loginAndPassword.getPassword();
				
		Operation operation = context.getBean(Operation.class);
		
		SessionFactory sessionFactory = null;
		
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
