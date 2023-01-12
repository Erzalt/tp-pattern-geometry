package org.acme.geometry;

import javax.sound.sampled.Line;

public interface GeometryVisitor {

    public void visit(Point point);
    public void visit (LineString lineString);
}
