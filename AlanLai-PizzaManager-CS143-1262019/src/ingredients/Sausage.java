/** 
 * Alan Lai
 * 12/6/2019
 * CSS 143
 * Sausage is the meat lover's favorite meat. Every meat pizza is incomplete"
 * without these juicy and meaty delightful pieces of meat."
 * Sausage is a Meat Ingredient
**/
package ingredients;

import mainClasses.Money;

public class Sausage extends Meat {
	
	public Sausage() {
		super("Sausage", new Money((int)(Math.random()*10+1),(int)(Math.random()*99+1)), (int)(Math.random()*325+1));
	}
	
	public Sausage(String desc, Money m, int cal) {
		super(desc, m, cal);
	}

}
