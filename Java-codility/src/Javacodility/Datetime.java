package Javacodility;

public class Datetime {
    private int day;
    private int month;
    private int year;
    private int second;
    private int hour;
    private int minute;

    public Datetime() {
        super();
    }

    public Datetime(String date, String time) {
        String[] dateArray = date.split("-");
        this.day = Integer.parseInt(dateArray[0]);
        this.month = Integer.parseInt(dateArray[1]);
        this.year = Integer.parseInt(dateArray[2]);

        String[] timeArray = time.split(":");
        this.hour = Integer.parseInt(timeArray[0]);
        this.minute = Integer.parseInt(timeArray[1]);
        this.second = Integer.parseInt(timeArray[2]);
    }

    public Datetime(String date) {
        String[] dateArray = date.split("-");
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
        return day + "-" + month + "-" + year + " IST " + hour + ":" + minute + ":" + second;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }


    private int calculateDays() {
        int days = 0;
        for (int y = 1; y < this.year; y++) {
            days += isLeapYear(y) ? 366 : 365;
        }

        int[] daysInMonth = {31, (isLeapYear(this.year) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int m = 1; m < this.month; m++) {
            days += daysInMonth[m - 1];
        }
        days += this.day;

        return days;
    }

    public int getDaysBetween(Datetime other) {
        int thisDateDays = this.calculateDays();
        int otherDateDays = other.calculateDays();

        return Math.abs(thisDateDays - otherDateDays);
    }

    public static void main(String[] args) {
        Datetime date1 = new Datetime("01-01-2020");
        Datetime date2 = new Datetime("01-01-2025");
        int daysBetween = date1.getDaysBetween(date2);
        System.out.println("Days between: " + daysBetween);
    }
}
