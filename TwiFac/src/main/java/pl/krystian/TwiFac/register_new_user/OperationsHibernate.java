package pl.krystian.TwiFac.register_new_user;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pl.krystian.TwiFac.Hibernate.Operation;


public class OperationsHibernate {

	Operation operation;
	
	SessionFactory sessionFactory;
	
	boolean isDbActive() {
		try {
			operation = new Operation();
			sessionFactory = operation.setUp();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	void setUserData(UserDataDAO userData) {		
		operation = new Operation();
		try {
			sessionFactory = operation.setUp();
		} catch (Exception e) {e.printStackTrace();}
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userData);
		session.getTransaction().commit();
		session.close();
	}
}
