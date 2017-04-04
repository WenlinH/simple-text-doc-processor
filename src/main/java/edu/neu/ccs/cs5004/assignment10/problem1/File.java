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

    protected abstract T readContent();

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
