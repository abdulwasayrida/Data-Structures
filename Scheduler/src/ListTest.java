
/**
 * Class to test List.java   
 * @author abdulwasayrida - Rida Abdulwasay
 * @author ameyadighe
 */

import java.util.NoSuchElementException;

public class ListTest {

	public static void main(String[] args) {

		/** Test for Constructor **/
		System.out.println("**Testing Constructors**");
		List<Integer> L = new List<>();
		System.out.printf("Should print an empty list (list L): " + L);
		List<String> l1 = new List<>();
		System.out.printf("Should print an empty list (list l1): " + l1);

		/** Test for Copy Constructor **/
		System.out.println("\n**Testing Copy Constructor**");
		l1.addFirst("Cheese");
		l1.addLast("Milk");
		l1.addLast("IceCream");
		List<String> l10 = new List<>(l1);
		System.out.printf("Copied List l10 (Cheese Milk IceCream): " + l10);
		List<String> l11 = new List<>(l10);
		System.out.printf("Copied List l11 (Cheese Milk IceCream): " + l11);

		System.out.println("\nTesting Mutators...");
		/** Test for removeFirst **/
		System.out.println("**Testing removeFirst()**");
		l1.removeFirst();
		System.out.printf("Should print Milk IceCream: " + l1);
		l1.removeFirst();
		System.out.printf("Should print IceCream: " + l1);

		/** Test for removeLast **/
		System.out.println("\n**Testing removeLast()**");
		l1.removeLast();
		System.out.printf("Should print empty list: " + l1);

		try {
			l1.removeLast();
			System.out.printf("Should give error message: " + l1);
		} catch (NoSuchElementException e) {
			System.out.println("Should print error message: " + e);
		}

		List<Integer> l2 = new List<>();
		/** Test for addFirst **/
		System.out.println("\n**Testing addFirst()**");
		l2.addFirst(3);
		System.out.print("Should print (3): " + l2);
		l2.addFirst(2);
		l2.addFirst(1);
		System.out.print("Should print (1 2 3): " + l2);

		/** Test for addLast **/
		System.out.println("\n**Testing addLast()**");
		l2.addLast(3);
		System.out.printf("Should print (1 2 3 3): " + l2);
		l2.addLast(10);
		System.out.printf("Should print (1 2 3 3 10): " + l2);

		/** Test for placeIterator **/
		System.out.println("\n**Testing placeIterator()**");
		l2.placeIterator();
		l2.advanceIterator();
		System.out.println("Iterator is currently: " + l2.getIterator());
		l2.placeIterator();
		System.out.println("Iterator should now be (1): " + l2.getIterator());
		l2.advanceIterator();
		l2.advanceIterator();
		l2.advanceIterator();
		System.out.println("\nIterator is currently: " + l2.getIterator());
		l2.placeIterator();
		System.out.println("Iterator should now be (1): " + l2.getIterator());

		/** Test for removeIterator **/
		System.out.println("\n**Testing removeIterator()**");
		System.out.printf("Iterator is currently: " + l2.getIterator() + "\n");
		l2.removeIterator();
		System.out.println("List should be after removing iterator: (2 3 3 10): " + l2);

		l2.placeIterator();

		try {
			l2.removeIterator();
			l2.removeIterator();
		} catch (NullPointerException e) {
			System.out.println("Should print error message: " + e);
		}

		/** Test for addIterator **/
		System.out.println("\n**Testing addIterator()**");
		try {
			l2.addIterator(1);
		} catch (NullPointerException e) {
			System.out.println("Should print error message: " + e);
		}
		l2.addFirst(2);
		l2.placeIterator();
		l2.addIterator(10);
		l2.advanceIterator();

		// Testing Edge Case
		l2.placeIterator();
		l2.addIterator(12);
		System.out.println("Where is iterator? (2): " + l2.getIterator());
		System.out.printf("List (2 12 10 3 3 10 ): " + l2);
		// Testing General Case
		l2.addIterator(1);
		System.out.println("List (2 1 12 10 3 3 10 ): " + l2);

		/** Test for advanceIterator **/
		System.out.println("\n**Testing advanceIterator()**");
		l2.placeIterator();
		System.out.println("Where is iterator? (2): " + l2.getIterator());
		l2.advanceIterator();
		System.out.println("Iterator should be (1): " + l2.getIterator());
		l2.advanceIterator();
		l2.advanceIterator();
		System.out.println("Iterator should be (10): " + l2.getIterator());

		/*
		 * System.out.println("\n**Testing reverseIterator()**");
		 * System.out.printf("List is currently: " + l2); l2.placeIterator();
		 * l2.advanceIterator(); System.out.println("Iterator is currently (11): " +
		 * l2.getIterator());
		 * 
		 * l2.reverseIterator(); System.out.println("Iterator is now (2): " +
		 * l2.getIterator());
		 * 
		 */

		System.out.println("\nTesting Accessor...");
		/** Test for getFirst **/
		System.out.println("\n**Testing getFirst()**");
		List<Double> l3 = new List<>();
		l3.addFirst(4.0);
		l3.addFirst(3.0);
		l3.addFirst(2.0);
		l3.addFirst(1.0);
		System.out.println("List is: " + l3);
		System.out.println("Should return (1.0): " + l3.getFirst());
		l3.removeFirst();
		l3.removeFirst();
		System.out.println("Should return (3.0): " + l3.getFirst());

		/** Test for getLast **/
		System.out.println("\n**Testing getLast()**");
		l3.addLast(5.7);
		l3.addLast(2.9);
		System.out.println("List is: " + l3);
		System.out.println("Should return (2.9): " + l3.getLast());
		l3.removeLast();
		l3.removeLast();
		System.out.println("Should return (4.0): " + l3.getLast());

		/** Test for isEmpty **/
		System.out.println("\n**Testing isEmpty()**");
		List<Integer> l4 = new List<>();
		System.out.println("Should print true: " + l4.isEmpty());
		l4.addFirst(1);
		System.out.println("Should print false: " + l4.isEmpty());

		/** Test for getLength **/
		System.out.println("\n**Testing getLength()**");
		System.out.println("Should print 1: " + l4.getLength());
		l4.removeLast();
		System.out.println("Should print 0: " + l4.getLength());

		/** Test for getIterator **/
		System.out.println("\n**Testing getIterator()**");
		List<String> l5 = new List<>();
		l5.addFirst("Apple");
		l5.addLast("Ball");
		l5.addLast("Cat");
		l5.addLast("Dog");
		l5.placeIterator();
		System.out.println("Should print (Apple): " + l5.getIterator());
		l5.advanceIterator();
		l5.advanceIterator();
		System.out.println("Should print (Cat): " + l5.getIterator());

		/** Test for offEnd **/
		System.out.println("\n**Testing offEnd()**");
		System.out.println("Should print (false): " + l5.offEnd());
		l5.advanceIterator();
		System.out.println("Should print (false): " + l5.offEnd());
		l5.advanceIterator();
		System.out.println("Should print (true): " + l5.offEnd());

		/** Test for equals() **/
		/*
		 * System.out.println("\n**Testing equals()**"); List<Integer> list = new
		 * List<>(); List<Integer> list1 = new List<>(); int x = 0; list.addFirst(1);
		 * System.out.printf("First list is: " + list);
		 * System.out.printf("Second list is (empty): " + list1);
		 * System.out.println("Should print (false): " + list.equals(x) + "\n");
		 * list.addLast(2); System.out.printf("First list is: " + list);
		 * list1.addFirst(1); list1.addLast(2);
		 * System.out.printf("Second list is (empty): " + list1);
		 * System.out.println("Should print (true): " + list.equals(list1));
		 * 
		 * /** Test for toString
		 **/
		/*
		 * System.out.println("\n**Testing toString()**");
		 * System.out.printf("Should print (1 2): " + list1.toString());
		 */

		List<Double> list2 = new List<>();
		list2.addFirst(1.7596);
		list2.addLast(100.99);
		list2.addLast(2.673920);
		System.out.println("Should print (1.7596 100.99 2.673920): " + list2.toString());

		/** Test for printNumberedList **/

		System.out.println("**Testing printNumberedList()**");
		System.out.println("Output (same as previous, but instead is numbered: ");
		list2.printNumberedList();
		list2.removeFirst();
		list2.addLast(400.9);
		System.out.println("Output (same as previous, but removeFirst and addLast): ");
		list2.printNumberedList();

		System.out.println();
		System.out.println();

		
		
		
		List<Character> list = new List<>();
		list.addLast('A');
		list.addLast('B');
		list.addLast('C');
		list.addLast('D');
		list.addLast('E');
		list.addLast('F');
		list.addLast('G');
		System.out.println("The list is " + list);

		/** Now Create the Swap Routine **/

		// Get the 3rd Value
	/*	list.placeIterator();
		list.advanceIterator();
		list.advanceIterator();
		Character value3 = list.getIterator();
		list.removeIterator();

		// Get the 5th Value
		list.placeIterator();
		list.advanceIterator();
		list.advanceIterator();
		list.advanceIterator();
		Character value5 = list.getIterator();

		// Swap it with 3rd
		list.addIterator(value3);
		list.removeIterator();
		list.placeIterator();
		list.advanceIterator();

		// Swap it with 5th
		list.addIterator(value5);
		System.out.println("The swapped list is " + list); */
		
		list.placeIterator();
		for(int i = 0; i < 2; i++)
		{
			list.advanceIterator();
		}
		char a = list.getIterator();
		list.removeIterator();
			
		list.placeIterator();
		for(int i = 0; i < 3; i++)
		{
		   	list.advanceIterator();
		}
		char b = list.getIterator();
		list.removeIterator();
		    
		list.placeIterator();
		for(int i = 0; i < 1; i++)
		{
			list.advanceIterator();
	}
	list.addIterator(b);
		    
		list.placeIterator();
		for(int i = 0; i < 3; i++)
		{
		 	list.advanceIterator();
		}
		list.addIterator(a);
		
		System.out.println("The list is " + list);


	}

}
