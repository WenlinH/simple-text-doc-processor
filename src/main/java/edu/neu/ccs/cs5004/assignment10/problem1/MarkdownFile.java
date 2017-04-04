package edu.neu.ccs.cs5004.assignment10.problem1;

import java.io.FileNotFoundException;

/**
 * Created by Jeremy on 4/3/17.
 */
class MarkdownFile extends AbstractTextFile {
  /**
   * Creates a markdown file given the file path.
   * The file path given must be valid in the filesystem and not null.
   *
   * @param filePath the path of the file
   * @throws FileNotFoundException the exception that gets thrown when a file
   *                               with the specified file path does not exist
   */
  public MarkdownFile(String filePath) throws FileNotFoundException {
    super(filePath);
  }

  /**
   * Creates a markdown file given the file path.
   * The file path given must be valid in the filesystem and not null.
   * The content also should not be null.
   *
   * @param fileName the path of the file
   * @param content  the content of the file
   * @throws FileNotFoundException the exception that gets thrown when a file
   *                               with the specified file path does not exist
   */
  public MarkdownFile(String fileName, Text content) throws FileNotFoundException {
    super(fileName, content);
  }
}
