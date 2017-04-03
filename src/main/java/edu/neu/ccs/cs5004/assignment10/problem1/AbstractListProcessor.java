package edu.neu.ccs.cs5004.assignment10.problem1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jeremy on 4/3/17.
 */
abstract class AbstractListProcessor extends AbstractLineProcessor {
    protected int currentNestingLevel(Text line) {
        Pattern regex = Pattern.compile("^([ ]*)(1.|.|\\*) .*"); // match all leading spaces,
        Matcher matcher = regex.matcher(line.getText());         // followed by . or 1. or *
        int numOfSpaces = 0;

        if (matcher.find()) {
            String match = matcher.group(1);
            numOfSpaces = match.length();
        }

        if (numOfSpaces % 2 == 1)   throw new IllegalArgumentException("num of spaces can only be even"); // TODO

        return numOfSpaces / 2 + 1;  // current nesting level
    }
}
