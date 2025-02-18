package day1;

public class Point3D extends Point {



	private double z;

	public Point3D() {
		
	}
	

	public final double getZ() {
		return z;
	}


	public final void setZ(double z) {
		this.z = z;
	}

// make method arguments final if method is not changing them
	
	public Point3D(final double x,final double y,final double z) {
		super(x,y);
		this.z = z;
	}

	@Override
	public double distance() {
		return distance(0,0,0);
	}
	public double distance (double x,double y,double z) {
		
		double diffx=getX()-x;
		double diffy=getY()-y;
		double diffz=getZ()-z;
		return Math.sqrt(diffx*diffx + diffy*diffy+  diffz*diffz);
	}
	
	public double distance(Point3D p) {
		return distance(p.getX(),p.getY(),p.getZ());
	}
	
	
	
}
