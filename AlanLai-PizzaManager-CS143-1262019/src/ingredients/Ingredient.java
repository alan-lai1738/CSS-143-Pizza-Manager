/** 
 * Alan Lai
 * 12/5/2019
 * CSS 143
 * PizzaManager: Ingredient Hierarchy: Ingredient
 * This is Ingredient.java, which is a super class to all types of ingredients.
 * These types will then be inherited by specifics of that type. 
**/  

package ingredients;

import mainClasses.Money;
import mainClasses.PizzaException;

public abstract class Ingredient implements Comparable {
	protected final String description; // String is Final after being set by constructor
	private Money cost;					// Every ingredient has a cost**/
	private int calories;				// Every ingredient has a calorie count**/
	
	public Ingredient(String string, Money m, int cal) {
		// Ingredient Constructor that takes a description, money object, and calorie count.
		this.description = string;	// Every ingredient has a description
		this.cost = m.clone();		// Every ingredient has a cost
		this.calories = cal;		// Every ingredient has a calorite amt
	}
	
		
	@Override
	public int compareTo(Object o) { // Every ingredient is comparable by their cost
		return cost.compareTo(o);
	}
	
	@Override
	public String toString() { 	
		return description;
	}
	
	// Setters and getters for description, calories, and cost
	
	public String getDesc() { // Get description of Ingredient
		return this.description;
	}
	
	public Money getCost() { // Get Money object which is cost of ingredient.
		return cost.clone();
	}

	public int getCalories() { // Get calorie account
		return this.calories;
	}
	
	public void setCost(Money newCost) { // Get Cost
		this.cost = newCost.clone();
	}
	
	public void setCalories(int c) { // set calorie amount
		this.calories=c;
	}

	public static void main(String[] args) {
//		Alfredo alfredo = new Alfredo();
//		System.out.println(alfredo);
//		alfredo.setCost(new Money(1));
//		alfredo.setCalories(300);
//		System.out.println(alfredo);
	}
}
