package spring.test;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.tx.Employee;
import spring.tx.Employee.Gender;
import spring.tx.EmployeeService;

public class TxClient {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("tx-hib-ann.xml");
		EmployeeService es=context.getBean(EmployeeService.class);
		//es.getAll().forEach(e->System.out.println(e));
		System.out.println(es.getClass().getName());
//		es.save(new Employee(11L,"10",10,1,10,10,Gender.FEMALE));
		Employee e=es.get(10);
//		System.out.println(e);
		context.close();
		
		
	}

}
