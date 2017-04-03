package edu.neu.ccs.cs5004.assignment10.problem1;

/**
 * Created by Jeremy on 4/2/17.
 */
public abstract class File<T> {
    protected String fileName;
    protected T content;

    protected abstract T readContent(String fileName);

    protected abstract void writeContent();

    public File(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public T getContent() {
        return content;
    }
}
