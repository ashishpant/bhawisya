package com.ashish.shape;

public abstract class Point {

	public static class Float extends Point {
		public float x;
		public float y;
			
		public Float() {
		}		
		public Float(float x, float y) {
			setLocation(x, y);
		}
		
		void setLocation(float x, float y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public void setLocation(double x, double y) {
			this.x = (float) x;
			this.y = (float) y;
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
		public String toString() {
			return getClass().getName() + " [" + super.serializedString() + "]";
		}
	}

	public static class Double extends Point {
		public double x;
		public double y;
		
		public Double() {
		}		
		public Double(double x, double y) {
			setLocation(x, y);
		}

		@Override
		public void setLocation(double x, double y) {
			this.x = (float) x;
			this.y = (float) y;
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
		public String toString() {
			return getClass().getName() + " [" + super.serializedString() + "]";
		}
	}
	
	public static class Integer extends Point {
		public int x;
		public int y;

		Integer() {
		}
		Integer(int x, int y){
			setLocation(x, y);
		}
		
		@Override
		public void setLocation(double x, double y) {
			this.x = (int) x;
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
		public String toString() {
			return getClass().getName() + " [" + super.serializedString() + "]";
		}
	}

	public abstract void setLocation(double x, double y);
	
	public void setLocation(Point p) {
		this.setLocation(p.getX(), p.getY());
	}
	
	public abstract double getX();
	public abstract double getY();
	public abstract String toString();
	protected String serializedString() {
		return "x=" + getX() + ",y=" + getY();
	}
	
	public double distanceSq(double x1, double y1, double x2, double y2) {
		x2 -= x1;
		y2 -= y1;
		return x2 * x2 + y2 * y2;
	}
	
	public double distanceSq(Point p) {
		return distanceSq(getX(), getY(), p.getX(), p.getY());
	}
	
	public double distance(Point p) {
		return Math.sqrt(distanceSq(p));
	}
	
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Point) {
            Point p = (Point) obj;
            return getX() == p.getX() && getY() == p.getY();
        }
        return false;
    }	
}
