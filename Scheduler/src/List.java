
/**
 * Lab 2 Doubly Linked Lists   
 * @author ameyadighe
 * @author abdulwasayrida - Rida Abdulwasay
 */

import java.util.NoSuchElementException;

public class List<T> { // extend Comparable<T>>
	private class Node {
		private T data;
		private Node next;
		private Node prev;

		public Node(T data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	private int length;
	private Node first;
	private Node last;
	private Node iterator;

	/**** CONSTRUCTOR ****/

	/**
	 * Instantiates a new List with default values
	 * 
	 * @postcondition a new list is created
	 */
	public List() {
		first = null;
		last = null;
		length = 0;
		iterator = null; 
	}

	/**
	 * COPY Constructor Makes a copy of a list object
	 * 
	 * @param A list of generic type T that is copied
	 * @postcondition private members instantiated with default values when a new
	 *                list object is created.
	 */

	/**
	 * Instantiates a new List by copying another List
	 * 
	 * @param original the List to make a copy of
	 * @postcondition a new List object, which is an identical but separate copy of
	 *                the List original
	 */
	public List(List<T> original) {
		if (original == null) {
			return;
		}
		if (original.length == 0) {
			length = 0;
			first = null;
			last = null;
			iterator = null;
		} else {
			Node temp = original.first;
			while (temp != null) {
				addLast(temp.data);
				temp = temp.next;
			}
			iterator = null;
		}
	}

	/**** ACCESSORS ****/

	/**
	 * Returns the value stored in the first node
	 * 
	 * @precondition length != 0
	 * @return the integer value stored at node first
	 * @throws NoSuchElementException when precondition is violated
	 */
	public T getFirst() throws NoSuchElementException {
		if (length == 0) {
			throw new NoSuchElementException("getFirst(): List is Empty. " + "No Data to access!");
		}
		return first.data;
	}

	/**
	 * Returns the value stored in the last node
	 * 
	 * @precondition length != 0
	 * @return the value stored in the node last
	 * @throws NoSuchElementException when precondition is violated
	 */
	public T getLast() throws NoSuchElementException {
		if (length == 0) {
			throw new NoSuchElementException("getLast(): List is Empty. No Data to access!");
		}
		return last.data;
	}

	/**
	 * Returns whether the list is currently empty
	 * 
	 * @return whether the list is empty
	 */
	public boolean isEmpty() {
		return length == 0;
	}

	/**
	 * Returns the current length of the list
	 * 
	 * @return the length of the list from 0 to n
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Returns the element currently pointed at by the iterator
	 * 
	 * @precondition the iterator cannot be null
	 * @return the value pointed at by the iterator
	 * @throws NullPointerException when the precondition is violated
	 */
	public T getIterator() throws NullPointerException { // accessor
		if (iterator == null) {
			throw new NullPointerException("getIterator(): " + "iterator is off the end of the list");
		}
		return iterator.data;
	}

	/**
	 * Returns whether or not the iterator is off the end of the list (i.e. null)
	 * 
	 * @return whether the iterator is null
	 */
	public boolean offEnd() {
		return iterator == null;
	}

	/**
	 * overrides the equals method for object to compares this list to another list
	 * to see if they contain the same data in the same order. Returns whether or
	 * 
	 * @param An object
	 * @return whether the two lists are equal
	 */

	@Override
	public boolean equals(Object x) {
		if (x == this) {
			return true;
		} else if (!(x instanceof List)) {
			return false;
		} else {
			List<T> L = (List<T>) x;
			if (this.length != L.length) {
				return false;
			} else {
				Node temp1 = this.first;
				Node temp2 = L.first;
				while (temp1 != null) {
					if (!(temp1.data.equals(temp2.data))) {
						return false;
					}
					temp1 = temp1.next;
					temp2 = temp2.next;
				}
				return true;
			}
		}
	}

	/**** MUTATORS ****/

	/**
	 * removes the element at the front of the list
	 * 
	 * @precondition !isEmpty()
	 * @postcondition
	 * @throws NoSuchElementException when precondition is violated
	 */
	
	public void removeFirst() throws NoSuchElementException {
		if (this.isEmpty() == true) {
			throw new NoSuchElementException("removeFirst(): Cannot remove from an empty List!");
		} else if (length == 1) {
			first = last = null;
		} else {
			first = first.next;
			first.prev = null;
		}
		length--;
	}

	/**
	 * removes the element at the end of the list
	 * 
	 * @precondition !isEmpty()
	 * @postcondition
	 * @throws NoSuchElementException when precondition is violated
	 */
	public void removeLast() throws NoSuchElementException {
		if (this.isEmpty() == true) {
			throw new NoSuchElementException("removeLast(): Cannot remove from an empty List!");
		} else if (length == 1) {
			first = last = null;
		} else {
			last = last.prev;
			last.next = null;
		}
		length--;
	}

	/**
	 * Creates a new first element
	 * 
	 * @param data the data to insert at the front of the list
	 * @postcondition A node containing data is added to the start of the list
	 */
	public void addFirst(T data) { // UPDATED :D
		if (first == null) {
			first = last = new Node(data);
		} else {
			Node n = new Node(data);
			n.next = first;
			first.prev = n;
			first = n;
		}
		length++;
	}

	/**
	 * Creates a new last element
	 * 
	 * @param data the data to insert at the end of the list
	 * @postcondition a node containing data is added to the end of the list
	 */
	public void addLast(T data) {
		if (last == null) {
			first = last = new Node(data);
		} else {
			Node n = new Node(data);
			last.next = n;
			n.prev = last;
			last = n;
		}
		length++;

	}

	/**
	 * Moves the iterator to the start of the list
	 * 
	 * @precondition
	 * @postcondition Iterator will be at the start of the list
	 */
	public void placeIterator() {
		iterator = first;
	}

	/**
	 * Removes the element currently pointed to by the iterator
	 * 
	 * @precondition iterator != null
	 * @postcondition Iterator then points to NULL.
	 * @throw NullPointerException when the precondition is violated
	 */
	public void removeIterator() throws NullPointerException {
		if (iterator == null) {
			throw new NullPointerException("removeIterator(): " + "iterator is off end. Cannot remove.");
		} else if (iterator == first) { // Edge case
			removeFirst();

		} else if (iterator == last) { // Edge Case
			removeLast();

		} else { // General Case
			iterator.next.prev = iterator.prev;
			iterator.prev.next = iterator.next;
		}
		iterator = null;
	}

	/**
	 * inserts an element after the node currently pointed to by the iterator
	 * 
	 * @param data the new data to insert
	 * @precondition !offEnd()
	 * @throw NullPointerException when the precondition is violated
	 */
	public void addIterator(T data) throws NullPointerException {
		if (offEnd()) { // Precondition
			throw new NullPointerException("addIterator(): " + "iterator is off end. Cannot add.");
		} else if (iterator == last) { // edge case
			addLast(data);
		} else { // general case
			Node n = new Node(data);
			n.next = iterator.next;

			n.prev = iterator;
			iterator.next.prev = n;

			iterator.next = n;
			length++;
		}
	}

	/**
	 * Advances the iterator by one node in the list
	 * 
	 * @precondition !offEnd()
	 * @throw NullPointerException when the precondition is violated
	 */
	public void advanceIterator() throws NullPointerException {
		if (iterator == null) {
			throw new NullPointerException("advanceIterator(): " + "iterator is null and cannot advance");
		}
		iterator = iterator.next;
	}

	/**
	 * 
	 * Moves the iterator down by one node
	 * 
	 * @precondition !offEnd()
	 * @postcondition
	 * @throw NullPointerException when the precondition is violated
	 */

	public void reverseIterator() {
		if (iterator == null) {
			throw new NullPointerException("reverseIterator(): " + "iterator is null and cannot be moved down");
		} else {
			iterator = iterator.prev;
		}
	}

	/**** ADDITIONAL OPERATIONS ****/

	/**
	 * DONE overrides the toString method for object to print the contents of the
	 * linked list to the screen separated by a blank space
	 * 
	 * @precondition
	 * @postcondition
	 * @return the List as a String for display
	 */
	@Override
	public String toString() {
		String result = "";
		Node temp = first;
		while (temp != null) {
			result += temp.data + " ";
			temp = temp.next;
		}
		return result + "\n";
	}

	/**
	 * DONE Prints the contents of the linked list to the screen in the format #.
	 * <element> followed by a newline
	 * 
	 * @precondition
	 * @postcondition
	 * @return the List as a String for display
	 */
	public void printNumberedList() {
		int counter = 0;
		Node temp = first;
		while (temp != null) {
			counter++;
			System.out.print(counter + ". " + temp.data + "\n");
			temp = temp.next;
		}
	}

}
