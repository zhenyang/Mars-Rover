package com.mars.Command;

import com.mars.Exception.UnknownCommandException;
import com.mars.Rover;

public class CommandFactory {

    public ICommand createCommand(String command, Rover rover) throws UnknownCommandException {
        if (command.equals("M")) {
            return new MoveForwardCommand(rover);
        }
        if (command.equals("L")) {
            return new SpinLeftCommand(rover);
        }
        if (command.equals("R")) {
            return new SpinRightCommand(rover);
        }
        throw new UnknownCommandException();
    }
}
