package day2;

public class ArithmaticImpl implements Arithmatic{


	public double add(double a, double b) {
		return a+b;
	}

	
	public double sub(double a, double b) {
		return a-b;
	}

	
	public double mul(double a, double b) {
		return a*b;
	}

	
	public double div(double a, double b) {
		return a/b;
	}


	@Override
	public int div(int a, int b) {
		
		return a/b;
	}
	
	public void testWithDouble() {
		
	}
	
	

//	public static void main(String[] args) {
//		ArithmaticImpl arithmaticImpl=new ArithmaticImpl();
//		arithmaticImpl.add(a, b);
//	}
//}
}