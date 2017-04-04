package edu.neu.ccs.cs5004.assignment10.problem1;

import java.io.FileNotFoundException;

/**
 * Created by Jeremy on 4/2/17.
 */
class Main {
  /**
   * Given the input file path as the first argument in the command line,
   * processes the file and write the output file to the filesystem.
   * The output file path will be appended by ".out".
   *
   * @param args input file path passed as the first argument in the command line.
   *             Only 1 argument is allowed to be passed in the command line.
   *
   * @throws FileNotFoundException the exception that gets thrown when a file
   *                               with the specified file path does not exist
   */
  public static void main(String[] args) throws FileNotFoundException {
    if (args.length != 1) {
      throw new IllegalArgumentException("Must have ONE command line argument");
    }
    String filePath = args[0];
    File inputTextFile = new MarkdownFile(filePath);
    FileProcessor mdProcessor = new MarkdownProcessor();
    File outputFile = mdProcessor.process(inputTextFile);
    outputFile.writeContent();
  }
}
