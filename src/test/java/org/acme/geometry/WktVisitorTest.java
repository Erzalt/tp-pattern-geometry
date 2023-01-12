package org.acme.geometry;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class WktVisitorTest extends TestCase {
    public static final double EPSILON = 1.0e-15;

    public void testGetResult() {
        WktVisitor visitor = new WktVisitor();
        Geometry geometry = new Point(new Coordinate(3.0,4.0));
        geometry.accept(visitor);

        WktVisitor visitor3 = new WktVisitor();
        Geometry geometry3 = new Point();
        geometry3.accept(visitor3);
        assertEquals( "POINT (3.0 4.0)", visitor.getResult());
        assertEquals( "POINT EMPTY", visitor3.getResult());

        WktVisitor visitor2 = new WktVisitor();
        Point p1 = new Point(new Coordinate(0.0,0.1));
        Point p2 = new Point(new Coordinate(0.2,0.3));
        List<Point> lsPoint = new ArrayList<>();
        lsPoint.add(p1);
        lsPoint.add(p2);
        Geometry geometry2 = new LineString(lsPoint);
        geometry2.accept(visitor2);

        WktVisitor visitor4 = new WktVisitor();
        Geometry geometry4 = new LineString();
        geometry4.accept(visitor4);

        Assert.assertEquals("LINESTRING (0.0 0.1, 0.2 0.3)", visitor2.getResult());
        Assert.assertEquals("LINESTRING EMPTY", visitor4.getResult());
    }

    public void testVisit() {
    }

    public void testTestVisit() {
    }
}