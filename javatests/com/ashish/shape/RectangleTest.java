package com.ashish.shape;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RectangleTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIntersection() {
		Rectangle r1 = new Rectangle.Double(1, 1, 5, 4);		
		Rectangle r2 = new Rectangle.Double(2, 2, 5, 4);
		Assert.assertTrue(r1.intersects(r2));
	}
	
	@Test
	public void testIterator() {
		Rectangle r1 = new Rectangle.Double(1, 1, 5, 4);
		PointIterator iter = r1.getIterator();
		
		Point[] points = new Point[4];
		points[0] = new Point.Double(1,1);
		points[1] = new Point.Double(6,1);
		points[2] = new Point.Double(6,5);
		points[3] = new Point.Double(1,5);
		
		for(int i=0; i<4; i++) {
			Assert.assertFalse(iter.done());
			Point p = iter.next();
			Assert.assertTrue(points[i].equals(p));
		}
		Assert.assertTrue(iter.done());
		Assert.assertNull(iter.next());
	}

}
