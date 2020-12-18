/** 
 * Alan Lai
 * 12/6/2019
 * CSS 143
 * Color.java helper class
**/
package mainClasses;

public class Color extends Object implements Cloneable {
	//class invariant: All channels are between [0,255]
	private int red=0;
	private int green=0;
	private int blue=0;
	//methods
	
	public Color() {}
	
	public Color(int r, int g, int b) { // Color Constructor
		if(r<0 || r > 255) System.exit(-1);
		setRed(r);
		setGreen(g);
		setBlue(b);
	}
	
	public Color(Color toCopy) {	// Copy constructor for color
		this(toCopy.getRed(), toCopy.getGreen(), toCopy.getBlue());
	}
	
	@Override
	public Color clone() {			// Returns a clone of color
		return new Color(this);
	}
	
	// setters and getters
	public void setRed(int r) {
		crashIfBad(r);
		red = r;
	}
	
	public void setGreen (int g) {
		crashIfBad(g);
		green = g;
	}
	
	public void setBlue (int b) {
		crashIfBad(b);
		blue = b;
	}
	
	public int getRed() {return red;}
	public int getGreen() {return green;}
	public int getBlue() {return blue;}
	
	private void crashIfBad(int channel) {
		if(channel<0 || channel > 255) System.exit(-1);
	}
	public void combine(Color other) {
		this.setRed(this.getRed()+other.getRed());
		this.setGreen(this.getGreen()+other.getGreen());
		this.setBlue(this.getBlue()+other.getBlue());}
	@Override
	public String toString() {
		String s = "R:" + red + ", G:" + green + ", B:" + blue;
		return s;
		
	}
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;}
		if (!(o instanceof Color)) {
			return false;}
		Color that = (Color) o;
		return (this.getGreen()==that.getGreen() && this.getBlue()==that.getBlue() && this.getRed()==that.getRed());
	}}

