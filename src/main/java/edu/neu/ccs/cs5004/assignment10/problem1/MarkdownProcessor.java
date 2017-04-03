package edu.neu.ccs.cs5004.assignment10.problem1;

import java.util.Map;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.StringReader;
import java.io.IOException;


/**
 * Created by Jeremy on 4/2/17.
 */
public class MarkdownProcessor implements FileProcessor {
    private Map<Integer, Integer> headerLevel;
    private Map<Integer, Integer> enumlistLevel;
    private StringBuilder processedText;

    public MarkdownProcessor() {
        headerLevel = new TreeMap();
        enumlistLevel = new TreeMap();
        processedText = new StringBuilder();
    }

    @Override
    public File process(File inputFile) {
        TextFile textFile = new TextFile(inputFile.getFileName());
        Text fileContent = textFile.getContent();

        try (BufferedReader bufferedReader = new BufferedReader(new StringReader(fileContent.getText()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String type = AbstractLineProcessor.getLineTextType(line);
                LineProcessor lineProcessor = getLineProcessor(type);
                Text result = lineProcessor.processLine(new Text(line), this);
                processedText.append(result.getText());
            }
        } catch (IOException ioe) {
            System.out.println("Something went wrong! : " + ioe.getMessage());
            ioe.printStackTrace();
        }

        String outFileName = "out." + inputFile.getFileName();
        return new TextFile(outFileName, new Text(this.processedText.toString()));
    }

    private LineProcessor getLineProcessor(String type) {
        LineProcessor lineProcessor;
        switch (type) {
            case AbstractLineProcessor.HEADER:
                lineProcessor = new HeaderProcessor();
                break;
            case AbstractLineProcessor.ENUMERATION:
                lineProcessor = new EnumerationListsProcessor();
                break;
            case AbstractLineProcessor.ITEMIZATION:
                lineProcessor = new ItemizationListProcessor();
                break;
            default:
                lineProcessor = new ParagraphProcessor();
        }
        return lineProcessor;
    }

}
