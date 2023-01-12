package org.acme.geometry;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WktWriterTest extends TestCase {

    public static final double EPSILON = 1.0e-15;

    @Test
    public void testWrite() {

        Geometry g = new Point(new Coordinate(3.0, 4.0));
        WktWriter writer = new WktWriter();
        Assert.assertEquals("POINT (3.0 4.0)", writer.write(g));

        Geometry g2 = new Point();
        Assert.assertEquals("POINT EMPTY", writer.write(g2));

        Point p1 = new Point(new Coordinate(0.0,0.1));
        Point p2 = new Point(new Coordinate(0.2,0.3));
        List<Point> lsPoint = new ArrayList<>();
        lsPoint.add(p1);
        lsPoint.add(p2);
        Geometry ls = new LineString(lsPoint);

        Assert.assertEquals("LINESTRING (0.0 0.1, 0.2 0.3)", writer.write(ls));

        Geometry ls2 = new LineString();
        Assert.assertEquals("LINESTRING EMPTY", writer.write(ls2));

    }
}
