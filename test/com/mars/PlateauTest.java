package com.mars;

import com.mars.Exception.InvalidEdgeException;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class PlateauTest {
    @Test
    public void test_should_create_plateau_with_edge() throws Exception {
        int edgeX = 5;
        int edgeY = 5;
        Plateau plateau = new Plateau(edgeX, edgeY);
        assertNotNull(plateau);
        assertEquals(edgeX,plateau.getEdgeX());
        assertEquals(edgeY, plateau.getEdgeY());
    }

    @Test(expected = InvalidEdgeException.class)
    public void test_should_throw_exception_when_create_plateau_with_invalid_edge() throws Exception {
        int invalidEdgeX = -1;
        int invalidEdgeY = -2;
        new Plateau(invalidEdgeX, invalidEdgeY);
    }

}
