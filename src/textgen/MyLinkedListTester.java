/**
 * 
 */
package textgen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

  private static final int LONG_LIST_LENGTH = 10;

  MyLinkedList<String> shortList;
  MyLinkedList<Integer> emptyList;
  MyLinkedList<Integer> longerList;
  MyLinkedList<Integer> list1;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    // Feel free to use these lists, or add your own
    shortList = new MyLinkedList<String>();
    shortList.add("A");
    shortList.add("B");
    emptyList = new MyLinkedList<Integer>();
    longerList = new MyLinkedList<Integer>();
    for (int i = 0; i < LONG_LIST_LENGTH; i++) {
      longerList.add(i);
    }
    list1 = new MyLinkedList<Integer>();
    list1.add(65);
    list1.add(21);
    list1.add(42);

  }

  /**
   * Test if the get method is working correctly.
   */
  /*
   * You should not need to add much to this method. We provide it as an example
   * of a thorough test.
   */
  @Test
  public void testGet() {
    // test empty list, get should throw an exception
    try {
      emptyList.get(0);
      fail("Check out of bounds");
    } catch (IndexOutOfBoundsException e) {

    }

    // test short list, first contents, then out of bounds
    assertEquals("Check first", "A", shortList.get(0));
    assertEquals("Check second", "B", shortList.get(1));

    try {
      shortList.get(-1);
      fail("Check out of bounds");
    } catch (IndexOutOfBoundsException e) {

    }
    try {
      shortList.get(2);
      fail("Check out of bounds");
    } catch (IndexOutOfBoundsException e) {

    }
    // test longer list contents
    for (int i = 0; i < LONG_LIST_LENGTH; i++) {
      assertEquals("Check " + i + " element", (Integer) i, longerList.get(i));
    }

    // test off the end of the longer array
    try {
      longerList.get(-1);
      fail("Check out of bounds");
    } catch (IndexOutOfBoundsException e) {

    }
    try {
      longerList.get(LONG_LIST_LENGTH);
      fail("Check out of bounds");
    } catch (IndexOutOfBoundsException e) {
    }
  }

  /**
   * Test removing an element from the list. We've included the example from the
   * concept challenge. You will want to add more tests.
   */
  @Test
  public void testRemove() {
    int a = list1.remove(0);
    assertEquals("Remove: check a is correct ", 65, a);
    assertEquals("Remove: check element 0 is correct ", (Integer) 21, list1.get(0));
    assertEquals("Remove: check size is correct ", 2, list1.size());

    // TODO: Add more tests here
    try {
      shortList.remove(-1);
      fail("Check out of bounds");
    } catch (IndexOutOfBoundsException e) {
    }

    try {
      shortList.remove(2);
      fail("Check out of bounds");
    } catch (IndexOutOfBoundsException e) {
    }

  }

  /**
   * Test adding an element into the end of the list, specifically public boolean
   * add(E element)
   */
  @Test
  public void testAddEnd() {
    // TODO: implement this test
    try {
      emptyList.add(null);
      fail("Null add input");
    } catch (NullPointerException e) {
    }

    emptyList.add(1);
    assertEquals("Check end empty", (Integer) 1, emptyList.tail.prev.data);

    assertEquals("Check end Integer", (Integer) 42, list1.tail.prev.data);

    assertEquals("Check end String", (String) "B", shortList.tail.prev.data);
  }

  /** Test the size of the list */
  @Test
  public void testSize() {
    // TODO: implement this test
    assertEquals("Check size empty", 0, emptyList.size());
    assertEquals("Check size longerList", LONG_LIST_LENGTH, longerList.size());
  }

  /**
   * Test adding an element into the list at a specified index, specifically:
   * public void add(int index, E element)
   */
  @Test
  public void testAddAtIndex() {
    // TODO: implement this test
    try {
      emptyList.add(0, null);
      fail("Null add input");
    } catch (NullPointerException e) {
    }

    try {
      shortList.add(-1, "A");
      fail("Check out of bounds");
    } catch (IndexOutOfBoundsException e) {
    }

    try {
      shortList.add(3, "A");
      fail("Check out of bounds");
    } catch (IndexOutOfBoundsException e) {
    }

    emptyList.add(0, 1);
    assertEquals("Check add in the beginning", (Integer) 1, emptyList.tail.prev.data);

    shortList.add(2, "1");
    assertEquals("Check add in the end", (String) "1", shortList.tail.prev.data);

    list1.add(2, 50);
    assertEquals("Check add in the middle", (Integer) 50, list1.tail.prev.prev.data);

  }

  /** Test setting an element in the list */
  @Test
  public void testSet() {
    // TODO: implement this test
    int set = list1.set(1, 0);
    assertEquals("Set: check changed is correct ", 21, set);
    assertEquals("Set: check set is correct ", (Integer) 0, list1.get(1));
    assertEquals("Set: check element 1 is correct ", (Integer) 0, list1.get(1));

    try {
      shortList.set(-1, "0");
      fail("Check out of bounds");
    } catch (IndexOutOfBoundsException e) {
    }

    try {
      shortList.set(3, "0");
      fail("Check out of bounds");
    } catch (IndexOutOfBoundsException e) {
    }
    
    try {
      shortList.set(1, null);
      fail("Check null");
    } catch (NullPointerException e) {
    }

  }

  // TODO: Optionally add more test methods.

}
