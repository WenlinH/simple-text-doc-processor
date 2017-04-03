package edu.neu.ccs.cs5004.assignment10.problem1;

/**
 * Created by Jeremy on 4/2/17.
 */
abstract class File<T> {
    protected String fileName;
    protected T content;

    public File(String fileName) {
        this.fileName = fileName;
    }

    protected String getFileName() {
        return fileName;
    }

    protected T getContent() {
        return content;
    }

    protected abstract T readContent(String fileName);

    protected abstract void writeContent();
}
