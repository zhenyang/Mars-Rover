package com.mars;

import com.mars.Command.CommandFactory;
import com.mars.Command.ICommand;
import com.mars.Exception.ErrorDirectionException;
import com.mars.Exception.InvalidEdgeException;
import com.mars.Exception.UnknownCommandException;

import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private CommandFactory commandFactory;

    public Simulator() {
        commandFactory = new CommandFactory();
    }

    public String simulateRove(String input) {
        String[] lines = input.split("\n");

        Rover rover;
        String result = "";
        try {
            Plateau plateau = createPlateau(lines[0]);
            for (int i = 1; i < lines.length; i += 2) {
                rover = createRover(lines[i], plateau);
                List<ICommand> commands = createCommands(lines[i+1],rover);
                executeCommands(commands);
                result += rover.reportPosition();
            }
        } catch (InvalidEdgeException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ErrorDirectionException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (UnknownCommandException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return result;
    }

    private void executeCommands(List<ICommand> commands) throws Exception {
        for (ICommand command : commands) {
            command.execute();
        }
    }

    private List<ICommand> createCommands(String line, Rover rover) throws UnknownCommandException {
        char[] commandNames = line.toCharArray();
        ArrayList<ICommand> commands = new ArrayList<ICommand>();
        for (char commandName : commandNames) {
            commands.add(commandFactory.createCommand(String.valueOf(commandName), rover));
        }
        return commands;
    }

    private Rover createRover(String line, Plateau plateau) throws ErrorDirectionException {
        String[] coordinateAndDirection = line.split(" ");
        int xCoordinate = Integer.parseInt(coordinateAndDirection[0]);
        int yCoordinate = Integer.parseInt(coordinateAndDirection[1]);
        Coordinate coordinate = new Coordinate(xCoordinate, yCoordinate);
        FacingDirectionFactory directionFactory = new FacingDirectionFactory();
        FacingDirection direction = directionFactory.create(coordinateAndDirection[2]);
        return new Rover(coordinate, direction, plateau);
    }

    public Plateau createPlateau(String line) throws InvalidEdgeException {
        String[] edges = line.split(" ");
        int edgeX = Integer.parseInt(edges[0]);
        int edgeY = Integer.parseInt(edges[1]);
        Plateau plateau;
        plateau = new Plateau(edgeX, edgeY);
        return plateau;
    }

}
