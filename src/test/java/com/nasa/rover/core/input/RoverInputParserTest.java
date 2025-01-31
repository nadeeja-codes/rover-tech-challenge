package com.nasa.rover.core.input;

import com.nasa.rover.core.NavigationPath;
import com.nasa.rover.core.commands.factory.RoverCommandFactory;
import com.nasa.rover.core.input.exceptions.MalformedInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoverInputParserTest {

    private RoverCommandFactory commandFactory;
    @BeforeEach
    void setUp() {
        commandFactory = new RoverCommandFactory();
    }

    @Test
    void parse_should_return_nav_paths_for_valid_input() throws MalformedInputException {
        RoverInputParser roverInputParser =
                new RoverInputParser("5 5\r\n1 2 N\r\nLMLMLMLMM\r\n3 3 E\r\nMMRMMRMRRM", commandFactory);

        List<NavigationPath> navigationPaths = roverInputParser.parse();

        assertEquals(2, navigationPaths.size());
    }
}