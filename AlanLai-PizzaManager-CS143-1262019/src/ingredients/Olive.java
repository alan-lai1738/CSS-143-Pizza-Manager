/** 
 * Alan Lai
 * 12/6/2019
 * CSS 143
 * Olives are Delicious black olives with a zangy sour taste. Olives are a tasty vegetable that are full of healthy fats. Olives
 * are a great combination with combo and veggie pizzas."
 * Olives are a Vegetable Ingredient
**/
package ingredients;


import mainClasses.Color;
import mainClasses.Money;

public class Olive extends Vegetable {
		
	public Olive() { // Empty Constructor that generates random values and black color
		super( "Olive", new Money((int)(Math.random()*10+1),(int)(Math.random()*99+1)), (int)(Math.random()*325+1), new Color(0,0,0));
	}
	
	public Olive(String desc, Money m, int cal, Color col) {
		super(desc, m, cal, col);
	}

}
