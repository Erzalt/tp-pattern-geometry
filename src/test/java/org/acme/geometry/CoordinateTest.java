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
	public void testIsEmpty() {
		// Test 0.3
		Coordinate c = new Coordinate();
		Assert.assertTrue(c.isEmpty());
	}


}
