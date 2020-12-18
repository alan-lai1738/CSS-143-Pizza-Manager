/** 
 * Alan Lai
 * 12/6/2019
 * CSS 143
 * Mozzarella cheese is the most well balanced cheese that absolutely
 * makes or breaks a pizza. It is light and tasty."
 * Mozzarella is a cheese ingredient
**/
package ingredients;

import mainClasses.Money;

public class Mozzarella extends Cheese {
	
	public Mozzarella() {
		super("Mozzarella", new Money((int)(Math.random()*10+1),(int)(Math.random()*99+1)), (int)(Math.random()*325+1));
	}
	
	// cheese is the most well balanced cheese that absolutely"
	//+ " makes or breaks a pizza. It is light and tasty."
	public Mozzarella(String desc, Money m, int cal) {
		super(desc, m, cal);
	}

}
