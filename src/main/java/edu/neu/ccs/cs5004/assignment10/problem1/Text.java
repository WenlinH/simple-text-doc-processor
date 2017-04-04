package edu.neu.ccs.cs5004.assignment10.problem1;

/**
 * Created by Jeremy on 4/2/17.
 */
class Text {
  private String txt;

  /**
   * Creates a text with its content.
   * The text to be passed in must not be null.
   *
   * @param text the content of the text
   */
  public Text(String text) {
    this.txt = text;
  }

  /**
   * Getter for property 'txt'.
   *
   * @return Value for property 'txt'
   */
  public String getText() {
    return txt;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    Text text = (Text) obj;

    return getText().equals(text.getText());
  }

  @Override
  public int hashCode() {
    return getText().hashCode();
  }
}
