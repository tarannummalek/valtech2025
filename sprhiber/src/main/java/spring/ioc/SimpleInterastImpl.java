package spring.ioc;

public class SimpleInterastImpl implements SimpleInterast {
	
	private Arithmatic arithmatic;
	
	public int compute(int prin, int time , int rate ) {
		return arithmatic.div(arithmatic.mul(prin*time, rate),100);
	}
	public void setArithmatic(Arithmatic arithmatic) {
		this.arithmatic = arithmatic;
	}

}
