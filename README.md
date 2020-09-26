# The Mars Rover Challenge

This is a simple yet highly extendable solution for The Mars Rover Challenge.

# Tech Stack
  - Spring Boot REST API running on Java 8
  - Gradle as the build toolset



# Assumptions and Design Decisions

- Even though the current plans are for operating in the curiosly square plateau,
the solution is designed in a way to easily add support for any shapes of terrain.
- The solution is designed to facilitate easy addition of new types of vehicles such as the 
MarsCopter Drone and adding new behaviors to existing vehicles.
- Vehicles are prevented from going outside their designated area of operation.
Since the solution makes use of the Command Pattern design, a future enhancement could easily 
have the vehicle retracing it's steps back to the starting position in such an error scenario.
- The core application logic is decoupled from Spring and is framework agnostic.
- Core application logic is covered under unit tests

# Running the solution
```sh
# Clone and cd to project dir
$ gradlew bootRun
```

# Testing
- Import "Rover.postman_collection.json" to PostMan
- Run "Rover Navigate" POST request

License
----
N/A
