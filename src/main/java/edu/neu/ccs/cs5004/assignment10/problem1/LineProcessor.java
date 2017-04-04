package edu.neu.ccs.cs5004.assignment10.problem1;

/**
 * Created by Jeremy on 4/2/17.
 */
public interface LineProcessor {
  /**
   * Processes a line in a markdown file.
   * The markdown rule here is a bit different than the common one,
   * see the assignment page for details.
   *
   * @param line              a line of text to be processed in the markdown file
   * @param markdownProcessor the current markdown processor that is using
   *                          the line processors.
   *
   * @return a processed line of text
   */
  Text processLine(Text line, MarkdownProcessor markdownProcessor);
}
