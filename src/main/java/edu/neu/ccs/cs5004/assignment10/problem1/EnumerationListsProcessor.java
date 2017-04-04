package edu.neu.ccs.cs5004.assignment10.problem1;

import java.util.NavigableMap;

/**
 * Created by Jeremy on 4/2/17.
 */
class EnumerationListsProcessor extends AbstractListProcessor {
    @Override
    public Text processLine(Text line, MarkdownProcessor markdownProcessor) {
        NavigableMap<Integer, Integer> map = markdownProcessor.getListLevels();
        int currLevel = currentNestingLevel(line);
        int lastLevel = map.size() == 0 ? 0 : map.lastKey();

        if (currLevel >  lastLevel + 1)
            throw new IllegalMarkdownFormatException("Cannot skip nesting level.");
        if (currLevel == lastLevel + 1)  map.put(currLevel, 1);
        else {
            int levelValue = map.get(currLevel);
            if (levelValue == -1)
                throw new IllegalMarkdownFormatException("Mixing enum and itemization at the same nesting level is not allowed");
            map.put(currLevel, levelValue+1);
            for (int i = currLevel+1; i <= lastLevel; i++) {
                map.remove(i);  // remove deeper nesting levels
            }
        }
        String processedLine;
        if (currLevel % 2 == 0) {
            String letter = numToLetters(map.get(currLevel));
            processedLine = line.getText().replaceFirst("[1]?\\.", letter);
        } else {
            processedLine = line.getText().replaceFirst("[1]?\\.", map.get(currLevel).toString() + ".");
        }

        return new Text(processedLine);
    }

    private String numToLetters(int n) {
        StringBuilder res = new StringBuilder();
        while (n-- != 0) {
            res.append((char) ('a' + n % 26));
            n /= 26;
        }
        return res.reverse().append(".").toString();
    }

}
