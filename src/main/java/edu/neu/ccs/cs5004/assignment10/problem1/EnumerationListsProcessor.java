package edu.neu.ccs.cs5004.assignment10.problem1;

import java.util.SortedMap;

/**
 * Created by Jeremy on 4/2/17.
 */
class EnumerationListsProcessor extends AbstractListProcessor {
  @Override
  public Text processLine(Text line, MarkdownProcessor markdownProcessor) {
    SortedMap<Integer, Integer> map = markdownProcessor.getListLevels();
    int currLevel = currentNestingLevel(line);
    int lastLevel = map.size() == 0 ? 0 : map.lastKey();

    if (currLevel > lastLevel + 1) {
      throw new IllegalMarkdownFormatException("Cannot skip nesting level.");
    }
    if (currLevel == lastLevel + 1) {
      map.put(currLevel, 1);
    } else {
      int levelValue = map.get(currLevel);
      if (levelValue == -1) {
        throw new IllegalMarkdownFormatException(
                "Mixing enum and itemization at the same nesting level is not allowed");
      }
      map.put(currLevel, levelValue + 1);
      for (int i = currLevel + 1; i <= lastLevel; i++) {
        map.remove(i);  // remove deeper nesting levels
      }
    }
    String processedLine;
    if (currLevel % 2 == 0) {
      String letter = numToLetters(map.get(currLevel));
      processedLine = line.getText().replaceFirst("[1]?\\.", letter);
    } else {
      processedLine = line.getText().replaceFirst("[1]?\\.",
                                                      map.get(currLevel).toString() + "" + ".");
    }

    return new Text(processedLine);
  }

  /**
   * Converts a number to its corresponding letters similar to the cell titles in excel.
   * For example:
   *
   * <p>1  => "a"
   *    26 => "z"
   *    27 => "aa"
   *    28 => "ab"
   *
   * @param num the number to be converted
   *
   * @return its corresponding letters
   */
  private String numToLetters(int num) {
    StringBuilder res = new StringBuilder();
    while (num-- != 0) {
      res.append(Character.toChars('a' + num % 26));
      num /= 26;
    }
    return res.reverse().append(".").toString();
  }

}
