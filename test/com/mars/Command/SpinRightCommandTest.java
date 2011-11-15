package com.mars.Command;

import com.mars.Rover;
import org.junit.Test;
import org.mockito.internal.verification.VerificationModeFactory;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SpinRightCommandTest {
    @Test
    public void test_should_command_rover_spin_right() throws Exception {
        Rover rover = mock(Rover.class);
        SpinRightCommand command = new SpinRightCommand(rover);
        command.execute();
        verify(rover, VerificationModeFactory.times(1)).spinRight();
    }

}
