package com.mars;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CoordinateTest {

    @Test
    public void test_should_equal() throws Exception {
        Coordinate coordinate = new Coordinate(1, 1);
        Coordinate sameCoordinate = new Coordinate(1, 1);

        assertEquals(coordinate, sameCoordinate);
    }

    @Test
    public void test_should_add_coordinates() throws Exception {
        Coordinate baseCoordinate = new Coordinate(2, 2);
        Coordinate addedCoordinate = new Coordinate(0, -1);
        Coordinate result = baseCoordinate.plus(addedCoordinate);

        assertEquals(2,result.getXCoordinate());
        assertEquals(1,result.getYCoordinate());
    }
}
