/** 
 * Alan Lai
 * 12/6/2019
 * CSS 143
 * Circle.java: Circle is a Shape
**/
package shapes;
import java.awt.Graphics;

public class Circle extends Shape {
	public Circle(int x, int y) {	// Circle constructor
		super(x, y);	// calls super
		setRadius((x+y)/2); // Sets radius to this amount
	}

	private double radius;
	
	@Override
	public double getArea() {	// Area is 2pir
		return  Math.PI * radius * radius;
	}

	private double getRadius() {	
		return this.radius;
	}
	
	public void setRadius(double radius) {	// Radius setter
		this.radius = radius;
	}
	
	@Override
	public String toString() {		// Circle toString: O
		return super.toString() + "O";
	}

	@Override
	public Shape clone() {			// Circle cloner
		return new Circle(this.getX(),this.getY());
	}
}
