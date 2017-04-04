package edu.neu.ccs.cs5004.assignment10.problem1;

import edu.neu.ccs.cs5004.assignment10.problem1.testutils.TestUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Jeremy on 4/4/17.
 */
public class TextTest extends TestUtils {
  private Text text_dup1;
  private Text text_dup2;
  private Text text_dup3;
  private Text text_diff;


  @Before
  public void setUp() throws Exception {
    text_dup1 = new Text("");
    text_dup2 = new Text("");
    text_dup3 = new Text("");
    text_diff = new Text("diff");
  }

  @Test
  public void testEquals() throws Exception {
    Assert.assertTrue(isEqualsContractValid(text_dup1, text_dup2, text_dup3, text_diff));
    Assert.assertEquals(text_dup1, text_dup2);
    Assert.assertFalse(text_dup1.equals(text_diff));
    Assert.assertFalse(text_dup1.equals(null));
    Assert.assertFalse(text_dup1.equals(new String("")));
  }
}
