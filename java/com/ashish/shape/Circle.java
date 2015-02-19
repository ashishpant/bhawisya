package com.ashish.shape;

public abstract class Circle implements Shape {

	public static class Float extends Circle {
		float x;
		float y;
		float radius;
		
		Float() {
		}
		Float(float x, float y, float radius) {
			setX(x);
			setY(y);
			setRadius(radius);
		}
		
	    void setRadius(float radius) {
	    	this.radius = radius;
		}
	    
		@Override
		public Point getCentre() {
			return new Point.Float(x, y);
		}
	    
		@Override
		public double getX() {
			return x;
		}
		public void setX(float x) {
			this.x = x;
		}
		
		@Override
		public double getY() {
			return y;
		}
		public void setY(float y) {
			this.y = y;
		}
		
		@Override
		public double getRadius() {
			return radius;
		}
		@Override
		public Rectangle getBoundingRect() {
			return new Rectangle.Float(x - radius, y - radius, x + radius, y + radius);
		}
		@Override
		public String toString() {
			return getClass().getName() + " [" + super.serialiazedString() + "]";
		}
		@Override
		public PointIterator getIterator() {
			return new Iterator(this);
		}
	}
	
	public static class Double extends Circle {
		double x;
		double y;
		double radius;
		
		Double() {
		}
		Double(double x, double y, double radius) {
			setX(x);
			setY(y);
			setRadius(radius);
		}
		
	    void setRadius(double radius) {
	    	this.radius = radius;
		}
	    
		@Override
		public Point getCentre() {
			return new Point.Double(x, y);
		}
		
		@Override
		public double getX() {
			return x;
		}
		public void setX(double x) {
			this.x = x;
		}
		
		@Override
		public double getY() {
			return y;
		}
		public void setY(double y) {
			this.y = y;
		}
		
		@Override
		public double getRadius() {
			return radius;
		}
		@Override
		public Rectangle getBoundingRect() {
			return new Rectangle.Double(x - radius, y - radius, x + radius, y + radius);
		}
		@Override
		public String toString() {
			return getClass().getName() + " [" + super.serialiazedString() + "]";
		}
		@Override
		public PointIterator getIterator() {
			return new Iterator(this);
		}
	}

	public static class Integer extends Circle {
		int x;
		int y;
		int radius;
		
		Integer() {
		}
		Integer(int x, int y, int radius) {
			setX(x);
			setY(y);
			setRadius(radius);
		}
		
	    void setRadius(int radius) {
	    	this.radius = radius;
		}

		@Override
		public Point getCentre() {
			return new Point.Integer(x, y);
		}

		@Override
		public double getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		
		@Override
		public double getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		
		@Override
		public double getRadius() {
			return radius;
		}
		@Override
		public Rectangle getBoundingRect() {
			return new Rectangle.Integer(x - radius, y - radius, x + radius, y + radius);
		}
		@Override
		public String toString() {
			return getClass().getName() + " [" + super.serialiazedString() + "]";
		}
		@Override
		public PointIterator getIterator() {
			return new Iterator(this);
		}
	}
	
	public abstract double getX();
	public abstract double getY();
	public abstract Point getCentre();
	public abstract double getRadius();
	public abstract String toString();
	protected String serialiazedString() {
		return "x=" + getX() + ",y=" + getY() + ",radius=" + getRadius();
	}
	
	public boolean intersects(Circle c) {
		double distanceSq = getCentre().distanceSq(c.getCentre());
		return distanceSq < (getRadius() + c.getRadius()) * (getRadius() + c.getRadius());
	}
	
	@Override
	public boolean intersects(Rectangle r) {
		PointIterator iter = r.getIterator();
		boolean inside = false;
		boolean outside = false;
		while(!iter.done()) {
			Point p = iter.next();
			Point q = getCentre();
			if (p.distanceSq(q) > getRadius() * getRadius()) {
				inside = true;
			} else {
				outside = true;
			}
		}
		return inside && outside;
	}

	@Override
	public boolean contains(Rectangle r) {
		PointIterator iter = r.getIterator();
		while(!iter.done()) {
			Point p = iter.next();
			Point q = getCentre();
			if (p.distanceSq(q) > getRadius() * getRadius()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean contains(Point p) {
		Point q = getCentre();
		if (p.distanceSq(q) < getRadius() * getRadius()) {
			return true;
		}
		return false;
	}
	
	public class Iterator implements PointIterator {
		private Circle circle;
		private int index = 0;
		
		protected Iterator(Circle circle) {
			this.circle = circle;
		}

		@Override
		public Point next() {
			if (index == 0) {
				return new Point.Double(circle.getX(), circle.getY());
			}
			return null;
		}

		@Override
		public boolean done() {
			return index > 0;
		}
		
	}
}
