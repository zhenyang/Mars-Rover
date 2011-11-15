package com.mars.Command;

import com.mars.Rover;

public class SpinRightCommand implements ICommand{
    private Rover rover;

    public SpinRightCommand(Rover rover) {
        this.rover = rover;
    }

    public void execute() throws Exception {
        rover.spinRight();
    }
}
