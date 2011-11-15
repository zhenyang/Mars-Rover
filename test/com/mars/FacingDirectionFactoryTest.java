package com.mars;

import com.mars.Exception.ErrorDirectionException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class FacingDirectionFactoryTest {

    private FacingDirectionFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = new FacingDirectionFactory();
    }

    @Test
    public void test_should_create_direction_given_valid_input() throws Exception {
        assertEquals(FacingDirection.EAST, factory.create("E"));
        assertEquals(FacingDirection.WEST, factory.create("W"));
        assertEquals(FacingDirection.NORTH, factory.create("N"));
        assertEquals(FacingDirection.SOUTH, factory.create("S"));
    }

    @Test(expected = ErrorDirectionException.class)
    public void test_should_throw_exception_given_invalid_input() throws Exception {
        factory.create("A");
    }
}
