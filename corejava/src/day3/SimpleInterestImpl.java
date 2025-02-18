package day3;

public class SimpleInterestImpl implements SimpleIntrest {
	public static void main(String[] args) {
		SimpleIntrest si=new SimpleInterestImpl();
		System.out.println(si.computeIntrest(2000, 3, 5));
		
		SimpleIntrest newSi=new SimpleInterestImpl() {

			@Override
			public double computeIntrest(double principle, double rateOfIntrest, double duration) {
				return super.computeIntrest(principle, rateOfIntrest, duration);
			}
			
			
		};
		System.out.println(newSi.computeIntrest(2000, 3, 5));
				
//		SimpleIntrest lambdaSi=
//			(double p,double r,double d)->{p*r*d/100;}
//			
//		}
		//System.out.println(si.computeIntrest(2000, 3, 5));
	}

}
