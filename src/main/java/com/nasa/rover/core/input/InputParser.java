package com.nasa.rover.core.input;

import com.nasa.rover.core.NavigationPath;

import java.util.List;

public interface InputParser {

    List<NavigationPath> parse() throws MalformedInputException;

}
