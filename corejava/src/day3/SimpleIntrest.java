package day3;

public interface SimpleIntrest {
	public default double computeIntrest(double principle,double rateOfIntrest,double duration) {
		
		
		return principle*rateOfIntrest*duration/100;
		
	}
	

}
