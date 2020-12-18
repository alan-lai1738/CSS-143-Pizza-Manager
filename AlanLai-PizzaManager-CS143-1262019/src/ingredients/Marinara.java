/** 
 * Alan Lai
 * 12/6/2019
 * CSS 143
 * Marinara is one of the most popular bases, especially for pizza! It's also a great dietary choice and lighter than the Alfredo base."
 * Marinara is a Base Ingredient
**/
package ingredients;

import mainClasses.Money;

public class Marinara extends Base {
	public Marinara() {
		super("Marinara", new Money((int)(Math.random()*20+1),(int)(Math.random()*99+1)), (int)(Math.random()*325+1));
	}
	
	
	public Marinara(String desc, Money m, int cal) {
		super(desc, m, cal);
	}

}
