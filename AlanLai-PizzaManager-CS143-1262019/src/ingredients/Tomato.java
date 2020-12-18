/** 
 * Alan Lai
 * 12/6/2019
 * CSS 143
 * Tomato is a Base Ingredient
**/
package ingredients;

import mainClasses.Money;

public class Tomato extends Base {
	public Tomato() {
		super("Tomato", new Money((int)(Math.random()*10+1),(int)(Math.random()*99+1)), (int)(Math.random()*325+1));
	}
	
	
	public Tomato(String desc, Money m, int cal) {
		super(desc, m, cal);}
}
