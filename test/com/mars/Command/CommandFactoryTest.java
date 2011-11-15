package com.mars.Command;

import com.mars.Exception.UnknownCommandException;
import com.mars.Rover;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class CommandFactoryTest {

    private CommandFactory commandFactory;

    @Before
    public void setUp() throws Exception {
        commandFactory = new CommandFactory();
    }

    @Test
    public void test_create_move_forward_command() throws Exception {
        Rover rover = createRover();
        ICommand command = commandFactory.createCommand("M", rover);
        assertEquals(command.getClass(), MoveForwardCommand.class);
    }

    @Test
    public void test_create_spin_left_command() throws Exception {
        Rover rover = createRover();
        ICommand command = commandFactory.createCommand("L", rover);
        assertEquals(command.getClass(), SpinLeftCommand.class);
    }

    @Test
    public void test_create_spin_right_command() throws Exception {
        Rover rover = createRover();
        ICommand command = commandFactory.createCommand("R", rover);
        assertEquals(command.getClass(), SpinRightCommand.class);
    }

    @Test(expected = UnknownCommandException.class)
    public void test_should_throw_exception_given_unknown_command() throws Exception {
        Rover rover = createRover();
        ICommand command = commandFactory.createCommand("C", rover);
    }

    private Rover createRover() {
        return mock(Rover.class);
    }
}
