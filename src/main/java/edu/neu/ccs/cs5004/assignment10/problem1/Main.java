package edu.neu.ccs.cs5004.assignment10.problem1;

/**
 * Created by Jeremy on 4/2/17.
 */
public class Main {
    public static void main(String[] args) {
//        if (args.length != 1)
//            throw new IllegalArgumentException("Must have ONE command line argument");
        String fileName = "/Users/Jeremy/Desktop/Test/test.md";
//        String fileName = args[0];
        File inputTextFile = new TextFile(fileName);
        FileProcessor mdProcessor = new MarkdownProcessor();
        File outputFile = mdProcessor.process(inputTextFile);
        outputFile.writeContent();
    }
}
