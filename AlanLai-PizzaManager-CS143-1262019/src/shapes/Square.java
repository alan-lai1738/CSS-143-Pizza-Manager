/** 
 * Alan Lai
 * 12/6/2019
 * CSS 143
 * Square is a Shape
**/
package shapes;

import java.awt.Graphics;

public class Square extends Shape {
	
	public Square(int x, int y) {// shape constructor
		super(x, y);
	}

	@Override
	public double getArea() { // square area: x*y
		return super.getX()*super.getY();
		}
		
	@Override
	public String toString() {	// []
		return super.toString() + "[]";
	}
	

	@Override
	public Shape clone() { // square cloner
		return new Square(this.getX(),this.getY());
	}

	
}