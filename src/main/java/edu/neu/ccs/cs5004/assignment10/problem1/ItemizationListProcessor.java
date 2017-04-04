package edu.neu.ccs.cs5004.assignment10.problem1;

import java.util.NavigableMap;

/**
 * Created by Jeremy on 4/2/17.
 */
class ItemizationListProcessor extends AbstractListProcessor {
    @Override
    public Text processLine(Text line, MarkdownProcessor markdownProcessor) {
        String newLine = line.getContent().replaceFirst("[*\\-+]", "*");
        NavigableMap map = markdownProcessor.getListLevels();
        int currLevel = currentNestingLevel(line);
        map.put(currLevel, -1);    // need to record only the presence of itemization list
        return new Text(newLine);  // at this level, numbering does not matter
    }
}
