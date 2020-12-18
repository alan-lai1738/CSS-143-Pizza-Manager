/** 
 * Alan Lai
 * 12/6/2019
 * CSS 143
 * Stack.java: Generic Stack used to Reverse the Pizza Array
**/
package mainClasses;


public class Stack<TBA extends Comparable> extends ArrayList{
	public void push(TBA next) {
		super.add(next, 0);
		// Push uses the insert function from List and only inserts to
		// index 0
	}
	
	public TBA pop() {
		return (TBA)super.remove(0);
		// Pop removes the item from index 0 and returns it, using
		// the remove function from List.
	}
	
	@Override
	public TBA remove(int index) {
		// Override remove to only use pop
		return pop();
	}
}
