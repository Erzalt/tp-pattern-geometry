package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testDefaultConstructor() {
		// Test 0.1
		Coordinate c = new Coordinate(0.0,0.0);
		Assert.assertEquals(0.0, c.getX(), EPSILON);
		Assert.assertEquals(0.0, c.getY(), EPSILON);
	}

	@Test
	public void testConstructorCoordinate() {
		// Test 0.1
		Coordinate c = new Coordinate(0.0,0.0);
		Point p = new Point(c);
		Assert.assertSame(c, p.getCoordinate());
	}

	@Test
	public void testIsEmpty() {
		// Test 0.3
		Coordinate c = new Coordinate();
		Coordinate c2 = new Coordinate(0.2,0.5);

		Assert.assertTrue(c.isEmpty());
		Assert.assertFalse(c2.isEmpty());
	}

	public void testGetX() {
	}

	public void testSetX() {
	}

	public void testGetY() {
	}

	public void testSetY() {
	}
}
