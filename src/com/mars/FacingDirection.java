package com.mars;

public enum FacingDirection {
    NORTH("N", new Coordinate(0,1), "WEST", "EAST"),
    EAST("E", new Coordinate(1,0), "NORTH", "SOUTH"),
    SOUTH("S", new Coordinate(0,-1), "EAST", "WEST"),
    WEST("W", new Coordinate(-1,0), "SOUTH", "NORTH");

    private String shortName;
    private Coordinate coordinate;
    private String spinLeftName;
    private String spinRightName;

    FacingDirection(String shortName, Coordinate coordinate, String spinLeftName, String spinRightName) {
        this.shortName = shortName;
        this.coordinate = coordinate;
        this.spinLeftName = spinLeftName;
        this.spinRightName = spinRightName;
    }

    @Override
    public String toString() {
        return shortName;
    }

    public Coordinate moveCoordinate() {
        return coordinate;
    }

    public FacingDirection spinLeft() {
        return FacingDirection.valueOf(spinLeftName);
    }

    public FacingDirection spinRight() {
        return FacingDirection.valueOf(spinRightName);
    }
}
