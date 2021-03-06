package edu.neu.ccs.cs5004.assignment10.problem1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jeremy on 4/2/17.
 */
abstract class AbstractLineProcessor implements LineProcessor {

  public static final String HEADER = "header";
  public static final String ITEMIZATION = "itemization";
  public static final String ENUMERATION = "enumeration";
  public static final String PARAGRAPH = "paragraph";

  /**
   * Given a line, returns a string representing the type of the current line,
   * which can only be one of
   * - header
   * - itemization
   * - enumeration
   * - paragraph.
   *
   * @param line a line to be processed by the line processor
   *
   * @return the type of the current line
   */
  protected static String getLineTextType(String line) {
    Pattern regexHeader = Pattern.compile("^[#]+ .*");
    Pattern regexItemization = Pattern.compile("^[ ]*[*\\-+] .*");
    Pattern regexEnumeration = Pattern.compile("^[ ]*[1]?\\..*");  // optional 1 + .
    Matcher matcherHead = regexHeader.matcher(line);
    Matcher matcherItem = regexItemization.matcher(line);
    Matcher matcherEnum = regexEnumeration.matcher(line);

    if (matcherHead.matches()) {
      return HEADER;
    } else if (matcherItem.matches()) {
      return ITEMIZATION;
    } else if (matcherEnum.matches()) {
      return ENUMERATION;
    } else {
      return PARAGRAPH;
    }
  }
}
