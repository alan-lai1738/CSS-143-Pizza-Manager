/** 
 * Alan Lai
 * 12/6/2019
 * CSS 143
 * ArrayList.java: A generic ArrayList class that can add
 * a certain type of object decided on construction. Also comparable and generic
 * node classes. Addable, Removable, Sizable, and Gettable.
**/
package mainClasses;

public class ArrayList<TBA extends Comparable> {	// TBA is a generic: ArrayList is of type TBA when made
	    private Node<TBA> head;	// ArrayList is a linked list with a head.
	    
	    // Add Outer Facade
	    public void add(TBA input, int index){	// Add method
	        if(index<0 || index>size()){ throw new RuntimeException();} // Precheck
	        head=insert(input,index,head);	 							// Finds node to add to
	    }

	    private Node<TBA> insert(TBA input, int index, Node current){	// Insert method: Adds data and node
	        if(index==0){current = new Node<TBA>(input, current);}
	        else {current.next = insert(input, --index, current.next);}	// Recursive Case
	        return current;

	    }
	    
	    // Remove Outer Facade
	    public TBA remove(int index){									// Remove from Linked List
	    	if(index<0 || index>size()){ throw new RuntimeException();}	// Precheck
	        TBA retVal = get(index);									
	        head = remove(index, head);
	        return (TBA)retVal;}										// Return TBA retVal
	        
	    private Node<TBA> remove(int index, Node<TBA> current){			// Inner remove
	        if(index==0){current = current.next;}						// Success Case
	        else {current.next = remove(--index, current.next);}
	        return current;}	
	        
	    public TBA get(int index){										// Get Outer Facade
	    	if(index<0 || index>size()){ throw new PizzaException();}	// Precheck
	        return get(index,head);}
	   
	    private TBA get(int index, Node<TBA> current){					// Get Inner Facade
	        if(index==0){ return (TBA)current.data;}					// Success Case
	        else return get(--index, current.next);}					// Recursive Case
	        
	    public void swap(int idx1, int idx2) {  						// Swap two Elements in a Linked List
	    	TBA temp = get(idx2);	// Get idx2 data
	    	TBA temp2 = get(idx1);	// Get idx1 data	
	    	add(temp, idx1);		// Add idx2 data to idx1 
	    	remove(idx1+1);			// remove old idx1
	    	add(temp2,idx2);		// Add idx1 to idx2
	    	remove(idx2+1);			// Remove old ix2
	    }
	    
	    public int size(){			//size method: returns size of arraylist
	        return size(head);
	    }
	    
	    private int size(Node<TBA> current){
	        if(current==null) {return 0;}
	        else return 1 + size(current.next);}
	        
	    @Override				   // Outer facade for to String
	    public String toString(){
	        return toString(head);}
	        
	    private String toString(Node<TBA> current){ // Recursively print data in array
	        if(current==null) { return "";}			
	        else return current.data + ", " + toString(current.next);}
	     
//	  
//	    public static void main(String[] args){		
//	       ArrayList<Money> list = new ArrayList<Money>();
//	       list.add(new Money(0,0),0);
//	       System.out.println(list);
//	    }
	    
	    public boolean isEmpty() {	// If head is null, arraylist is empty.
	    	if(head==null) { return true;}
	    	else return false;
	    }
	    
	    private class Node<TBA>{	// Node class
		    public TBA data;
		    public Node<TBA> next;
		    
		    public Node(TBA input, Node<TBA> nextPtr){
		        data=input;
		        next=nextPtr;}
		    }
	}

	
	
	
	    

