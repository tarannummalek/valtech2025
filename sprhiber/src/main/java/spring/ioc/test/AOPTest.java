package spring.ioc.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.ioc.Arithmatic;

class AOPTest {

	@Test
	void test() {
		
		
		ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("aop.xml");
		Arithmatic arithmatic=(Arithmatic) ctx.getBean("arith");
		System.out.println(arithmatic.getClass().getName());
		System.out.println(arithmatic.add(1, 3));
		System.out.println(arithmatic.mul(5, 4));
		System.out.println(arithmatic.add(7, 4));
		System.out.println(arithmatic.sub(5, 1));
		System.out.println(arithmatic.div(0, 1));
		ctx.close();
		
	}

}
