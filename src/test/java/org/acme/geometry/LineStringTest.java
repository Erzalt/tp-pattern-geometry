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
        Assert.assertTrue(ls.isEmpty());
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

}