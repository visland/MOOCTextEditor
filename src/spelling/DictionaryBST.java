package spelling;

import java.util.TreeSet;

/**
 * @author UC San Diego Intermediate MOOC team
 *
 */
public class DictionaryBST implements Dictionary {
  private TreeSet<String> dict;
  // private TreeNode<String> root;
  private int size;

  // You'll need a constructor here
  public DictionaryBST() {
    dict = new TreeSet<String>();
    size = 0;
  }

  // private class TreeNode<String> {
  // private String value;
  // private TreeNode<String> left;
  // private TreeNode<String> right;
  //
  // private TreeNode(String val) {
  // value = val;
  // left = null;
  // right = null;
  // }
  // }

  /**
   * Add this word to the dictionary. Convert it to lowercase first for the
   * assignment requirements.
   * 
   * @param word
   *          The word to add
   * @return true if the word was added to the dictionary (it wasn't already
   *         there).
   */
  public boolean addWord(String word) {
    word = word.toLowerCase();
    if (dict.contains(word)) {
      return false;
    } else {
      dict.add(word);
      size++;
      return true;
    }
  }

  /** Return the number of words in the dictionary */
  public int size() {
    return size;
  }

  /** Is this a word according to this dictionary? */
  public boolean isWord(String s) {
    s = s.toLowerCase();
    if (dict.contains(s)) {
      return true;
    } else {
      return false;
    }
  }
}
