package com.ashish.shape;

public abstract class Rectangle implements Shape {

	public static class Float extends Rectangle {
		public float x;
		public float y;
		public float width;
		public float height;
		
		public Float() {	
		}
		public Float(float x, float y, float width, float height) {
			setBounds(x, y, width, height);
		}
		
		@Override
		public Rectangle getBoundingRect() {
			return new Float(x, y, width, height);
		}
		@Override
		public double getX() {
			return x;
		}
		@Override
		public double getY() {
			return y;
		}
		@Override
		public double getWidth() {
			return width;
		}
		@Override
		public double getHeight() {
			return height;
		}
		public void setBounds(float x, float y, float width, float height) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;			
		}
		@Override
		public void setBounds(double x, double y, double width, double height) {
			setBounds((float) x, (float) y, (float) width, (float) height);
		}
		@Override
		public String toString() {
			return getClass().getName() + " [" + super.serializedString() + "]";
		}
		@Override
		public PointIterator getIterator() {
			return new Iterator(this);
		}
	}
	
	public static class Double extends Rectangle {
		public double x;
		public double y;
		public double width;
		public double height;
		
		public Double() {
		}
		public Double(double x, double y, double width, double height) {
			setBounds(x, y, width, height);
		}
		
		@Override
		public Rectangle getBoundingRect() {
			return new Double(x, y, width, height);
		}
		@Override
		public double getX() {
			return x;
		}
		@Override
		public double getY() {
			return y;
		}
		@Override
		public double getWidth() {
			return width;
		}
		@Override
		public double getHeight() {
			return height;
		}
		@Override
		public void setBounds(double x, double y, double width, double height) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;			
		}
		@Override
		public String toString() {
			return getClass().getName() + " [" + super.serializedString() + "]";
		}
		@Override
		public PointIterator getIterator() {
			return new Iterator(this);
		}
	}

	public static class Integer extends Rectangle {
		public int x;
		public int y;
		public int width;
		public int height;
		
		public Integer() {	
		}
		public Integer(int x, int y, int width, int height) {
			setBounds(x, y, width, height);
		}
		
		@Override
		public Rectangle getBoundingRect() {
			return new Integer(x, y, width, height);
		}
		@Override
		public double getX() {
			return x;
		}
		@Override
		public double getY() {
			return y;
		}
		@Override
		public double getWidth() {
			return width;
		}
		@Override
		public double getHeight() {
			return height;
		}
		public void setBounds(int x, int y, int width, int height) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;			
		}
		@Override
		public void setBounds(double x, double y, double width, double height) {
			setBounds((int) x, (int) y, (int) width, (int) height);
		}
		
		@Override
		public String toString() {
			return getClass().getName() + " [" + super.serializedString() + "]";
		}
		@Override
		public PointIterator getIterator() {
			return new Iterator(this);
		}
	}
	
	
	public Rectangle() {
	}
	public Rectangle(Point p1, Point p2) {
		setBounds(p1, p2);
	}
	public Rectangle(double x, double y, double width, double height) {
		setBounds(x, y, width, height);
	}
	
	public abstract double getX();
	public abstract double getY();
	public abstract double getWidth();
	public abstract double getHeight();
	
	public void resize(double width, double height) {
		setBounds(getX(), getY(), width, height);
	}
	public abstract void setBounds(double x, double y, double width, double height);
	public void setBounds(Point p1, Point p2) {
		setBounds(Math.min(p1.getX(), p2.getX()),
				Math.min(p1.getY(), p2.getY()),
				Math.abs(p1.getX() - p2.getX()),
				Math.abs(p1.getY() - p2.getY()));		
	}
	
	public abstract String toString();
	
	protected String serializedString() {
		return "x=" + getX() + ",y=" + getY() + ",width=" + getWidth() + ",height=" + getHeight();
	}
	
	@Override
	public boolean intersects(Rectangle r) {
		boolean inside =
				getX() < r.getX() &&
				getY() < r.getY() &&
				(getX() + getWidth()) > (r.getX() + r.getWidth()) &&
				(getY() + getHeight()) > (r.getY() + r.getHeight());
		boolean outside =
				getX() > r.getX() &&
				getY() > r.getY() &&
				(getX() + getWidth()) < (r.getX() + r.getWidth()) &&
				(getY() + getHeight()) < (r.getY() + r.getHeight());
		return !inside && !outside;
	}

	@Override
	public boolean contains(Rectangle r) {
		return getX() < r.getX() &&
				getY() < r.getY() &&
				(getX() + getWidth()) > (r.getX() + r.getWidth()) &&
				(getY() + getHeight()) > (r.getY() + r.getHeight());
	}

	@Override
	public boolean contains(Point p) {
		return getX() < p.getX() &&
				getY() < p.getY() &&
				(getX() + getWidth()) > p.getX() &&
				(getY() + getHeight()) > p.getY();
	}
	
	public class Iterator implements PointIterator {
		private Rectangle rectangle;
		private int index = 0;
		
		protected Iterator(Rectangle rectangle) {
			this.rectangle = rectangle;
		}

		@Override
		public Point next() {
			if (index < 4) {
				switch(index++) {
				case 0:
					return new Point.Double(
							rectangle.getX(), rectangle.getY());
				case 1:
					return new Point.Double(
							rectangle.getX() + rectangle.getWidth(),
							rectangle.getY());
				case 2:
					return new Point.Double(
							rectangle.getX() + rectangle.getWidth(),
							rectangle.getY() + rectangle.getHeight());
				case 3:
					return new Point.Double(
							rectangle.getX(),
							rectangle.getY() + rectangle.getHeight());
				}
			}
			return null;
		}

		@Override
		public boolean done() {
			return index == 4;
		}
		
		
	}
}
