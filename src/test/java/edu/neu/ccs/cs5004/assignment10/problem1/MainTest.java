package edu.neu.ccs.cs5004.assignment10.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jeremy on 4/4/17.
 */
public class MainTest {
    private static final String IO_DIR = System.getProperty("user.dir") +
            "/src/test/java/edu/neu/ccs/cs5004/assignment10/problem1/io/";
    String[] args0;
    String[] args1;
    String[] args2;

    File<Text> mdFileOutput0;
    File<Text> mdFileOutput1;
    File<Text> mdFileOutput2;

    Text expectedOutput0;
    Text expectedOutput1;
    Text expectedOutput2;


    @Before
    public void setUp() throws Exception {
        args0 = new String[] {IO_DIR + "test_valid_0.md"};
        args1 = new String[] {IO_DIR + "test_valid_1.md"};
        args2 = new String[] {IO_DIR + "test_valid_2.md"};

        expectedOutput0 = new MarkdownFile(IO_DIR + "test_valid_0_expectedout.md").getContent();
        expectedOutput1 = new MarkdownFile(IO_DIR + "test_valid_1_expectedout.md").getContent();
        expectedOutput2 = new MarkdownFile(IO_DIR + "test_valid_2_expectedout.md").getContent();
    }

    @Test
    public void testMain() throws Exception {
        Main.main(args0);
        Main.main(args1);
        Main.main(args2);

        mdFileOutput0 = new MarkdownFile(IO_DIR + "test_valid_0.md.out");
        mdFileOutput1 = new MarkdownFile(IO_DIR + "test_valid_1.md.out");
        mdFileOutput2 = new MarkdownFile(IO_DIR + "test_valid_2.md.out");

        Assert.assertEquals(expectedOutput0, mdFileOutput0.getContent());
        Assert.assertEquals(expectedOutput1, mdFileOutput1.getContent());
        Assert.assertEquals(expectedOutput2, mdFileOutput2.getContent());
        Assert.assertEquals(expectedOutput2, mdFileOutput2.getContent());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMain_WrongNumberOfArguments() throws Exception {
        Main.main(new String[] {"", ""});
    }
}
