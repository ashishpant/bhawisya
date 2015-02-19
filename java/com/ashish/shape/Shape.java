package com.ashish.shape;

public interface Shape {

	public boolean intersects(Rectangle r);
	
	public boolean contains(Rectangle r);
	
	public boolean contains(Point p);
	
	public Rectangle getBoundingRect();
	
	public PointIterator getIterator();

}