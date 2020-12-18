/** 
 * Alan Lai
 * 12/6/2019
 * CSS 143
 * Vegetable.java
 * Vegetable is a type of Ingredient.
**/
package ingredients;

import mainClasses.Color;
import mainClasses.Fraction;
import mainClasses.Money;

public class Vegetable extends Ingredient {
	private Color color = new Color(0,0,0); // Vegetables have an extra instance data: A color
	// Default color is black
	public Color getColor() {	// Color getter
		return color;
	}

	public void setColor(Color color) { // Color setter
		this.color = color.clone();
	}

	public Vegetable(String desc, Money m, int cal) { // Veggie Constructor without color
		super(desc, m, cal);
	}
	
	public Vegetable(String desc, Money m, int cal, Color col) { // Veggie constructor with color
		super(desc, m, cal);
		this.color = col.clone();
	}
	
	@Override
	public String toString() { // Veggit toString
		return super.toString();
	}

	@Override
	public boolean equals(Object obj) { // Compares Vegetables by all instance data
		if (obj == null) {					
			return false;}
		else if (!(obj instanceof Vegetable)) {
			return false;}
		Vegetable that = (Vegetable) obj;		
		if(!(this.description.equals(that.description))) {
			return false;}
		else if(!(this.getCost().equals(that.getCost()))){
			return false;}
		else if(!(this.getColor().equals(that.getColor()))) {
			return false;}
		else if(!(this.getCalories()==that.getCalories())) {
			return false;}
		else return true;
		}

	
	public static void main(String[] args) {
//		Vegetable v = new Vegetable("Potatoes!", new Money(2), 200, new Color(0,0,0));
//		System.out.println(v);
		
//		Vegetable v = new Vegetable("Potatoes!", new Money(2), 200, new Color(0,0,0));
//		Vegetable v2 = new Vegetable("Potatoes!", new Money(2), 200, new Color(0,0,0));
//		System.out.println(v.equals(v2));
	}
}
