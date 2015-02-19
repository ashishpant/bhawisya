package com.ashish.shape_testing_binary;

import com.ashish.shape.PointIterator;
import com.ashish.shape.Rectangle;

public class Main {

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle.Integer(2, 4, 100, 100);		
		System.out.println(rectangle.toString());
		
		Rectangle rect1 = new Rectangle.Double(3, 6, 50, 50);
		System.out.println(rect1.intersects(rectangle) ? "Intersects" : "Does not intersect");
		System.out.println(rectangle.contains(rect1) ? "Contains" : "Does not contain");
		
		PointIterator iter = rect1.getIterator();
		while(!iter.done()) {
			System.out.println(iter.next().toString());
		}
	}
}
