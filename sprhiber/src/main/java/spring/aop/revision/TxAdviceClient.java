package spring.aop.revision;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
     
import spring.tx.Employee;
import spring.tx.Employee.Gender;

public class TxAdviceClient {
	
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("tx-advice.xml");
	EmployeeDAO dao=(EmployeeDAO) app.getBean("employeeDAO");
	SessionFactory fac=app.getBean(SessionFactory.class);
	dao.save(fac.openSession(),new Employee(12, "abs", 23,30000 ,4 , 7,Gender.FEMALE));
	
	}

}
