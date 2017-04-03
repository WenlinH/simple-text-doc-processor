package edu.neu.ccs.cs5004.assignment10.problem1;

/**
 * Created by Jeremy on 4/2/17.
 */
public class ItemizationListProcessor extends AbstractLineProcessor {
    @Override
    public Text processLine(Text line, MarkdownProcessor markdownProcessor) {
        String newLine = line.getText().replaceFirst("[*\\-+]", "*");
        return new Text(newLine);
    }
}
