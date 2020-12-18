package timeStamp;
/* Alan Lai
 * CSS 143
 * 10/14/2019
 * Bill Assignment
 */

import java.io.Serializable;


public class Date implements Cloneable, Comparable, Serializable{
	private int month;
	private int day;
	private int year;
	
	@Override 
	public Date clone() {
		return new Date(this);
	}
	
	public Date() {
		// Empty Date Constructor
	}
	
	public Date(int m, int d, int y) {
		// Date Constructor
		if(m>0 && m<=12) { // Months must be 1-12
		this.month=m;}
		if(d>0 && d<=31) { // Days must be 0-31
		this.day=d;}
		if(y>=2014 && y<=2024) { // Year must be between 2014-2024
		this.year=y;}
	}
	
	public Date (Date other) {
		// Copy Constructor
		// Privacy leaks are not an issue for primitives
		this(other.month, other.day, other.year);
	}
	
	public int getMonth() {
		// Month getter
		return month;
	}
	public void setMonth(int m) {
		// Month Setter
		if(m>0 && m<=12) { // Months must be 1-12
			this.month=m;}
	}
	public int getDay() {
		// Day getter
		return day;
	}
	public void setDay(int d) {
		// Day setter
		if(d>0 && d<=31) { // Days must be 0-31
			this.day=d;}
	}
	public int getYear() {
		// Year getter
		return year;
	}
	public void setYear(int y) {
		// Year setter
		if(y>=2014 && y<=2024) { // Year must be between 2014-2024
			this.year=y;}
	}
	public void setDate(int m, int d, int y) {
		// Set the whole date.
		if(m>0 && m<=12) { // Months must be 1-12
			this.month=m;}
			if(d>0 && d<=31) { // Days must be 0-31
			this.day=d;}
			if(y>=2014 && y<=2024) { // Year must be between 2014-2024
			this.year=y;}
	}
	
	@Override
	public String toString() {
		// Prints date to String
		String s="";
		s+= month + "/" + day + "/" + year;
		return s;
	}
	
	@Override
	public boolean equals(Object other) {
		// Compares two dates
		if(other==null) {
			return false;
			}
		if(!(other instanceof Date)) {
			return false;
			}
		Date that = (Date)other;
		return (this.month == that.month && this.day == that.day && this.month == that.month);
		}
	
	@Override
	public int compareTo(Object o) {
		if (o==null || !(o instanceof Date)) {
			throw new RuntimeException("null/Not a date Object");
		}
		Date that = (Date)o;
		int thisDate = this.year*365 + this.month*30 + this.day;
		int thatDate = that.year*365 + that.month*30 + that.day;
	
		return thisDate-thatDate;
		}
	
	public static void main(String[] args) {
//		Date date = new Date(1,1,2017);
//		Date date2 = new Date(1,2,2017);
//		System.out.println(date.compareTo(date2));
	}
	}


	