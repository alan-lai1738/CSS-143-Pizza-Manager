/** 
 * Alan Lai
 * 12/6/2019
 * CSS 143
 * Pepper is a Vegetable Ingredient
**/
package ingredients;

import mainClasses.Color;
import mainClasses.Money;

public class Pepper extends Vegetable {
	
	public Pepper() {
		super("Pepper", new Money((int)(Math.random()*10+1),(int)(Math.random()*99+1)), (int)(Math.random()*325+1), new Color(0,255,0));
	}
	
	public Pepper(String desc, Money m, int cal, Color color) {
		super(desc, m, cal, color);
	}

}
