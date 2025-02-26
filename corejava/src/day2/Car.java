package day2;

import java.util.Objects;

public class Car implements Cloneable{
	private String make;
	private String model;
	private String year;
	private String version;
	private String varient;
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getVarient() {
		return varient;
	}
	public void setVarient(String varient) {
		this.varient = varient;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Car(String make, String model, String year, String version, String varient) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.version = version;
		this.varient=varient;
	}
	public Car() {
		
	}
	@Override
	public String toString() {
		return new StringBuilder().append(make) .append(" ").append(model).append(" ").append( varient ).append(" ").append(year).append(" ").append("Version").append(" ").append( version).toString() ;
	}
	
	public int hasCode() {
		return toString().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(make, other.make) && Objects.equals(model, other.model)
				&& Objects.equals(varient, other.varient) && Objects.equals(version, other.version)
				&& Objects.equals(year, other.year);
	}
	public boolean hashCode(Object o) {
		if(!(o instanceof Car)) return false;
			Car car=(Car)o;
			
			return year==car.year && version==car.version && make==car.make && varient==car.varient && model==car.model;
		
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		
		return super.clone();
		
	}
	public static CarBuilder builder() {
		return new CarBuilder(new Car());
	}
	
	public static class CarBuilder{
		
		private Car car;
		public CarBuilder(Car car) {
			this.car=car;
			
		}
		public Car build() {
			return car;
		}
		
		
		
		
		
		public CarBuilder make(String make) {
			car.setMake(make);
			return this;
		}
		
		public CarBuilder model(String model) {
			car.setModel(model);
			return this;
		}
		public CarBuilder varient(String varient) {
			car.setVarient(varient);
			return this;
		}
		public CarBuilder year(String year) {
			car.setYear(year);
			return this;
		}
		public CarBuilder version(String version) {
			car.setVersion(version);
			return this;
		}
		
		
	}
	

}
