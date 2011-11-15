package com.mars;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class FacingDirectionTest {
    @Test
    public void test_north_direction() throws Exception {
        FacingDirection north = FacingDirection.NORTH;

        assertEquals("N", north.toString());
        assertEquals(new Coordinate(0, 1), north.moveCoordinate());
        assertEquals(FacingDirection.WEST, north.spinLeft());
        assertEquals(FacingDirection.EAST, north.spinRight());
    }

    @Test
    public void test_east_direction() throws Exception {
        FacingDirection east = FacingDirection.EAST;

        assertEquals("E", east.toString());
        assertEquals(new Coordinate(1, 0), east.moveCoordinate());
        assertEquals(FacingDirection.NORTH, east.spinLeft());
        assertEquals(FacingDirection.SOUTH, east.spinRight());
    }

    @Test
    public void test_south_direction() throws Exception {
        FacingDirection south = FacingDirection.SOUTH;

        assertEquals("S", south.toString());
        assertEquals(new Coordinate(0, -1), south.moveCoordinate());
        assertEquals(FacingDirection.EAST, south.spinLeft());
        assertEquals(FacingDirection.WEST, south.spinRight());
    }

    @Test
    public void test_west_direction() throws Exception {
        FacingDirection west = FacingDirection.WEST;

        assertEquals("W", west.toString());
        assertEquals(new Coordinate(-1, 0), west.moveCoordinate());
        assertEquals(FacingDirection.SOUTH, west.spinLeft());
        assertEquals(FacingDirection.NORTH, west.spinRight());
    }

}
