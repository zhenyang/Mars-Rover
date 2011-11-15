package com.mars;

import com.mars.Exception.OutOfEdgeException;

public class Rover {
    private FacingDirection direction;
    private Plateau plateau;
    private Coordinate coordinate;

    public Rover(Coordinate coordinate, FacingDirection direction, Plateau plateau) {
        this.coordinate = coordinate;
        this.direction = direction;
        this.plateau = plateau;
    }

    public FacingDirection getDirection() {
        return direction;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public String reportPosition() {
        return this.coordinate.toString()+" "+this.direction.toString() + "\n";
    }

    public void spinLeft() {
        direction = direction.spinLeft();
    }

    public void spinRight() {
        direction = direction.spinRight();
    }

    public void moveForward() throws OutOfEdgeException {
        this.coordinate = this.coordinate.plus(direction.moveCoordinate());
        checkCoordinate();
    }

    private void checkCoordinate() throws OutOfEdgeException {
        if (this.coordinate.getXCoordinate() > plateau.getEdgeX() || this.coordinate.getXCoordinate() < 0
                ||this.coordinate.getYCoordinate() > plateau.getEdgeY() || this.coordinate.getYCoordinate() < 0) {
            throw new OutOfEdgeException();
        }
    }
}
