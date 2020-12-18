/** 
 * Alan Lai
 * 12/6/2019
 * CSS 143
 * Goat.java
 * Goat is a Cheese Ingredient
 * Goat cheese is cheese made from goat's milk. It's a special"
 * type of cheese that has a soft, light taste."
**/
package ingredients;

import mainClasses.Money;

public class Goat extends Cheese {
	public Goat() {
		super("Goat",new Money((int)(Math.random()*10+1),(int)(Math.random()*99+1)), (int)(Math.random()*325+1));
	}
	
	public Goat(String desc, Money m, int cal) {
		super(desc, m, cal);
	}

}
