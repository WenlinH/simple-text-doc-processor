package edu.neu.ccs.cs5004.assignment10.problem1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.NavigableMap;
import java.util.TreeMap;


/**
 * Created by Jeremy on 4/2/17.
 */
class MarkdownProcessor implements FileProcessor {
  private NavigableMap<Integer, Integer> headerLevel;
  private NavigableMap<Integer, Integer> listLevels;
  private StringBuilder processedText;

  /**
   * Creates a markdown processor with all its fields initialized.
   */
  public MarkdownProcessor() {
    headerLevel = new TreeMap();
    listLevels = new TreeMap();
    processedText = new StringBuilder();
  }

  @Override
  public File process(File inputFile) throws FileNotFoundException {
    AbstractTextFile textFile = new MarkdownFile(inputFile.getFileName());
    Text fileContent = textFile.getContent();

    try (BufferedReader bufferedReader = new BufferedReader(new StringReader(fileContent
            .getContent()))) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        String type = AbstractLineProcessor.getLineTextType(line);
        LineProcessor lineProcessor = getLineProcessor(type);
        Text result = lineProcessor.processLine(new Text(line), this);
        processedText.append(result.getContent()).append("\n");
      }
    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OUPS! A file was not found : " + fnfe.getMessage());
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
    }

    String outFileName = inputFile.getFileName() + ".out";
    return new MarkdownFile(outFileName, new Text(this.processedText.toString()));
  }

  /**
   * Given the type of a line, returns the corresponding line processor.
   *
   * @param type the type of a line
   *
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
   * Getter for property 'headerLevel'.
   *
   * @return Value for property 'headerLevel'
   */
  protected NavigableMap<Integer, Integer> getHeaderLevel() {
    return headerLevel;
  }

  /**
   * Getter for property 'listLevels'.
   *
   * @return Value for property 'listLevels'
   */
  protected NavigableMap<Integer, Integer> getListLevels() {
    return listLevels;
  }

  /**
   * Resets the listLevel field to its initial state.
   */
  protected void resetListLevel() {
    this.listLevels = new TreeMap<>();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    MarkdownProcessor that = (MarkdownProcessor) o;

    if (getHeaderLevel() != null ? !getHeaderLevel().equals(that.getHeaderLevel()) : that
            .getHeaderLevel() != null)
      return false;
    if (getListLevels() != null ? !getListLevels().equals(that.getListLevels()) : that
            .getListLevels() != null)
      return false;
    return processedText != null ? processedText.toString().equals(that.processedText.toString())
            : that
            .processedText == null;
  }

  @Override
  public int hashCode() {
    int result = getHeaderLevel() != null ? getHeaderLevel().hashCode() : 0;
    result = 31 * result + (getListLevels() != null ? getListLevels().hashCode() : 0);
    result = 31 * result + (processedText != null ? processedText.toString().hashCode() : 0);
    return result;
  }
}
