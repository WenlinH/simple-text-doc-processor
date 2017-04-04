package edu.neu.ccs.cs5004.assignment10.problem1.testutils;

import org.junit.Assert;

/**
 * Testing utilities.
 * <p>
 * There is a better way to encapsulate these utility functions but since we have not covered some
 * of the Java language features needed for the alternative solutions, this will do for now.
 */
public abstract class TestUtils {

  /**
   * Checks the condition that must hold between equals() and hashCode.
   * <p>
   * If two objects are equal then their hashCode is equal else if two objects are not equal their
   * hashCode is not equal.
   *
   * @param obj1 first object to check
   * @param obj2 second object to check
   *
   * @return true if condition for equals and hashcode holds, false otherwise
   */
  protected Boolean doesEqualsAgreeWithHashCode(Object obj1, Object obj2) {
    if (obj1.equals(obj2)) {
      return obj1.hashCode() == obj2.hashCode();
    } else {
      return obj1.hashCode() != obj2.hashCode();
    }
  }


  /**
   * Check that equals is reflexive on provided argument.
   *
   * @param obj object to check
   *
   * @return true if equals is reflexive, false otherwise
   */
  protected Boolean isEqualsReflexive(Object obj) {
    return obj.equals(obj) && obj.equals(obj);
  }

  /**
   * Checks that equals is symmetric using the two arguments given.
   *
   * @param obj1 first object to check
   * @param obj2 second object to check
   *
   * @return true if equals is reflexive for these two arguments
   */
  protected Boolean isEqualsSymmetric(Object obj1, Object obj2) {
    return obj1.equals(obj2) && obj2.equals(obj1);
  }


  /**
   * Check for transitivity of equals using the three provided arguments.
   *
   * @param obj1 first object to check
   * @param obj2 second object to check
   * @param obj3 third object to check
   *
   * @return true if equals is transitive, false otherwise
   */
  protected Boolean isEqualsTransitive(Object obj1, Object obj2, Object obj3) {
    if (obj1.equals(obj2) && obj2.equals(obj3)) {    // not-simplified if-statement for clarity
      return obj1.equals(obj3);
    } else {
      return false;
    }
  }

  /**
   * Check if equals correctly deals with {@code null} values.
   *
   * @param obj1 non-null object used to call equals
   *
   * @return obj1.equals(null)
   */
  protected Boolean isEqualsToNull(Object obj1) {
    return obj1.equals(null);
  }

  /**
   * Checks the properties specified in Object.equals().
   *
   * <ol>
   * <li>Reflexive</li>
   * <li>Symmetric</li>
   * <li>Transitive</li>
   * <li>passing {@code null} to equals</li>
   * </ol>
   *
   * @param obj1 object for the class we are testing equals for
   * @param obj2 object for the class we are testing equals for
   * @param obj3 object for the class we are testing equals for
   * @param diff of the same class but unequal to obj1 obj2 obj3
   *
   * @return true if the properties required for equals methods in Java are met, false otherwise.
   */
  public Boolean isEqualsContractValid(Object obj1, Object obj2, Object obj3, Object diff) {
    Assert.assertTrue(isEqualsReflexive(obj1));

    Assert.assertTrue(isEqualsSymmetric(obj1, obj2));
    Assert.assertFalse(isEqualsSymmetric(obj1, diff));

    Assert.assertTrue(
            isEqualsTransitive(obj1, obj2, obj3));

    Assert.assertTrue(doesEqualsAgreeWithHashCode(obj1, diff));
    Assert.assertTrue(doesEqualsAgreeWithHashCode(obj1, obj2));

    Assert.assertFalse(isEqualsToNull(obj1));
    Assert.assertFalse(obj1.equals(diff));

    return true;
  }
}
