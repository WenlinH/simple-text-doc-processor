package edu.neu.ccs.cs5004.assignment10.problem1;

import edu.neu.ccs.cs5004.assignment10.problem1.testutils.TestUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jeremy on 4/4/17.
 */
public class MarkdownProcessorTest extends TestUtils {
    private static final String IO_DIR = System.getProperty("user.dir") +
            "/src/test/java/edu/neu/ccs/cs5004/assignment10/problem1/io/";
    File<Text> textFile1;
    File<Text> textFile2;

    FileProcessor mdp_dup1;
    FileProcessor mdp_dup2;
    FileProcessor mdp_dup3;
    FileProcessor mdp_diff;

    @Before
    public void setUp() throws Exception {
        textFile1 = new MarkdownFile(IO_DIR + "test_valid_1.md");
        textFile2 = new MarkdownFile(IO_DIR + "test_valid_2.md");
        mdp_dup1 = new MarkdownProcessor();
        mdp_dup2 = new MarkdownProcessor();
        mdp_dup3 = new MarkdownProcessor();
        mdp_diff = new MarkdownProcessor();
        mdp_dup1.process(textFile1);
        mdp_dup2.process(textFile1);
        mdp_dup3.process(textFile1);
        mdp_diff.process(textFile2);
    }

    @Test
    public void testEquals() throws Exception {
        Assert.assertTrue(isEqualsContractValid(mdp_dup1, mdp_dup2, mdp_dup3, mdp_diff));
        Assert.assertEquals(mdp_dup1, mdp_dup2);
        Assert.assertFalse(mdp_dup1.equals(mdp_diff));
        Assert.assertFalse(mdp_dup1.equals(null));
    }

    @Test
    public void testHashCode() throws Exception {
        Assert.assertEquals(mdp_dup1.hashCode(), mdp_dup2.hashCode());
        Assert.assertFalse(mdp_dup1.hashCode() == mdp_diff.hashCode());
    }

    @Test(expected = IllegalMarkdownFormatException.class)
    public void testProcess_InvalidIndentation() throws Exception {
        new MarkdownProcessor()
                .process(new MarkdownFile(IO_DIR + "test_invalid_indentations.md"));
    }

    @Test(expected = IllegalMarkdownFormatException.class)
    public void testProcess_InvalidSkipNestingLevel() throws Exception {
        new MarkdownProcessor()
                .process(new MarkdownFile(IO_DIR + "test_invalid_skipping_nesting_level.md"));
    }

    @Test(expected = IllegalMarkdownFormatException.class)
    public void testProcess_InvalidSameNestingLevel() throws Exception {
        new MarkdownProcessor()
                .process(new MarkdownFile(IO_DIR + "test_invalid_item_enum_same_nesting_level.md"));
    }
}
