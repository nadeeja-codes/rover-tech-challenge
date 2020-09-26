package com.nasa.rover.core.input;

import com.nasa.rover.core.NavigationPath;
import com.nasa.rover.core.input.exceptions.MalformedInputException;

import java.util.List;

public interface InputParser {

    List<NavigationPath> parse() throws MalformedInputException;

}
