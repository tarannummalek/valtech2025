package day2;

public class ExceptionExample {
	
	
	
	
	
	
	public static void main(String[] args) {
		
		//Car c=new Car("Honda",)
		
		Authenticator authenticator=new Authenticator();	
		try {
			long code=authenticator.authenticate(null, "tiger1");
			System.out.println("Auth code:"+code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			System.out.println("in finally");
		}
	}

}
