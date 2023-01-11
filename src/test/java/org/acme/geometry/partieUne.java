package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class partieUne {

    public static final double EPSILON = 1.0e-15;

    @Test
    public void testPoint(){
        // Test 0.2
        Coordinate c = new Coordinate();
        Point p = new Point(c);
        Assert.assertEquals(0.0, p.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(0.0, p.getCoordinate().getY(), EPSILON);
    }
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

}