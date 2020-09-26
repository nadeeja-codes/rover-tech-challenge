package com.nasa.rover;

import com.nasa.rover.core.NavigationPath;
import com.nasa.rover.core.commands.factory.RoverCommandFactory;
import com.nasa.rover.core.executors.CommandExecutor;
import com.nasa.rover.core.input.RoverInputParser;
import com.nasa.rover.core.input.exceptions.MalformedInputException;
import com.nasa.rover.core.models.position.Position;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping(path = "rover")
public class RoverController {
    private static final Logger LOGGER = getLogger(RoverController.class);

    @Autowired
    private RoverCommandFactory roverCommandFactory;
    @Autowired
    private CommandExecutor<Position> commandExecutor;

    @PostMapping("/navigate")
    public String navigate(@RequestBody String commands) {
        LOGGER.info("Started processing navigate request: {}", commands);
        try {
            List<NavigationPath> navigationPaths = new RoverInputParser(commands, roverCommandFactory).parse();
            String response = "";

            for(NavigationPath navigationPath : navigationPaths) {
                commandExecutor.add(navigationPath.getCommands()).executeCommands();
                response += navigationPath.getVehicle().getPosition().toString() + "\r\n";
            }

            LOGGER.info("Finished processing navigate request. Response: {}", response);

            return response;

        } catch (IndexOutOfBoundsException | MalformedInputException e) {
            LOGGER.error("Error while processing navigate request", e);
            return e.getMessage();
        }
    }
}
