package edu.neu.ccs.cs5004.assignment10.problem1;

import java.io.FileNotFoundException;

/**
 * Created by Jeremy on 4/2/17.
 */
class Main {
  /**
   * Given the input file name as the first argument in the command line,
   * processes the file and write the output file to the filesystem.
   *
   * @param args input file name passed as the first argument in the command line.
   *             Only 1 argument is allowed to be passed in the command line.
   *
   * @throws FileNotFoundException the exception that gets thrown when a file
   */
  public static void main(String[] args) throws FileNotFoundException {
    if (args.length != 1) {
      throw new IllegalArgumentException("Must have ONE command line argument");
    }
    String fileName = args[0];
    File inputTextFile = new MarkdownFile(fileName);
    FileProcessor mdProcessor = new MarkdownProcessor();
    File outputFile = mdProcessor.process(inputTextFile);
    outputFile.writeContent();
  }
}
