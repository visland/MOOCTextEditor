package textgen;

import java.util.AbstractList;

/**
 * A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E>
 *          The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
  LLNode<E> head;
  LLNode<E> tail;
  int size;

  /** Create a new empty LinkedList */
  public MyLinkedList() {
    // TODO: Implement this method
    head = new LLNode<E>();
    tail = new LLNode<E>();
    size = 0;
    head.next = tail;
    tail.prev = head;
  }

  /**
   * Appends an element to the end of the list
   * 
   * @param element
   *          The element to add
   */
  public boolean add(E element) {
    // TODO: Implement this method
    add(size, element);
    return true;
  }

  /**
   * Get the element at position index
   * 
   * @throws IndexOutOfBoundsException
   *           if the index is out of bounds.
   */
  public E get(int index) {
    // TODO: Implement this method.
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException("Index is out of bounds");
    } else {
      LLNode<E> result = head.next;
      for (int i = 0; i < index; i++) {
        result = result.next;
      }
      return result.data;
    }
  }

  /**
   * Add an element to the list at the specified index
   * 
   * @param The
   *          index where the element should be added
   * @param element
   *          The element to add
   */
  public void add(int index, E element) {
    // TODO: Implement this method
    if (element == null) {
      throw new NullPointerException("Null elements are not allowed in the list");
    } else {
      if (index < 0 || index > size) {
        throw new IndexOutOfBoundsException("Index is out of bounds");
      } else {
        LLNode<E> result = head.next;
        for (int i = 0; i < index; i++) {
          result = result.next;
        }
        LLNode<E> newElement = new LLNode<E>(element);
        newElement.prev = result.prev;
        result.prev.next = newElement;
        newElement.next = result;
        result.prev = newElement;
        size++;
      }
    }
  }

  /** Return the size of the list */
  public int size() {
    // TODO: Implement this method
    return size;
  }

  /**
   * Remove a node at the specified index and return its data element.
   * 
   * @param index
   *          The index of the element to remove
   * @return The data element removed
   * @throws IndexOutOfBoundsException
   *           If index is outside the bounds of the list
   * 
   */
  public E remove(int index) {
    // TODO: Implement this method
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException("Index is out of bounds");
    } else {
      E r = get(index);
      LLNode<E> removed = head.next;
      for (int i = 0; i < index; i++) {
        removed = removed.next;
      }
      removed.prev.next = removed.next;
      removed.next.prev = removed.prev;
      removed.prev = null;
      removed.next = null;
      size--;
      return r;
    }
  }

  /**
   * Set an index position in the list to a new element
   * 
   * @param index
   *          The index of the element to change
   * @param element
   *          The new element
   * @return The element that was replaced
   * @throws IndexOutOfBoundsException
   *           if the index is out of bounds.
   */
  public E set(int index, E element) {
    // TODO: Implement this method
    if (element == null) {
      throw new NullPointerException("Null elements are not allowed in the list");
    } else {
      if (index >= size || index < 0) {
        throw new IndexOutOfBoundsException("Index is out of bounds");
      } else {
        LLNode<E> changed = head.next;
        for (int i = 0; i < index; i++) {
          changed = changed.next;
        }
        E result = changed.data;
        changed.data = element;
        return result;
      }
    }
  }
}

class LLNode<E> {
  LLNode<E> prev;
  LLNode<E> next;
  E data;

  // TODO: Add any other methods you think are useful here
  // E.g. you might want to add another constructor

  public LLNode(E e) {
    this.data = e;
    this.prev = null;
    this.next = null;
  }

  public LLNode() {
    this.data = null;
    this.prev = null;
    this.next = null;
  }

}
