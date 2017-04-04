package edu.neu.ccs.cs5004.assignment10.problem1;

import java.io.FileNotFoundException;

/**
 * Created by Jeremy on 4/2/17.
 */
public interface FileProcessor {
  /**
   * Given a file, returns the processed file.
   *
   * @param input the input file
   *
   * @return the output file
   * @throws FileNotFoundException the exception that gets thrown when a file
   *                               with the specified pathname does not exist
   */
  File process(File input) throws FileNotFoundException;
}
