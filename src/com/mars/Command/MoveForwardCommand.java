package com.mars.Command;

import com.mars.Exception.OutOfEdgeException;
import com.mars.Rover;

public class MoveForwardCommand implements ICommand{
    private Rover rover;

    public MoveForwardCommand(Rover rover) {
        this.rover = rover;
    }

    public void execute() throws OutOfEdgeException {
        rover.moveForward();
    }
}
