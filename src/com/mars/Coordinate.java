package com.mars;

public class Coordinate {
    private int xCoordinate;
    private int yCoordinate;

    public Coordinate(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        return xCoordinate == that.xCoordinate && yCoordinate == that.yCoordinate;

    }

    @Override
    public String toString() {
        return xCoordinate + " " + yCoordinate;
    }

    public Coordinate plus(Coordinate addedCoordinate) {
        return new Coordinate(this.xCoordinate + addedCoordinate.getXCoordinate(), this.yCoordinate + addedCoordinate.getYCoordinate());
    }
}
