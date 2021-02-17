package pl.krystian.TwiFac.register_new_user;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pl.krystian.TwiFac.Hibernate.Operation;


public class OperationsHibernate {

	@Autowired
	Operation operation;
	SessionFactory sessionFactory;
	
	boolean isDbActive() {
		try {
			sessionFactory = operation.setUp();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	void setUserData() {		
		try {
			sessionFactory = operation.setUp();
		} catch (Exception e) {e.printStackTrace();}
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(new UserData(1, "Krystian", "Izdebski", "Izdebski"));
		session.getTransaction().commit();
		session.close();
	}
}
