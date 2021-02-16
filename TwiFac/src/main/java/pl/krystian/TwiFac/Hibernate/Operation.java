package pl.krystian.TwiFac.Hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Operation {
	
	SessionFactory sessionFactory;
	
	public SessionFactory setUp() throws Exception{
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			return sessionFactory;
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
			return null;
		}
	}
}
