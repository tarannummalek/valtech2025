package homeworktask;

public class Datetime {
	
	private int day;
	private int month;
	private int year;
	private int second;
	private int hour;
	private int minute;
	public Datetime() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Datetime(String date,String time) {
		String[] dateArray=date.split("-");
		this.day = Integer.parseInt(dateArray[0]);
		this.month = Integer.parseInt(dateArray[1]);
		this.year = Integer.parseInt(dateArray[2]);
		
		String[] timeArray=time.split("-");
		this.hour = Integer.parseInt(timeArray[0]);
		this.minute = Integer.parseInt(timeArray[1]);
		this.second = Integer.parseInt(timeArray[2]);
		
		
	}
	
	public Datetime(String date) {
		// date format (dd-mm-yyyy)
		String[] dateArray=date.split("-");
		this.day = Integer.parseInt(dateArray[0]);
		this.month = Integer.parseInt(dateArray[1]);
		this.year = Integer.parseInt(dateArray[2]);
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	@Override
	public String toString() {
		return  day + "-" + month + "-" + year + " IST " + hour + ":" + 
				 minute + ":"+second ;
	}
	
	
	
	
	

}
