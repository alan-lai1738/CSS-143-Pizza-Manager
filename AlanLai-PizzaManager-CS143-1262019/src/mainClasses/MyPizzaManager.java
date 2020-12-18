/**
 * Alan Lai
 * 12/6/2019
 * CSS 143
 * MyPizzaManager has commands that manages an array list of pizzas.
 * This can be adding random pizzas, organizing the array of pizzas,
 * or search the array of pizzas. You can also remove and sort pizzas.
 */
package mainClasses;

// Import Ingredients and Shapes
import java.util.Scanner;
import ingredients.Alfredo;
import ingredients.Chicken;
import ingredients.Goat;
import ingredients.Ingredient;
import ingredients.Marinara;
import ingredients.Mozzarella;
import ingredients.Olive;
import ingredients.Parmesan;
import ingredients.Pepper;
import ingredients.Pepperoni;
import ingredients.Sausage;
import ingredients.Spinach;
import ingredients.Tomato;
import shapes.Circle;
import shapes.Shape;
import shapes.Square;
import timeStamp.Date;
import timeStamp.TimeStamp;



public class MyPizzaManager extends PizzaManager {	// MyPizzaManager is a PizzaManager
	private ArrayList<Pizza> pizzas = new ArrayList<Pizza>(); // ArrayList of Pizzas. This holds all our pizzas
	
	@Override
	protected void addRandomPizza() {	// Adds a random pizza with random shape and ingredients
		Pizza randomPizza = new Pizza(getRandomShape(), getRandomIngredients());
		pizzas.add(randomPizza, pizzas.size());	
	}
	
	private Shape getRandomShape() {	// Get a random shape of square or circle.
		int random = ((int)(Math.random()*2+1));
		if(random==1) {
			return new Square((int)(Math.random()*30+1), (int)(Math.random()*30+1));
		} else { // Random x and y values are generated
			return new Circle((int)(Math.random()*30+1), (int)(Math.random()*30+1));
			
		}
	}
	

	// Random Pizza Helper Methods
	private ArrayList<Ingredient> getRandomIngredients(){ // getRandomIngredients(): returns a random ingredients array
		 ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();		// array to return
		 int randomAmountOfIngredients = (int)(Math.random()*5+1);				// Random: How many ingredients?
		 for(int i = 0; i <= randomAmountOfIngredients; i++) {					// Add that amount of ingredients
			 switch((int)(Math.random()*12+1)) {  								// Randomize and choose between 12 ingredients
				case 1: ingredients.add(new Mozzarella(), ingredients.size()); 
												break;
				case 2: ingredients.add(new Goat(), ingredients.size()); 
												break;					
				case 3: ingredients.add(new Alfredo(), ingredients.size()); 
												break;			
				case 4: ingredients.add(new Olive(), ingredients.size()); 
												break;	
				case 5: ingredients.add(new Pepper(), ingredients.size()); 
												break;
				case 6: ingredients.add(new Pepperoni(), ingredients.size()); 
												break;
				case 7:  ingredients.add(new Marinara(), ingredients.size()); 
												break;
				case 8:  ingredients.add(new Sausage(), ingredients.size()); 
												break;
				case 9:  ingredients.add(new Spinach(), ingredients.size()); 
												break;
				case 10:  ingredients.add(new Chicken(), ingredients.size()); 
												break;
				case 11:  ingredients.add(new Tomato(), ingredients.size()); 
												break;
				case 12:  ingredients.add(new Parmesan(), ingredients.size()); 
												break;
				}
			 } // Once done, return the array of ingredients
		 return ingredients;
	}
	
	@Override
	protected void displayAllPizzas() { // Display all pizzas from the pizzas array.
		for(int i = 0; i < pizzas.size(); i++) {	// This is done with a for loop up to pizzas.size()-1
			System.out.println(pizzas.get(i));		// Print pizza toString
		}
	}
		
	@Override
	protected char getNextChar() { 		// get Next char input
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		char selection = input.charAt(0);
		return selection;
	}
	
	@Override
	protected int getNextInt() { // get next user Integer input
		Scanner sc = new Scanner(System.in);
		int retVal = sc.nextInt();
		return retVal;
	}
	
	
	@Override
	protected void eatSomePizza() {	// eatSomePizza method: Takes user input to eat part of a pizza
		if(pizzas.isEmpty()) {throw new PizzaException("No pizzas to eat.");}	// If there are no pizzas to eat, throw an exception.
		int[] nums = getValues();												// Scanner that takes an index and fraction input
		if(nums[0] < 0 || nums[0]> pizzas.size()) {throw new PizzaException("There isn't a pizza there.");} // If index chosen is not a valid index, throw error
		pizzas.get(nums[0]).eatSomePizza(new Fraction(nums[1],nums[2]));		// Eat part of the pizza, calling eatSomePizza the in Pizza class
		if (pizzas.get(nums[0]).isEaten()==true) {								// If the whole pizza is eaten, remove the pizza
			pizzas.remove(nums[0]);
			System.out.println("You ate all of pizza " + nums[0]);}
		else { 
			System.out.println("You ate " + nums[1] + "/" + nums[2] + " of pizza " + nums[0]); // Display how much of the pizza was eaten
		}
	}
	
