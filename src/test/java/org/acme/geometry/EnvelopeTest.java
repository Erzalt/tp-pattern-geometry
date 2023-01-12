package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeTest {

    public static final double EPSILON = 1.0e-15;

    @Test
    public void testDefaultConstructor() {
        Coordinate bl = new Coordinate();
        Coordinate tr = new Coordinate();
        Envelope e = new Envelope();

        Assert.assertEquals(bl.getX(), e.bottomLeft.getX(), EPSILON);
        Assert.assertEquals(tr.getX(), e.topRight.getX(), EPSILON);
    }

    @Test
    public void testConstructor() {
        Coordinate bl = new Coordinate(0.0, 0.2);
        Coordinate tr = new Coordinate(0.3, 0.4);
        Envelope e = new Envelope(bl, tr);

        Assert.assertEquals(bl.getX(), e.bottomLeft.getX(), EPSILON);
        Assert.assertEquals(tr.getX(), e.topRight.getX(), EPSILON);
    }

    @Test
    public void testIsEmpty() {
        Coordinate bl = new Coordinate();
        Coordinate tr = new Coordinate();
        Envelope e = new Envelope(bl, tr);

        Assert.assertTrue(e.isEmpty());

        Coordinate bl2 = new Coordinate(0.0, 0.2);
        Coordinate tr2 = new Coordinate(0.3, 0.4);
        Envelope e2 = new Envelope(bl2, tr2);
        Assert.assertFalse(e2.isEmpty());
    }

    @Test
    public void testGetMinMax() {
        Coordinate bl = new Coordinate(0.0, 0.2);
        Coordinate tr = new Coordinate(0.3, 0.4);
        Envelope e = new Envelope(bl, tr);

        Assert.assertEquals(0.3, e.getXmax(), EPSILON);
        Assert.assertEquals(0.4, e.getYmax(), EPSILON);
        Assert.assertEquals(0.0, e.getXmin(), EPSILON);
        Assert.assertEquals(0.2, e.getYmin(), EPSILON);

        Coordinate bl2 = new Coordinate(0.3, 0.4);
        Coordinate tr2 = new Coordinate(0.0, 0.2);
        Envelope e2 = new Envelope(bl2, tr2);

        Assert.assertEquals(0.3, e2.getXmax(), EPSILON);
        Assert.assertEquals(0.4, e2.getYmax(), EPSILON);
        Assert.assertEquals(0.0, e2.getXmin(), EPSILON);
        Assert.assertEquals(0.2, e2.getYmin(), EPSILON);
    }
}
