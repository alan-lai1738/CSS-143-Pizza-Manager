/* Alan Lai
 * 10/14-16/2019
 * CSS 143
 * Bill HW Assignment
 */
package mainClasses;

import java.io.Serializable;

public class Money implements Comparable, Cloneable, Serializable {
		private int dollar;
		private int cent;
		
	public Money (int dol) { // Money constructor, dollar as args
		if(dol > 0) {	// Dollar must be positive.
			this.dollar=dol;
			}
		}
		
	public Money (int dol, int cent) { // Money constructor, with dollar and cents
		if (dol > 0 && cent > 0 && cent <= 99) { 
		// Dollars must be positive and cents must be 0-99
			this.dollar = dol;
			this.cent = cent;}
		}
	
	@Override
	public Money clone() {
		return new Money(this);
	}
	
	public Money(Money other) {
		// Money Copy Constructor.
		this.dollar= other.getDollar();
		this.cent = other.getCent();
		// No leaks: Primitive copies being shared
		}

	public int getDollar() { 
		return dollar;
		// Dollar getter. Returns an int, so no p-leaks.
		}
	
	public void setDollar(int newDollar) {
		if(newDollar > 0) {
			this.dollar = newDollar;
		// Set Dollar, only works if dollar is a valid, positive int value.
			}
		}
	
	public int getCent() {
		return cent;
		// Cent Getter.
		}
	
	public void setCent(int newCent) {
		if(cent >= 0 && cent <= 99) {
		this.cent = newCent;
		// Set Cent to a value between 0-99
			}
		}
	
	public double getMoney() {
		double money = getDollar() + getCent();
		return money;
		// Returns a double value, showing the total $
		}
		
	public void setMoney(int dol, int cent) {
		if (dol > 0 && cent > 0 && cent <= 99) {
			this.dollar = dol;
			this.cent = cent;
		// Set money's dollar and cents in one method.
		}
	}
		
	public void add(int dol) {
		if (dol > 0) {
			this.dollar += dol;
		}
		// Add dollars to total.
	}
		
	public void add(int dol, int cent) {
		if (dol > 0) {
			this.dollar += dol;
		}
		if (cent > 0 && cent <= 99) {
			this.cent += cent;
		while(this.cent > 99) {
			this.dollar++;
			this.cent = this.cent - 100;
		// Add Dollars and Cents in one method.
			}
		}
	}
	
	public void add(Money other) {
		this.dollar += other.dollar;
		this.cent += other.cent;
		if(this.cent > 99) {
			this.dollar++;
			this.cent = this.cent - 100;
		// Add the amount of other's money to this money's amount.
		}
	}
		
	@Override
	public boolean equals(Object o) {
		if (o==null) {
			return false;
		}
		if (!(o instanceof Money)){
			return false;
		}
		Money that = (Money)o;
		return (this.dollar == that.dollar && this.cent == that.cent);
		// Checks if two money amounts are equal.
	}
		
	
	@Override
	public int compareTo(Object input) {
		if(input==null || input instanceof Money == false) throw new RuntimeException("Not valid");
		Money that = (Money)input;
		
		int thisCents = this.dollar*100 + this.cent;
		int thatCents = that.dollar*100 + that.cent;
		return thisCents - thatCents;
	}
	
	@Override 
	public String toString() {
		String s = "$" + getDollar() + "." + getCent();
		return s;
		// Prints money amount to String
	}
}
