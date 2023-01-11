package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    public static final double EPSILON = 1.0e-15;

    @Test
    public void testPoint(){
        // Test 0.2
        Coordinate c = new Coordinate(0.0,0.0);
        Point p = new Point(c);
        Assert.assertEquals(0.0, p.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(0.0, p.getCoordinate().getY(), EPSILON);
    }

    @Test
    public void testIsEmptyPoint(){
        // Test 0.3
        Point p = new Point();
        Assert.assertTrue(p.isEmpty());
    }

    @Test
    public void testTranslate(){
        // Test 0.4
        Point p = new Point(new Coordinate(0.2, 0.3));
        p.translate(0.3,0.3);
        Assert.assertEquals(0.5, p.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(0.6, p.getCoordinate().getY(), EPSILON);
    }

}
