package edu.neu.ccs.cs5004.assignment10.problem1;

import java.util.Map;
import java.util.NavigableMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jeremy on 4/2/17.
 */
public class HeaderProcessor extends AbstractLineProcessor {
    @Override
    public Text processLine(Text line, MarkdownProcessor markdownProcessor) {

        NavigableMap<Integer, Integer> map = markdownProcessor.getHeaderLevel();
        StringBuilder numbering = new StringBuilder();

        int currLevel = getCurrentNumberingLevel(line);

        int lastLevel = map.size() == 0 ? 0 : map.lastKey();
        if (currLevel > lastLevel)  // fill in gaps with 1s for deeper nesting levels
            for (int i = lastLevel+1; i <= currLevel; i++)
                map.put(i, 1);
        else
            map.put(currLevel, map.get(currLevel)+1);

        if (currLevel < lastLevel)  // remove deeper nesting levels
            for (int i = currLevel+1; i <= lastLevel; i++)
                map.remove(i);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (numbering.length() != 0)   numbering.append(".");
            numbering.append(entry.getValue());
        }

        String newLine = line.getText().replaceFirst("#+", numbering.toString());

        return new Text(newLine.toString());
    }

    private int getCurrentNumberingLevel(Text line) {
        Pattern regex = Pattern.compile("^(#+) ");
        Matcher matcher = regex.matcher(line.getText());

        int currLevel = 0;

        if (matcher.find()) {
            String match = matcher.group(1);
            currLevel = match.length();
        }

        return currLevel;
    }
}
