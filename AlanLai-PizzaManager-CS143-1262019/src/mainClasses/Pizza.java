/** 
 * Alan Lai
 * 12/6/2019
 * CSS 143
 * PizzaManager: Pizza.java class
 * This is Pizza.java. Pizza has 4 data variables: an ingredient array holding
 * all ingredients. The fraction by default starts out as 1/1. 
 * There is also the TimeStamp for when the date was made. Every pizza also has
 * a shape of circle or square.
**/  
package mainClasses;
import java.text.DecimalFormat;

import shapes.Circle;
import shapes.Shape;
import timeStamp.Date;
import timeStamp.TimeStamp;
import ingredients.Ingredient;


public class Pizza implements PizzaComparable, Cloneable {
	private final ArrayList<Ingredient> ingredients; // Ingredients array
	private Fraction remaining = new Fraction(1,1);  // Remaining amount of pizza
	private final TimeStamp dateMade;				 // When the pizza was made
	private Shape shape;							 // Shape of the pizza
	
	@Override
	public String toString() {
		// Prints the data of the pizza.
		return shape + " Pizza | " + getCost() + " | " + getCalories() + " calories | " 
	+ getRemainingFraction() + " fraction remaining | " + getRemainingArea() + " area remaining | " + ingredients;
	}
	
	public Pizza(Shape shape, ArrayList<Ingredient> ingredients) { 
		// Pizza constructor that takes a shape and ingredients array
		dateMade= new TimeStamp(PizzaManager.getCurrentDate(), PizzaManager.getCurrentTime());
		// Date of when the pizza was made is randomized.
		this.shape = shape.clone();
		this.ingredients = ingredients;
	}

	
	public boolean isEaten() {	// Returns true if the pizza is eaten, false if some pizza is still left.
		if (getRemainingFraction().equals(new Fraction(0,1))){
			return true;}
		return false;
		}
	
	public int getCalories() {	// Get calories: returns sum of all ingredient's calories.
		int retVal = 0;
		for(int i = 0; i < ingredients.size(); i++) {
			retVal += ingredients.get(i).getCalories();
		} 
		return retVal;
	}
	
	public Money getCost() { // Get Cost: returns sum of all ingredient's cost
		Money totalCost = new Money(0,0);
		for(int i = 0; i < ingredients.size(); i++) {
			totalCost.add(ingredients.get(i).getCost());
		} 
		double remaining = (double)this.remaining.numerator/(double)this.remaining.denominator;  // Remaining fraction double
		totalCost.setDollar((int)(totalCost.getDollar()*remaining));	// Multiply dollar by fraction
		totalCost.setCent((int)(totalCost.getCent()*remaining));		// Multiply cent by fraction
		return totalCost;	// This is to set the cost lower when there is less pizza remaining
	}
	
	public Date getMadeDate() {	// Returns the Date of creation
		return dateMade.getDate();}	

	public void setRemainingFraction(Fraction set) { // Set the fraction to an amount
		this.remaining = set.clone();
	}
	
	public Fraction getRemainingFraction() { // Return Remaining Fraction
		return remaining.clone();
	}
	
	public double getRemainingArea() { // Return remaining pizza area
		double changeArea = (double)remaining.numerator/(double)remaining.denominator; // Multiply area * remaining fraction
		// to get remaining area.
		return shape.getArea()*changeArea;
	}
	
	public void setShape(Shape newShape) {	// Set the pizza to different shape
		this.shape = newShape.clone();	
	}
	
	public void addIngredient(Ingredient in) { // Add an ingredient to the pizza(ingredient array)
		ingredients.add(in, ingredients.size());
	}
	
	public void eatSomePizza(Fraction amount) { // Eat a fractional amount of the pizza
		remaining = remaining.subtract(amount);	// Which calls the subtract method in the Fraction class
	}
	
	@Override
	public int compareTo(Object input) { // Compare pizzas by remaining  fraction
		if(input==null) throw new RuntimeException("This Object is Null");
		if(!(input instanceof Pizza))  throw new RuntimeException("Not a Pizza");	// Error case
		Pizza that = (Pizza)input;
		if(this.getRemainingFraction().compareTo(that.getRemainingFraction())<0) {return -1;}	// Compare by Fraction
		else if(this.getRemainingFraction().compareTo(that.getRemainingFraction())>0) {return 1;}
		else return 0;
	}

	@Override
	public int compareToBySize(Object input) {	// Compares pizzas by size
		if(input==null || input instanceof Pizza == false) throw new RuntimeException("Not a Pizza"); // Error Case
		Pizza that = (Pizza)input;
		if(this.getRemainingArea()>that.getRemainingArea()) { return 1;}		// Compares remaining area
		else if(this.getRemainingArea()<that.getRemainingArea()) { return -1;}
		else return 0;
	}

	@Override
	public int compareToByCalories(Object input) { // Compares pizzas by calorie amount
		if(input==null || input instanceof Pizza == false) throw new RuntimeException("Not a Pizza");	// Error case
		Pizza that = (Pizza)input;
		if(this.getCalories()>that.getCalories()) {return 1;}			// CompareTo by calories
		else if(this.getCalories()<that.getCalories()) { return -1;}
		else return 0;
	}

	
//	public static void main(String[] args) {
//		Pizza p = new Pizza(new Circle(5,5), getRandomIngredients())
//	}

}
