package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LineStringTest {

    public static final double EPSILON = 1.0e-15;

    @Test
    public void testLineString(){
        // Test 0.2
        Point p1 = new Point(new Coordinate(0.0,0.1));
        Point p2 = new Point(new Coordinate(0.2,0.3));
        List<Point> lsPoint = new ArrayList<>();
        lsPoint.add(p1);
        lsPoint.add(p2);

        LineString ls = new LineString(lsPoint);

        Assert.assertEquals(2, ls.getNumPoints(), EPSILON);
        Assert.assertEquals(0.0, ls.getPointN(0).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(0.2, ls.getPointN(1).getCoordinate().getX(), EPSILON);
    }

    @Test
    public void testIsEmptyLineString(){
        // Test 0.3
        LineString ls = new LineString();

        Point p1 = new Point(new Coordinate(0.0,0.1));
        List<Point> lsPoint = new ArrayList<>();
        lsPoint.add(p1);
        LineString ls1 = new LineString(lsPoint);

        Assert.assertTrue(ls.isEmpty());
        Assert.assertFalse(ls1.isEmpty());
    }

    @Test
    public void testTranslate(){
        // Test 0.4
        Point p1 = new Point(new Coordinate(0.0,0.1));
        Point p2 = new Point(new Coordinate(0.2,0.3));
        List<Point> lsPoint = new ArrayList<>();
        lsPoint.add(p1);
        lsPoint.add(p2);

        LineString ls = new LineString(lsPoint);
        ls.translate(0.2,0.3);
        Assert.assertEquals(0.2, ls.getPointN(0).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(0.4, ls.getPointN(1).getCoordinate().getX(), EPSILON);
    }

    @Test
    public void testGetType() {
        LineString ls = new LineString();
        Assert.assertEquals("LineString", ls.getType());
    }

    @Test
    public void testTestClone() {
        Point p1 = new Point(new Coordinate(0.0,0.1));
        Point p2 = new Point(new Coordinate(0.2,0.3));
        List<Point> lsPoint = new ArrayList<>();
        lsPoint.add(p1);
        lsPoint.add(p2);
        LineString ls = new LineString(lsPoint);
        Assert.assertNotSame(ls, ls.clone());
        Assert.assertEquals(ls.getPointN(0).getCoordinate().getX(),ls.clone().getPointN(0).getCoordinate().getX(),EPSILON);
        Assert.assertEquals(ls.getPointN(0).getCoordinate().getY(),ls.clone().getPointN(0).getCoordinate().getY(), EPSILON);

        LineString ls1 = ls.clone();
        ls1.getPointN(0).translate(0.2,0.8);
        Assert.assertNotEquals(ls.getPointN(0).getCoordinate().getX(),ls1.getPointN(0).getCoordinate().getX());

    }
    @Test
    public void testGetEnvelop() {
        Point p1 = new Point(new Coordinate(0.0,0.1));
        Point p2 = new Point(new Coordinate(0.2,0.3));
        Point p3 = new Point(new Coordinate(0.4,0.5));

        List<Point> lsPoint = new ArrayList<>();
        lsPoint.add(p1);
        lsPoint.add(p2);
        lsPoint.add(p3);
        LineString ls = new LineString(lsPoint);
        Assert.assertEquals(ls.getEnvelop().bottomLeft.getX(), 0.0,EPSILON);
        Assert.assertEquals(ls.getEnvelop().bottomLeft.getY(), 0.1,EPSILON);
        Assert.assertEquals(ls.getEnvelop().topRight.getX(), 0.4,EPSILON);
        Assert.assertEquals(ls.getEnvelop().topRight.getY(), 0.5,EPSILON);
    }

    @Test
    public void testAsText() {

        Point p1 = new Point(new Coordinate(0.0, 0.1));
        Point p2 = new Point(new Coordinate(0.2, 0.3));
        List<Point> lsPoint = new ArrayList<>();
        lsPoint.add(p1);
        lsPoint.add(p2);
        LineString ls = new LineString(lsPoint);
        Assert.assertEquals("LINESTRING (0.0 0.1, 0.2 0.3)", ls.asText());
    }
}