package org.acme.geometry;


public class Envelope {
    Coordinate bottomLeft;
    Coordinate topRight;

    public Envelope(){
        this.bottomLeft = new Coordinate();
        this.topRight = new Coordinate();
    }

    public Envelope(Coordinate bottomLeft, Coordinate topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public Boolean isEmpty(){
        if(bottomLeft.isEmpty() || topRight.isEmpty()){
            return true;
        }
        return false;
    }

    public double getXmin(){
        if(bottomLeft.getX() <= topRight.getX()){
            return bottomLeft.getX();
        }
        return topRight.getX();
    }

    public double getYmin(){
        if(bottomLeft.getY() <= topRight.getY()){
            return bottomLeft.getY();
        }
        return topRight.getY();
    }

    public double getXmax(){
        if(bottomLeft.getX() >= topRight.getX()){
            return bottomLeft.getX();
        }
        return topRight.getX();
    }

    public double getYmax(){
        if(bottomLeft.getY() >= topRight.getY()){
            return bottomLeft.getY();
        }
        return topRight.getY();
    }





}
