package edu.neu.ccs.cs5004.assignment10.problem1;

import java.io.FileNotFoundException;

/**
 * Created by Jeremy on 4/3/17.
 */
class MarkdownFile extends AbstractTextFile {
    public MarkdownFile(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public MarkdownFile(String fileName, Text content) {
        super(fileName, content);
    }
}
