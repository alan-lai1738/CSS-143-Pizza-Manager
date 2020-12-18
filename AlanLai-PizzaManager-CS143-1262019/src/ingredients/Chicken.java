/** 
 * Alan Lai
 * 12/6/2019
 * CSS 143
 * Chicken.java 
 * Chicken is  Meat Ingredient
**/
package ingredients;

import mainClasses.Money;

public class Chicken extends Meat {

	public Chicken() {
		super("Chicken", new Money((int)(Math.random()*10+1),(int)(Math.random()*99+1)), (int)(Math.random()*325+1));
	}
	
	public Chicken(String desc, Money m, int cal) {
		super(desc, m, cal);
	}
}
