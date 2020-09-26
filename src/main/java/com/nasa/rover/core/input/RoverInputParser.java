package com.nasa.rover.core.input;

import com.nasa.rover.core.NavigationPath;
import com.nasa.rover.core.commands.Command;
import com.nasa.rover.core.commands.factory.RoverCommandFactory;
import com.nasa.rover.core.models.Heading;
import com.nasa.rover.core.models.Point;
import com.nasa.rover.core.models.Position;
import com.nasa.rover.core.models.terrain.SquareTerrain;
import com.nasa.rover.core.models.terrain.Terrain;
import com.nasa.rover.core.models.vehicle.Rover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoverInputParser implements InputParser {

    private final RoverCommandFactory commandFactory;
    private final List<String> lines;

    public RoverInputParser(String inputString, RoverCommandFactory commandFactory) {
        this.commandFactory = commandFactory;

        lines = Arrays.asList(inputString.split("\n"));
    }

    // Parse string input into NavigationPath objects
    @Override
    public List<NavigationPath> parse() throws MalformedInputException {
        try {
            List<NavigationPath> navigationPaths = new ArrayList<>();
            Terrain terrain = getTerrain(lines.get(0));

            // go 2 lines at a time
            for(int i = 1; i < lines.size(); i += 2) {
                Position position =  getStartPosition(lines.get(i));
                Rover rover = new Rover(position, terrain);
                navigationPaths.add(new NavigationPath(rover, getCommandList(lines.get(i+1), rover)));
            }
            return navigationPaths;
        } catch (Exception e) {
            throw new MalformedInputException("Parse failed. Possible malformed input", e);
        }

    }

    private List<Command<Position>> getCommandList(String line, Rover rover) {
        List<Command<Position>> commands = new ArrayList<>();

        for (char c : line.toCharArray()) {
            commands.add(commandFactory.getCommand(String.valueOf(c), rover));
        }
        return commands;
    }

    private Position getStartPosition(String line) {
        String[] values = line.split(" ");
        int x = Integer.parseInt(values[0]);
        int y = Integer.parseInt(values[1]);
        Heading heading = Heading.fromCode(values[2]);

        return new Position(new Point(x,y), heading);
    }

    private Terrain getTerrain(String line) {
        int x, y;
        String[] values = line.split(" ");
        x = Integer.parseInt(values[0]);
        y = Integer.parseInt(values[1]);

        // TODO: Get from a terrain factory
        return new SquareTerrain(new Point(0,0), new Point(x,y));
    }
}
