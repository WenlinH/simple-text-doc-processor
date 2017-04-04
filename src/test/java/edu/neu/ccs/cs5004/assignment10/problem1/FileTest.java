package edu.neu.ccs.cs5004.assignment10.problem1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by Jeremy on 4/4/17.
 */
public class FileTest extends edu.neu.ccs.cs5004.assignment10.problem1.testutils.TestUtils {
    private static final String IO_DIR = System.getProperty("user.dir") +
            "/src/test/java/edu/neu/ccs/cs5004/assignment10/problem1/io/";

    private File<Text> file_dup1;
    private File<Text> file_dup2;
    private File<Text> file_dup3;
    private File<Text> file_diff;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        file_dup1 = new MarkdownFile(IO_DIR + "test_valid_1.md");
        file_dup2 = new MarkdownFile(IO_DIR + "test_valid_1.md");
        file_dup3 = new MarkdownFile(IO_DIR + "test_valid_1.md");
        file_diff = new MarkdownFile(IO_DIR + "test_invalid_indentations.md");
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void testEquals() throws Exception {
        Assert.assertTrue(isEqualsContractValid(file_dup1, file_dup2, file_dup3, file_diff));
        Assert.assertEquals(file_dup1, file_dup2);
        Assert.assertFalse(file_dup1.equals(file_diff));
        Assert.assertFalse(file_dup1.equals(null));
    }

    @Test
    public void testHashCode() throws Exception {
        Assert.assertEquals(file_dup1.hashCode(), file_dup2.hashCode());
        Assert.assertFalse(file_dup1.hashCode() == file_diff.hashCode());
    }

    @Test
    public void testLoadingANonExistentFile() throws Exception {
        new MarkdownFile("/dummy/directory/name/" + "file_that_does_not_exist.md");
        Assert.assertEquals(
                "*** OUPS! A file was not found : /dummy/directory/name/file_that_does_not_exist.md "
              + "(No such file or directory)\n", outContent.toString());
    }
}
