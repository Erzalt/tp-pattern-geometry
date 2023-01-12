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
        Assert.assertSame( c, p.getCoordinate());
    }


    @Test
    public void testIsEmptyPoint(){
        // Test 0.3
        Point p = new Point();
        Point p2 = new Point(new Coordinate(0.2,0.3));
        Assert.assertTrue(p.isEmpty());
        Assert.assertFalse(p2.isEmpty());

    }

    @Test
    public void testTranslate(){
        // Test 0.4
        Point p = new Point(new Coordinate(0.2, 0.3));
        p.translate(0.3,0.3);
        Assert.assertEquals(0.5, p.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(0.6, p.getCoordinate().getY(), EPSILON);
    }

    @Test
    public void testGetType() {
        Geometry p = new Point();
        Assert.assertEquals("Point", p.getType());
    }

    @Test
    public void testTestClone() {

        Point p = new Point(new Coordinate(0.2, 0.3));
        Point p2 = p.clone();

        Assert.assertEquals(p.getCoordinate().getX(), p2.getCoordinate().getX(),EPSILON);
        Assert.assertNotSame(p,p2);

        p2.translate(0.2,0.8);
        Assert.assertNotEquals(p.getCoordinate(), p2.getCoordinate());

    }
    @Test
    public void testGetEnvelop() {
        Point p = new Point(new Coordinate(0.2, 0.3));
        Assert.assertEquals(p.getEnvelop().bottomLeft.getX(), 0.2,EPSILON);
        Assert.assertEquals(p.getEnvelop().bottomLeft.getY(), 0.3,EPSILON);
        Assert.assertEquals(p.getEnvelop().topRight.getX(), 0.2,EPSILON);
        Assert.assertEquals(p.getEnvelop().topRight.getY(), 0.3,EPSILON);
    }

    @Test
    public void testAsText() {
        Point p = new Point(new Coordinate(0.2, 0.3));
        Assert.assertEquals("POINT (0.2 0.3)" , p.asText());
    }
}
