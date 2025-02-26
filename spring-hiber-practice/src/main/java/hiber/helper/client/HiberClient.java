package hiber.helper.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import hiber.practice.Course;
import hiber.practice.Student;




public class HiberClient {
	
	public static void main(String[] args) {
		
		SessionFactory sf=new AnnotationConfiguration().addAnnotatedClass(Student.class).addAnnotatedClass(Course.class).buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		Student student=new Student("tarannum");
		Course course=new Course("AI");
		t.commit();
		s.close();
		sf.close();
		//Course course=new Course("AI");
	}
	


}
