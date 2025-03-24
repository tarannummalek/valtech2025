package webservices;

public class HelloWordImpl implements HelloWorld {

	@Override
	public String hello(String name) {
			return "Hello"+name;
	}
	

}
