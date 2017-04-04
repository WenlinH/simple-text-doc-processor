package edu.neu.ccs.cs5004.assignment10.problem1;

/**
 * Created by Jeremy on 4/2/17.
 */
class Text {
    private String text;

    public Text(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Text text1 = (Text) o;

        return getText() != null ? getText().equals(text1.getText()) : text1.getText() == null;
    }

    @Override
    public int hashCode() {
        return getText() != null ? getText().hashCode() : 0;
    }
}
