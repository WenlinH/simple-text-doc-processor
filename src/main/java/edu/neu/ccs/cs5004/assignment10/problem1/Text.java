package edu.neu.ccs.cs5004.assignment10.problem1;

/**
 * Created by Jeremy on 4/2/17.
 */
class Text {
    private String content;

    /**
     * Creates a content with its content.
     * The content to be passed in must not be null.
     *
     * @param content the content of the content
     */
    public Text(String content) {
        this.content = content;
    }

    /**
     * Getter for property 'content'.
     * @return Value for property 'content'
     */
    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Text text = (Text) obj;

        return getContent().equals(text.getContent());
    }

    @Override
    public int hashCode() {
        return getContent().hashCode();
    }
}
