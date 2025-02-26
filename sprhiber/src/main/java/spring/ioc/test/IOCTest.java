package spring.ioc.test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.ioc.SimpleInterast;
import spring.ioc.UtilsBean;

class IOCTest {
	
	
	@Test
	void tsetParentChild() {
		
		ClassPathXmlApplicationContext parent=new ClassPathXmlApplicationContext("parent.xml");
		ClassPathXmlApplicationContext child=new ClassPathXmlApplicationContext(new String[]{"NewFile.xml"},parent);
		System.out.println(child.getBean("line"));

	
	}

	@Test
	void test() {

		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("ioc.xml");
		SimpleInterast si=(SimpleInterast) ctx.getBean("si");
	//	assertEquals(200,si.compute(200,20,5));
		
		System.out.println(ctx.getBean("p"));
		System.out.println(ctx.getBean("p1"));
		System.out.println(ctx.getBean("line"));
		System.out.println(ctx.getBean("line1"));
		System.out.println(ctx.getBean("line2"));
		
		ctx.close();
	
	}
	
	@Test
	void testUtils() {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("utils.xml");
		UtilsBean bean=(UtilsBean) ctx.getBean("utils");
		System.out.println(bean.getNames());
		bean.getPoints().forEach(t->System.out.println(t));
		
		System.out.println(bean.getNumbers());
		System.out.println(bean.getProperties());
		SimpleInterast simpleInterast=(SimpleInterast) ctx.getBean("si");
		System.out.println(simpleInterast.compute(200, 3, 4));
		
		
		try {
			
			SimpleInterast simpleInterast1=(SimpleInterast) ctx.getBean("siAbs");
			System.out.println(simpleInterast1.compute(200, 3, 4));
			fail("no exception");
			
		}catch(Exception e) {
			System.err.print(e.getMessage());
			
		}
	}

}
