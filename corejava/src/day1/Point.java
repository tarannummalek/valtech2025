package day1;

public class Point {
	
	public Point() {
		
	}
	
	
	public final double getX() {
		return x;
	}

	public final void setX(double x) {
		this.x = x;
	}

	public final double getY() {
		return y;
	}

	public final void setY(double y) {
		this.y = y;
	}


	private static double ORIGIN=0;
	private double x;
	private double y;
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public static void main(String[] args) {
		Point p=new Point(10,20);
		System.out.println(p);
		System.out.println(p.distance(p));
		System.out.println(p.distance(21, 32));
		System.out.println(p.distance());
		
	}
	public double distance () {
		return Math.sqrt(x*x + y*y);
		
	}
	
	public double distance (double x1,double y1) {
		
		double diffx=x1-x;
		double diffy=y1-y;
		return Math.sqrt(diffx*diffx + diffy*diffy);
	}

	public double distance (Point p) {
		return distance(p.x,p.y);
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}