	private int[] getValues() { // Helper method for eatSomePizza: Gets input from user and returns the values as an int array.
		try {
		System.out.println("Eating a fraction of a pizza. Which index and how much? <index> <numerator>/<denominator>");
		Scanner sc = new Scanner(System.in); // Scanner takes "<index> <num>/<denom> from user
		String[] nums = new String [3];	// Takes it as string
		String line2Read = sc.nextLine();
		String[] firstNums = line2Read.split(" "); //0 1/2 --> [0][1/2]
		nums[0]= firstNums[0]; //[0][][] = [0][1/2]
		String[] secondNums = firstNums[1].split("/"); //[1][2]
		nums[1] = secondNums[0];
		nums[2] = secondNums[1];
		// Return actualNums, which is parsed into ints
		int [] actualNums = new int [3];
		for(int i = 0; i < actualNums.length; i++) {
			actualNums[i] = Integer.parseInt(nums[i]);	
		}
		return actualNums;
		} catch (ArrayIndexOutOfBoundsException e) {System.out.println("Invalid input");
		return new int[] {0,0,0};}} // If the input doesn't work don't eat any of the pizza.


	// Quick Sort by Calories
	@Override
	public void quickSortByCalories() {	// our outer facade
		if(pizzas.isEmpty()) {	// If pizza is empty, no sorting is to be done.
			throw new PizzaException("No Pizzas to search.");
		}
		quickSortByCalories(0, pizzas.size()-1);	// runs QuickSort private method	
	}
    
    private void quickSortByCalories(int low, int high) {	// Our recursive quickSort method
		// Our base case here is once it's fully sorted, the low and high values are both pivotIndex.
		// This means both sides have finished sorting and meet at the pivot
		if(low<high) {	// If low is less than high, or if before and after pivot is not fully organized yet
			int pivotIndex = partitionCal(low, high); // Select a pivot index and split
			quickSortByCalories(low, pivotIndex-1);	// Recursive case: sort left of pivot
			quickSortByCalories(pivotIndex+1, high);	// Recursive case: sort right of pivot
		}
	}
    
    private int partitionCal(int low, int high) {
		// Our private partition method chooses the highest index as the pivot.
		int pivotValue = pizzas.get(high).getCalories();
		// The data at the highest index is the pivot
		int smallIndex = low;
		// smallIndex will be our retVal, this is for our recursive call to decrement/increment every time.
		for(int i = low; i < high; i++) {
		// Starting from "low" index, loop until the last index of the range.
			if(pizzas.get(i).getCalories()<pivotValue) {
				pizzas.swap(i,smallIndex++);
			// If the input is less than the pivot value, swap it to smallIndex(then increment smallIndex)
			}
		}
		pizzas.swap(smallIndex, high); // drop pivot in place
		return smallIndex; // return pivot index
	}
    
    // Quick Sort by Price
    @Override
    public void quickSortByPrice() {	// our outer facade
    	if(pizzas.isEmpty()) {
			throw new PizzaException("No Pizzas to search.");
		}
		quickSortByPrice(0, pizzas.size()-1);	// runs QuickSort private method	
	}
    
    private void quickSortByPrice(int low, int high) {	// Our recursive quickSort method
		// Our base case here is once it's fully sorted, the low and high values are both pivotIndex.
		// This means both sides have finished sorting and meet at the pivot
		if(low<high) {	// If low is less than high, or if before and after pivot is not fully organized yet
			int pivotIndex = partitionPrice(low, high); // Select a pivot index and split
			quickSortByPrice(low, pivotIndex-1);	// Recursive case: sort left of pivot
			quickSortByPrice(pivotIndex+1, high);	// Recursive case: sort right of pivot
		}
	}
    
    private int partitionPrice(int low, int high) {
		// Our private partition method chooses the highest index as the pivot.
		Money pivotValue = pizzas.get(high).getCost();
		// The data at the highest index is the pivot
		int smallIndex = low;
		// smallIndex will be our retVal, this is for our recursive call to decrement/increment every time.
		for(int i = low; i < high; i++) {
		// Starting from "low" index, loop until the last index of the range.
			if(pizzas.get(i).getCost().compareTo(pivotValue)<0) {
				pizzas.swap(i,smallIndex++);
			// If the input is less than the pivot value, swap it to smallIndex(then increment smallIndex)
			}
		}
		pizzas.swap(smallIndex, high); // drop pivot in place
		return smallIndex; // return pivot index
	}
    
