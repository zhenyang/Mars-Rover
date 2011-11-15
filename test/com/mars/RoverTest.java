package com.mars;

import com.mars.Exception.InvalidEdgeException;
import com.mars.Exception.OutOfEdgeException;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class RoverTest {

    private static final int EDGE_X = 5;
    private static final int EDGE_Y = 5;
    private static final int VALID_X_COORDINATE = 3;
    private static final int VALID_Y_COORDINATE = 3;
    private static final int UPPER_EDGE_Y_COORDINATE = 5;
    private static final int DOWNER_EDGE_Y_COORDINATE = 0;
    private static final int LEFT_EDGE_X_COORDINATE = 0;
    private static final int RIGHT_EDGE_X_COORDINATE = 5;

    @Test
    public void test_create_a_rover() throws Exception {
        Rover rover = createRoverAtCenter();
        assertNotNull(rover);
    }

    @Test
    public void test_report_position() throws Exception {
        Rover rover = createRoverAtCenter();
        assertEquals("3 3 N\n",rover.reportPosition());
    }

    @Test
    public void test_move_forward() throws Exception {
        Rover rover = createRoverAtCenter();
        rover.moveForward();

        assertEquals(new Coordinate(VALID_X_COORDINATE, VALID_Y_COORDINATE + 1), rover.getCoordinate());
    }

    @Test(expected = OutOfEdgeException.class)
    public void test_move_upper_out_of_edge_Y() throws Exception {
        Rover rover = createRoverAtUpperEdge();
        rover.moveForward();
    }

    @Test(expected = OutOfEdgeException.class)
    public void test_move_downer_out_of_edge_Y() throws Exception {
        Rover rover = createRoverAtDownerEdge();
        rover.moveForward();
    }

    @Test(expected = OutOfEdgeException.class)
    public void test_move_left_out_of_edge_X() throws Exception {
        Rover rover = createRoverAtLeftEdge();
        rover.moveForward();
    }

    @Test(expected = OutOfEdgeException.class)
    public void test_move_right_out_of_edge_X() throws Exception {
        Rover rover = createRoverAtRightEdge();
        rover.moveForward();
    }

    @Test
    public void test_spin_left_and_spin_right() throws Exception {
        Rover rover = createRoverAtCenter();

        rover.spinLeft();
        assertEquals(FacingDirection.WEST, rover.getDirection());

        rover.spinRight();
        assertEquals(FacingDirection.NORTH, rover.getDirection());
    }


    private Rover createRoverAtCenter() throws InvalidEdgeException {
        Plateau plateau = new Plateau(EDGE_X, EDGE_Y);
        Coordinate coordinate = new Coordinate(VALID_X_COORDINATE, VALID_Y_COORDINATE);
        FacingDirection direction = FacingDirection.NORTH;

        return new Rover(coordinate, direction, plateau);
    }

    private Rover createRoverAtDownerEdge() throws InvalidEdgeException {
        Plateau plateau = new Plateau(EDGE_X, EDGE_Y);
        Coordinate coordinate = new Coordinate(VALID_X_COORDINATE, DOWNER_EDGE_Y_COORDINATE);
        FacingDirection direction = FacingDirection.SOUTH;

        return new Rover(coordinate, direction, plateau);

    }

    private Rover createRoverAtUpperEdge() throws InvalidEdgeException {
        Plateau plateau = new Plateau(EDGE_X, EDGE_Y);
        Coordinate coordinate = new Coordinate(VALID_X_COORDINATE, UPPER_EDGE_Y_COORDINATE);
        FacingDirection direction = FacingDirection.NORTH;

        return new Rover(coordinate, direction, plateau);
    }

    private Rover createRoverAtLeftEdge() throws InvalidEdgeException {
        Plateau plateau = new Plateau(EDGE_X, EDGE_Y);
        Coordinate coordinate = new Coordinate(LEFT_EDGE_X_COORDINATE, VALID_Y_COORDINATE);
        FacingDirection direction = FacingDirection.WEST;

        return new Rover(coordinate, direction, plateau);
    }

    private Rover createRoverAtRightEdge() throws InvalidEdgeException {
        Plateau plateau = new Plateau(EDGE_X, EDGE_Y);
        Coordinate coordinate = new Coordinate(RIGHT_EDGE_X_COORDINATE, VALID_Y_COORDINATE);
        FacingDirection direction = FacingDirection.EAST;

        return new Rover(coordinate, direction, plateau);
    }
}
