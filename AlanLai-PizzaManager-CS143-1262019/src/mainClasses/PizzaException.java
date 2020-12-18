/** 
 * Alan Lai
 * 12/6/2019
 * CSS 143
 * PizzaException class: Thrown when invalid input in a pizza.
**/
package mainClasses;

public class PizzaException extends RuntimeException {
	public PizzaException() {} // no args constructor
	
	public PizzaException(String msg) {	// constructor with error message
		System.out.println(msg);
	}
	
}
