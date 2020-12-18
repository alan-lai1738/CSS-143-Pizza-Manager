/** 
 * Alan Lai
 * 12/6/2019
 * CSS 143
 * Alfredo is a Base Ingredient
 * Alfredo: a rich, creamy, delicious Italian sauce which makes a great
 * tasty base for you pizza, no matter whats on top!
**/
package ingredients;

import mainClasses.Money;

public class Alfredo extends Base {
	public Alfredo() {	// Default constructor that assigns random values
		super("Alfredo", new Money((int)(Math.random()*10+1),(int)(Math.random()*99+1)), (int)(Math.random()*325+1));
	}

	public Alfredo(String desc, Money m, int cal) { // Constructor to set alfredo data.
		super(desc, m, cal);
	}

}
