package com.mars.Command;

import com.mars.Rover;

public class SpinLeftCommand implements ICommand{

    private Rover rover;

    public SpinLeftCommand(Rover rover) {
        this.rover = rover;
    }

    public void execute() throws Exception {
        rover.spinLeft();
    }
}
