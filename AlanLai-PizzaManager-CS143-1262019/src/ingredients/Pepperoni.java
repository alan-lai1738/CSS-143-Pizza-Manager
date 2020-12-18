/** 
 * Alan Lai
 * 12/6/2019
 * CSS 143
 * Pepperoni is the king/queen of all pizza meats. The slightly spicy zesty, and satisfying red strips make a complete and delicious pizza."
 * Pepperoni is Meat ingredient
**/
package ingredients;

import mainClasses.Money;

public class Pepperoni extends Meat {
	
	public Pepperoni() {
		super("Pepperoni", new Money((int)(Math.random()*10+1),(int)(Math.random()*99+1)), (int)(Math.random()*325+1));
	}
	
	
	public Pepperoni(String desc, Money m, int cal) {
		super(desc, m, cal);
	}

}
