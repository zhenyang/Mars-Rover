package com.mars;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SimulatorTest {
//    @Test
//    public void test_set_plateau_and_rover() throws Exception {
//        String input = "5 5\n1 2 N\n";
//        Simulator simulator = new Simulator();
//
//        String output = simulator.simulateRove(input);
//        assertEquals("1 2 N\n", output);
//    }

    @Test
    public void test_simulate_one_rover_with_move() throws Exception {
        String input = "5 5\n1 2 N\nM\n";
        Simulator simulator = new Simulator();

        String output = simulator.simulateRove(input);
        assertEquals("1 3 N\n", output);
    }

    @Test
    public void test_simulate_one_rover_with_multiple_move() throws Exception {
        String input = "5 5\n1 2 N\nLMLMLMLMM\n";
        Simulator simulator = new Simulator();

        String output = simulator.simulateRove(input);
        assertEquals("1 3 N\n", output);
    }

    @Test
    public void test_simulate_multiple_rovers_with_multiple_move() throws Exception {
        String input = "5 5\n" +
                "1 2 N\n" +
                "LMLMLMLMM\n" +
                "3 3 E\n" +
                "MMRMMRMRRM\n";
        Simulator simulator = new Simulator();

        String output = simulator.simulateRove(input);
        assertEquals("1 3 N\n5 1 E\n", output);
    }
}
