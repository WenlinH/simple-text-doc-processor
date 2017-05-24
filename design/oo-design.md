# LineProcessor

For each line in the input file, we need to detect what type the current line is, delegate it to the corresponding line processor to process and get output from it.

# MarkdownProcessor

During the processing of the whole document, we need to store information below
- headerLevels  : keeps track of the numbering in each level
- listLevels    : keeps track of the list numbering in each level, needs to be reset when it encounters a paragraph line
- processedText : keeps track of all processed text so far

For different type of line processors, they also take an instance of the MarkdownProcessor to get the status of level information from previous processing.
