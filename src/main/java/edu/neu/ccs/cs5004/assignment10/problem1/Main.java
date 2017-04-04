package edu.neu.ccs.cs5004.assignment10.problem1;

/**
 * Created by Jeremy on 4/2/17.
 */
class Main {
    public static void main(String[] args) {
        if (args.length != 1)
            throw new IllegalArgumentException("Must have ONE command line argument");
        String fileName = args[0];
        File inputTextFile = new MarkdownFile(fileName);
        FileProcessor mdProcessor = new MarkdownProcessor();
        File outputFile = mdProcessor.process(inputTextFile);
        outputFile.writeContent();
    }
}
