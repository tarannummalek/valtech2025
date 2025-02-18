package day3;

public class Outer {
	
	private int a;
	
	public void outerPrint() {
		System.out.println("outer print "+a );
	}
	
	public static class StaticInner{
		public void print(Outer o) {
			System.out.println("A ="+o.a);
		}
	}
	
	public static abstract class Just {
		abstract void print();
	}
	
	public static class JustImpl extends Just{

		@Override
		void print() {
			// TODO Auto-generated method stub
			System.out.println( "Just im[pl");
			
		}
		
	}
	
	
	public class inner{
		
		private int b;
		public void print() {
			System.out.println("inner print : A "+a+ " B "+b);
		}
		
		public void addOne() {
			b++;
			a++;
			
		}
	}
	public static void main(String[] args) {
		Outer o=new Outer();
		Outer.inner i=o.new inner();
		i.addOne();
		Outer.inner i1=o.new inner();
		i.print();
		i1.print();
		
		Outer o1=new Outer();
		Outer.inner i2=o.new inner();
		i.addOne();
		
		i.print();
		i2.print();
		
		
		Outer.StaticInner  si=new StaticInner();
		si.print(o1);
		
		
		Just j=new JustImpl();
		j.print();
		Just j1=new Just() {

			@Override
			void print() {
			System.out.println("Just only");
				
			}};
			j1.print();
		
		
			
		
		}
	

}
