package org.acme.geometry;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EnvelopeBuilderTest extends TestCase {
    public static final double EPSILON = 1.0e-15;

    @Test
    public void testInsert() {
        EnvelopeBuilder builder = new EnvelopeBuilder();
        builder.insert(new Coordinate(0.0,1.0));
        builder.insert(new Coordinate(2.0,3.0));
        Assert.assertEquals(2, builder.coordinates.size(), EPSILON);
    }

    @Test
    public void testBuild() {
        EnvelopeBuilder builder = new EnvelopeBuilder();
        builder.insert(new Coordinate(0.0,1.0));
        builder.insert(new Coordinate(2.0,0.0));
        builder.insert(new Coordinate(1.0,3.0));
        Envelope result = builder.build();
        Assert.assertEquals(0.0, result.bottomLeft.getX(), EPSILON);
        Assert.assertEquals(0.0, result.bottomLeft.getY(), EPSILON);
        Assert.assertEquals(2.0, result.topRight.getX(), EPSILON);
        Assert.assertEquals(3.0, result.topRight.getY(), EPSILON);
    }
}