    //Quick Sort by Size
    @Override
    public void quickSortBySize() {	// our outer facade
    	if(pizzas.isEmpty()) {throw new PizzaException("No pizzas to sort.");}
		quickSortBySize(0, pizzas.size()-1);	// runs QuickSort private method	
	}
    
    private void quickSortBySize(int low, int high) {	// Our recursive quickSort method
		// Our base case here is once it's fully sorted, the low and high values are both pivotIndex.
		// This means both sides have finished sorting and meet at the pivot
		if(low<high) {	// If low is less than high, or if before and after pivot is not fully organized yet
			int pivotIndex = partitionSize(low, high); // Select a pivot index and split
			quickSortBySize(low, pivotIndex-1);	// Recursive case: sort left of pivot
			quickSortBySize(pivotIndex+1, high);	// Recursive case: sort right of pivot
		}
	}    

    private int partitionSize(int low, int high) {
		// Our private partition method chooses the highest index as the pivot.
		double pivotValue = pizzas.get(high).getRemainingArea();
		// The data at the highest index is the pivot
		int smallIndex = low;
		// smallIndex will be our retVal, this is for our recursive call to decrement/increment every time.
		for(int i = low; i < high; i++) {
		// Starting from "low" index, loop until the last index of the range.
			if(pizzas.get(i).getRemainingArea()<pivotValue) {
				pizzas.swap(i,smallIndex++);
			// If the input is less than the pivot value, swap it to smallIndex(then increment smallIndex)
			}
		}
		pizzas.swap(smallIndex, high); // drop pivot in place
		return smallIndex; // return pivot index
	}
    
    // Binary Search by Calories
    @Override
    protected int binarySearchByCalories(int targetCal) {	
    	quickSortByCalories();	// Sort the array by calories first.
    	if(pizzas.isEmpty()) {	// Error case: Empty ArrayList
			throw new PizzaException("No Pizzas to sort.");
		}
    	int index = calSearch(targetCal, 0, pizzas.size()-1);
    	if(index==-1) { // if calSearch is -1, no pizza found
    		System.out.println("Pizza not found!");
    		return -1;}
    	else {			// Found !
    		System.out.println("Pizza #" + index + " found!");
    		return index;
    	}
    }
    
    // calSearch helper method
    private int calSearch(int targetCal, int low, int high) {
		// Recursive Search: Recursive with updated Low and high
		// inner facade
		int mid = (low+high)/2;	// Mid
		if(targetCal == pizzas.get(mid).getCalories()) {	// Base Case: Success
			return mid;
		}
		else if(low>=high) {	// Base Case: FAIL
			throw new PizzaException("No Pizza with " + targetCal );
		} else if(targetCal < pizzas.get(mid).getCalories()) { 
			// Recursive Case: Check Left side, cut entire right half
			return calSearch(targetCal, low, mid-1);
		} else if(targetCal > pizzas.get(mid).getCalories()) {
			// Recursive Case: Check right side, cut entire left half
			return calSearch(targetCal, mid+1, high);
		}
		return -1;
	}
    
    @Override
    protected void removeDayOldPizzas() {	// Method that removes day old pizzas
    	if(pizzas.isEmpty()) {throw new PizzaException("No pizzas to remove.");}
    	TimeStamp currentDay = new TimeStamp(PizzaManager.getCurrentDate(), PizzaManager.getCurrentTime());
    	for(int i = 0; i < pizzas.size(); i++) {
    		if(pizzas.get(i).getMadeDate().compareTo(currentDay) <= -1) { // If pizza was made before currentDay, remove the pizza.
    			System.out.println("Pizza " + i + " has been removed");
    			pizzas.remove(i);
    		}
    	}
    }
    
    // Reverse Pizzas With A Stack
    @Override
    protected void reversePizzasWithStack() {
    	if(pizzas.isEmpty()) {throw new PizzaException("No pizzas to reverse.");}	// Error case
    	Stack<Pizza> temp = new Stack<Pizza>();		// Stack to push pizzas into
    	int index = 0;
    	while(!pizzas.isEmpty()) {					// Push all pizzas into stack
    		temp.push(pizzas.remove(index));}
    	index = 0;
    	while(!temp.isEmpty()) {					// Pop all pizzas into array
    		pizzas.add(temp.pop(), index++);}
    	}
    	
    // Linear search by day: Searches whole pizza array for same day made.
    @Override
    protected int linearSearchByDay(int dayToMatch) {
    	if(pizzas.isEmpty()) {throw new PizzaException("No pizzas to search.");}
    	for(int i = 0; i < pizzas.size()-1; i++) {
    		if(pizzas.get(i).getMadeDate().getDay()==dayToMatch) { // Success case: Pizza Found
    			System.out.println("Pizza found! \n" + pizzas.get(i) + "\n Made on " + pizzas.get(i).getMadeDate());
    			return i;
    		}
    	}
    	System.out.println("No pizzas found."); // Fail case
    	return -1;
    }
    	
    }
 
	
	

	
	
	