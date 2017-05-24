package edu.neu.ccs.cs5004.assignment10.problem1;

import java.util.SortedMap;

/**
 * Created by Jeremy on 4/2/17.
 */
class ItemizationListProcessor extends AbstractListProcessor {
  @Override
  public Text processLine(Text line, MarkdownProcessor markdownProcessor) {
    String newLine = line.getText().replaceFirst("[*\\-+]", "*");
    SortedMap<Integer, Integer> map = markdownProcessor.getListLevels();
    int currLevel = currentNestingLevel(line);

    if (map.get(currLevel) != null && map.get(currLevel) != -1) {
      throw new IllegalMarkdownFormatException(
              "Mixing enum and itemization at the same nesting level is not allowed");
    }

    map.put(currLevel, -1);    // need to record only the presence of itemization list
    return new Text(newLine);  // at this level, numbering does not matter
  }
}
