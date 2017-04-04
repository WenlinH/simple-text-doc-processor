package edu.neu.ccs.cs5004.assignment10.problem1;

/**
 * Created by Jeremy on 4/2/17.
 */
class ParagraphProcessor extends AbstractLineProcessor {
  @Override
  public Text processLine(Text line, MarkdownProcessor markdownProcessor) {
    if (!markdownProcessor.getListLevels().isEmpty() && line.getContent().trim().equals("")) {
      markdownProcessor.resetListLevel();
    }
    return line;
  }
}
