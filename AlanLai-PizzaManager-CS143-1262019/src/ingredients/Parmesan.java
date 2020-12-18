/** 
 * Alan Lai
 * 12/6/2019
 * CSS 143
 * Parmesan a Cheese Ingredient
**/
package ingredients;

import mainClasses.Money;

public class Parmesan extends Cheese {
	public Parmesan() {
		super("Parmesan", new Money((int)(Math.random()*10+1),(int)(Math.random()*99+1)), (int)(Math.random()*325+1));
	}
	
	
	public Parmesan(String desc, Money m, int cal) {
		super(desc, m, cal);
	}
}
