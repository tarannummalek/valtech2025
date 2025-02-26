package hibernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import hibernate.Car;

public class HibernateClient {
	
	public static void main(String[] args) {
		SessionFactory sesFac=new AnnotationConfiguration().addClass(Car.class).buildSessionFactory();
	Session ses=sesFac.openSession();
	ses.close();
	sesFac.close();
	
	}

}
