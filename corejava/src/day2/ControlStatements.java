package day2;

public class ControlStatements {
	
	public void testIfElse(int a ) {
		
		
		if(a%2==0) {
			System.out.println("A = "+ a+"is even");
		}else {
			System.out.println("A = "+ a+"is odd");
		}
			
	}
	public void testfor(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
			
		}
	}
	
	public void add(int ... a) {
		int sum=0;
		for (int i = 0; i < a.length; i++) {
			sum+=a[i];
			
			
		}System.out.println(sum);
	}
	public static void main(String[] args) {
		ControlStatements controlStatements=new ControlStatements();
		controlStatements.testIfElse(2);
		controlStatements.testIfElse(9);
		controlStatements.testfor(new int[] {1,6,3,0,2,8,6});
		controlStatements.testSwitch(8);
		controlStatements.add(1,2,3,4,5,6,7);
	}
	public void testSwitch(int a) {
		switch (a) {
		case 1:System.out.println("one ");break;
		case 2:System.out.println("two");break;
		case 3:System.out.println("three");break;
		default:System.out.println("all others ");
		
		
		}
	}

}
