package spelling;

public class BinaryTree<E extends Comparable<? super E>> {
  TreeNode<E> root;

  public class TreeNode<E> {
    private E value;
    private TreeNode<E> parent;
    private TreeNode<E> left;
    private TreeNode<E> right;

    public TreeNode(E val, TreeNode<E> par) {
      value = val;
      parent = par;
    }

    public TreeNode<E> addLeftChild(E val) {
      return left = new TreeNode<E>(val, this);
    }

    public TreeNode<E> addRightChild(E val) {
      return right = new TreeNode<E>(val, this);
    }

    public TreeNode<E> getLeftChild() {
      return left;
    }

    public TreeNode<E> getRightChild() {
      return right;
    }

    public E getValue() {
      return value;
    }
  }

  public boolean contains(E toFind) {
    TreeNode<E> curr = root;
    while (curr != null) {
      int compare = toFind.compareTo(curr.getValue());
      if (compare < 0) {
        curr.getLeftChild();
      } else if (compare > 0) {
        curr.getRightChild();
      } else {
        return true;
      }
    }
    return false;
  }

  public boolean insert(E toInsert) {
    if (contains(toInsert) || toInsert == null) {
      return false;
    } else {
      TreeNode<E> curr = root;
      int compare = toInsert.compareTo(curr.getValue());
      while (compare < 0 && curr.getLeftChild() != null || compare > 0 && curr.getRightChild() != null) {
        if (compare < 0) {
          curr.getLeftChild();
        } else {
          curr.getRightChild();
        }
        compare = toInsert.compareTo(curr.getValue());
      }
      if (compare < 0) {
        curr.addLeftChild(toInsert);
        return true;
      } else if (compare > 0) {
        curr.addRightChild(toInsert);
        return true;
      }
    }
    return false;
  }
}
