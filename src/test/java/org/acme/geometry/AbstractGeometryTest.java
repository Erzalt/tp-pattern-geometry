package org.acme.geometry;

import junit.framework.TestCase;

public class AbstractGeometryTest extends TestCase {

    public void testAsText() {
        AbstractGeometry p = new Point(new Coordinate(3.0,4.0));
        WktVisitor visitor = new WktVisitor();
        AbstractGeometry  geometry = new Point(new Coordinate(3.0,4.0));
        geometry.accept(visitor);
        assertEquals( p.asText(), visitor.getResult());
    }

    public void testTestClone() {
    }

    public void testGetEnvelop() {
    }
}