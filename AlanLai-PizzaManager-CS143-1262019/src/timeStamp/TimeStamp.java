package timeStamp;

import mainClasses.PizzaManager;
/*
 * This class IS a Date and HAS a time
 * You can call the getters for either, but no setters
 * Also a good candidate for a class with final data items.
 */
public class TimeStamp extends Date {    
	private final Time time;
	
	public TimeStamp(Date d, Time t) {
		super(d);
		time = t;
	}
	
	// setters and getters
	public Time getTime() { 
		return new Time(time);
	}
	public Date getDate() {	
		return new Date(this);
	}
	
	public String toString() { // Time toString
		return "TimeStamp at: " + time.getHour() + ":" + time.getMinute()+":"+ time.getSecond() + " and " + super.toString();
	}
}
