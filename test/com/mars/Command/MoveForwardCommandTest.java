package com.mars.Command;

import com.mars.Rover;
import org.junit.Test;
import org.mockito.internal.verification.VerificationModeFactory;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MoveForwardCommandTest {
    @Test
    public void test_should_command_rover_move_forward() throws Exception {
        Rover rover = mock(Rover.class);
        MoveForwardCommand command = new MoveForwardCommand(rover);
        command.execute();
        verify(rover, VerificationModeFactory.times(1)).moveForward();
    }
}
