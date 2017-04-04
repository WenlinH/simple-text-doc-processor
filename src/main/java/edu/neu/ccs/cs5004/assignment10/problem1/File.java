package edu.neu.ccs.cs5004.assignment10.problem1;

/**
 * Created by Jeremy on 4/2/17.
 */

/**
 * Represent a file.
 *
 * @param <T> the type of the file.
 */
abstract class File<T> {
  protected String fileName;
  protected T content;

  /**
   * Creates a file given the file name (whole path included).
   *
   * @param fileName the name of the file
   */
  public File(String fileName) {
    this.fileName = fileName;
  }

  /**
   * Getter for property 'fileName'.
   *
   * @return Value for property 'fileName'
   */
  protected String getFileName() {
    return fileName;
  }

  /**
   * Getter for property 'content'.
   *
   * @return Value for property 'content'
   */
  protected T getContent() {
    return content;
  }

  /**
   * Reads the content of the file.
   *
   * @return the content of the file.
   */
  protected abstract T readContent();

  /**
   * Write the file to the disk with its file name and its content.
   */
  protected abstract void writeContent();

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    File<?> file = (File<?>) obj;

    return getFileName().equals(file.getFileName()) && getContent().equals(file.getContent());
  }

  @Override
  public int hashCode() {
    int result = getFileName() != null ? getFileName().hashCode() : 0;
    result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
    return result;
  }
}
