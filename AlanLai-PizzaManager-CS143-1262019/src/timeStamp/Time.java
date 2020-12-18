/** 
 * Alan Lai
 * 12/6/2019
 * CSS 143
 * Time.java: A helper class for TimeStamp
**/
package timeStamp;

import java.io.Serializable;

import mainClasses.Fraction;

public class Time implements Comparable, Cloneable, Serializable {
	private int hour;
	private int minute;
	private int second;
	
	public Time(int h, int m, int s) { 
		setHour(h);
		setMinute(m);
		setSecond(s);
	}
	
	public Time(Time other) {
		this(other.getHour(), other.getMinute(), other.getSecond());
	}
	
	@Override
	public Object clone() {
		return new Time(this);
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
		if(minute >=0 && minute<=59) {
		this.minute = minute;}
		else {
			System.out.println("Invalid Minute: " + minute);
		}
		
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		if(second >=0 && second<=59) {
		this.second = second;}
		else {
			System.out.println("We died Bad second " + second);
		}
	}

	@Override
	public int compareTo(Object o) {
		if (o==null || !(o instanceof Time)) {
			return -1;
		}
		Time that = (Time)o;
		int thisSeconds = this.getHour()*3600 + this.getMinute()*60 + this.getSecond();
		int thatSeconds = that.getHour()*3600 + that.getMinute()*60 + that.getSecond();
		return thisSeconds-thatSeconds;
	}	
	
}
