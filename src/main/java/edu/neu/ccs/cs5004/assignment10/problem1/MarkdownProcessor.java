package edu.neu.ccs.cs5004.assignment10.problem1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.SortedMap;
import java.util.TreeMap;


/**
 * Created by Jeremy on 4/2/17.
 */
class MarkdownProcessor implements FileProcessor {
  private SortedMap<Integer, Integer> headerLevels;
  private SortedMap<Integer, Integer> listLevels;
  private StringBuilder processedText;

  /**
   * Creates a markdown processor with all its fields initialized.
   */
  public MarkdownProcessor() {
    headerLevels = new TreeMap();
    listLevels = new TreeMap();
    processedText = new StringBuilder();
  }

  @Override
  public File process(File inputFile) throws FileNotFoundException {
    AbstractTextFile textFile = new MarkdownFile(inputFile.getFilePath());
    Text fileContent = textFile.getContent();

    try (BufferedReader bufferedReader = new BufferedReader(new StringReader(fileContent
            .getText()))) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        String type = AbstractLineProcessor.getLineTextType(line);
        LineProcessor lineProcessor = getLineProcessor(type);
        Text result = lineProcessor.processLine(new Text(line), this);
        processedText.append(result.getText()).append("\n");
      }
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
    }

    String outFileName = inputFile.getFilePath() + ".out";
    return new MarkdownFile(outFileName, new Text(this.processedText.toString()));
  }

  /**
   * Given the type of a line, returns the corresponding line processor.
   *
   * @param type the type of a line
   * @return the corresponding line processor
   */
  private LineProcessor getLineProcessor(String type) {
    LineProcessor lineProcessor;
    switch (type) {
      case AbstractLineProcessor.HEADER:
        lineProcessor = new HeaderProcessor();
        break;
      case AbstractLineProcessor.ENUMERATION:
        lineProcessor = new EnumerationListsProcessor();
        break;
      case AbstractLineProcessor.ITEMIZATION:
        lineProcessor = new ItemizationListProcessor();
        break;
      default:
        lineProcessor = new ParagraphProcessor();
    }
    return lineProcessor;
  }

  /**
   * Getter for property 'headerLevels'.
   *
   * @return Value for property 'headerLevels'
   */
  protected SortedMap<Integer, Integer> getHeaderLevels() {
    return headerLevels;
  }

  /**
   * Getter for property 'listLevels'.
   *
   * @return Value for property 'listLevels'
   */
  protected SortedMap<Integer, Integer> getListLevels() {
    return listLevels;
  }

  /**
   * Resets the listLevel field to its initial state.
   */
  protected void resetListLevels() {
    this.listLevels = new TreeMap<>();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    MarkdownProcessor that = (MarkdownProcessor) obj;

    return getHeaderLevels().equals(that.getHeaderLevels())
            && getListLevels().equals(that.getListLevels())
            && processedText.toString().equals(that.processedText.toString());
  }

  @Override
  public int hashCode() {
    int result = getHeaderLevels().hashCode();
    result = 31 * result + getListLevels().hashCode();
    result = 31 * result + processedText.toString().hashCode();
    return result;
  }
}
