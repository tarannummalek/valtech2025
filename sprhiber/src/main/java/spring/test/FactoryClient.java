package spring.test;

import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryClient {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("factory.xml");
		System.out.println(applicationContext.getBean("p1"));
		System.out.println(applicationContext.getBean("p1"));
		System.out.println(applicationContext.getBean("p1"));
		System.out.println(applicationContext.getBean("p1")==applicationContext.getBean("p1"));
		System.out.println(applicationContext.getBean("p2"));
	}

}
