package mainClasses;
/*	Alan Lai
 *  10/3-10/2019
 * 	CS 143: FractionsV2 Assignment*/

import java.io.Serializable;

public class Fraction implements Comparable, Cloneable, Serializable {
	public final int numerator;
	public final int denominator;
	
	@Override 
	public Fraction clone() {
		return new Fraction(numerator, denominator);
	}
	
	public Fraction(int newNumerator, int newDenominator) {	// Constructor that takes num and denom args.
		if (newDenominator == 0) {throw new PizzaException("Denominator can't be 0");} // If denom = 0, crash program.
		if (newNumerator<0 && newDenominator<0) {	// If Num and Denom is negative,
			newNumerator*=-1;						// set both to positive.
			newDenominator*=-1;}
		if (newNumerator>0 && newDenominator<0 || newNumerator<0 && newDenominator>0) {	// If Num is + and Denom is -
			throw new PizzaException("Invalid Pizza Amt Remaining!");
		} else {
		int gcd = gcd(newNumerator, newDenominator);	// Find GCD
		this.numerator = newNumerator/=gcd;
		this.denominator = newDenominator/=gcd;
		}
	}



	public static int gcd(int num1, int num2) {
		if(num1==0) {return num2;}
		else if(num2==0) {return num1;}
		else if(num1>num2) {return gcd(num1-num2, num2);}
		else return gcd(num1,num2-num1);
		}

	@Override
	public boolean equals(Object obj) {		// equals Override
		if (obj == null) {					// if null, X
			return false;}
		else if (!(obj instanceof Fraction)) {	// if not a fraction, X
			return false;}
		Fraction that = (Fraction) obj;		
		return this.numerator == that.numerator && this.denominator == that.denominator;
		 // If this num=that num and this den = that den, they are equal.
	}
	@Override
	public String toString() {		// toString
		String s = numerator+"/"+denominator;
		return s;
	}

	@Override
	public int compareTo(Object o) { // Compares two fractions by double amount of fraction
		if (o==null || !(o instanceof Fraction)) {
			return -1;
		}
		Fraction that = (Fraction)o;
		if((double)(this.denominator/this.numerator)>(double)(that.denominator/that.numerator)) {
			return 1;
		}
		else if((double)(this.denominator/this.numerator)<(double)(that.denominator/that.numerator)) {
			return -1;
		} 
		else {
			return 0;
		}
	}
	

	
	public Fraction subtract(Fraction that) { // Subtract Fraction method: Used to Eat part of a pizza.
		if(this.denominator == that.denominator) { // If the denominators are equal, subtract the numerators
			return new Fraction(this.numerator - that.numerator, this.denominator);
		} else {	// Otherwise, make denominators equal and subtract (multiply up numerators too)
			int num1 = this.numerator * that.denominator;
			int denom1 = this.denominator * that.denominator;
			int num2 = that.numerator * this.denominator;
			int denom2 = that.denominator * this.denominator;
			return new Fraction(num1-num2, denom2);
		}
	}
	
	
//	public static void main(String[] args) {
//		Fraction frac = new Fraction(10,10);
//		System.out.println(frac);
//		Fraction frac2 = new Fraction(1,4);
//		
//		System.out.println(frac.subtract(frac2));
//		System.out.println(frac2);
//		System.out.println(frac.compareTo(frac2));
//		
//	}
}
