
package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class LogGeometryVisitorTest {
    public static final double EPSILON = 1.0e-15;

    @Test
    public void testVisitPoint() {

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);

        Geometry geometry = new Point(new Coordinate(3.0, 4.0));
        geometry.accept(visitor);

        String result = os.toString();

        Assert.assertEquals("Je suis un point avec x=3.0 et y=4.0", result.trim());
        // result.trim permet de supprimer les \n et espaces vides
    }

    @Test
    public void testVisitLineString() {

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);

        Point p1 = new Point(new Coordinate(0.0, 0.1));
        Point p2 = new Point(new Coordinate(0.2, 0.3));
        List<Point> lsPoint = new ArrayList<>();
        lsPoint.add(p1);
        lsPoint.add(p2);

        Geometry geometry = new LineString(lsPoint);
        geometry.accept(visitor);

        String result = os.toString();

        Assert.assertEquals("Je suis une polyligne définir par 2 point(s)", result.trim());
        // result.trim permet de supprimer les \n et espaces vides
    }
}