package edu.neu.ccs.cs5004.assignment10.problem1;

import java.io.FileNotFoundException;

/**
 * Created by Jeremy on 4/3/17.
 */
class MarkdownFile extends AbstractTextFile {
    /**
     * Creates a markdown file given the file name.
     * The file name given must be valid in the filesystem and not null.
     *
     * @param fileName the name of the file
     */
    public MarkdownFile(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    /**
     * Creates a markdown file given the file name.
     * The file name given must be valid in the filesystem and not null.
     * The content also should not be null.
     *
     * @param fileName the name of the file
     * @param content the content of the file
     */
    public MarkdownFile(String fileName, Text content) throws FileNotFoundException {
        super(fileName, content);
    }
}
