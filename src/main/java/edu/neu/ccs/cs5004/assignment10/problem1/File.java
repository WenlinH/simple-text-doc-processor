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
  protected String filePath;
  protected T content;

  /**
   * Creates a file given the file path.
   * The file path given must not be null.
   *
   * @param filePath the path of the file
   */
  public File(String filePath) {
    this.filePath = filePath;
  }

  /**
   * Getter for property 'filePath'.
   *
   * @return Value for property 'filePath'
   */
  protected String getFilePath() {
    return filePath;
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
   * Write the file to the disk with its file path and its content.
   */
  protected abstract void writeContent();

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    File<?> file = (File<?>) obj;

    return getFilePath().equals(file.getFilePath()) && getContent().equals(file.getContent());
  }

  @Override
  public int hashCode() {
    int result = getFilePath().hashCode();
    result = 31 * result + getContent().hashCode();
    return result;
  }
}
