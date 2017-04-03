package edu.neu.ccs.cs5004.assignment10.problem1;

import java.util.NavigableMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jeremy on 4/2/17.
 */
public class EnumerationListsProcessor extends AbstractLineProcessor {
    @Override
    public Text processLine(Text line, MarkdownProcessor markdownProcessor) {
        NavigableMap<Integer, Integer> map = markdownProcessor.getEnumlistLevel();
        int currLevel = getCurrentEnumLevel(line);
        int lastLevel = map.size() == 0 ? 0 : map.lastKey();

        if (currLevel >  lastLevel + 1)  throw new IllegalArgumentException("skipping nesting level"); // TODO: exception
        if (currLevel == lastLevel + 1)  map.put(currLevel, 1);
        else                             map.put(currLevel, map.get(currLevel)+1);
        String processedLine;
        if (currLevel % 2 == 0) {
            String num = String.valueOf((char) ((map.get(currLevel)-1) + 'a')) + ".";
            processedLine = line.getText().replaceFirst("[1]?\\.", num);
        } else {
            processedLine = line.getText().replaceFirst("[1]?\\.", map.get(currLevel).toString() + ".");
        }

        return new Text(processedLine);
    }

    private int getCurrentEnumLevel(Text line) {
        Pattern regex = Pattern.compile("^([ ]*)[1]?\\..*");  // match all leading spaces
        Matcher matcher = regex.matcher(line.getText());
        int numOfSpaces = 0;

        if (matcher.find()) {
            String match = matcher.group(1);
            numOfSpaces = match.length();
        }

        if (numOfSpaces % 2 == 1)   throw new IllegalArgumentException("num of spaces can only be even"); // TODO

        return numOfSpaces / 2 + 1;  // current nesting level
    }

}
