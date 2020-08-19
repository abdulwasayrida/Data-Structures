
/**
 * QueueTest.java  
 * @author abdulwasayrida
 * @author ameyadighe
 */

import java.util.NoSuchElementException;

public class QueueTest {
	public static void main(String[] args) {

		/** Test for Constructor **/
		System.out.println("**Testing Constructors**");
		Queue<Integer> Q = new Queue<>();
		System.out.printf("Should print nothing: " + Q);
		Q.enqueue(1);
		Q.enqueue(2);
		Q.enqueue(3);
		System.out.println("Should print 1 2 3: " + Q);

		/** Test for Copy Constructor **/
		System.out.println("**Testing Copy Constructor**");
		Queue<Integer> Q1 = new Queue<>(Q);
		System.out.printf("Copied List (1 2 3): " + Q1);
		Queue<Integer> Q2 = new Queue<>(Q1);
		System.out.printf("Copied List (1 2 3): " + Q2);
 
		/**** Testing Accessors ****/

		/** Test for getFront **/
		System.out.println("\n**Testing getFront()**");
		System.out.println("Should print 1: " + Q.getFront());
		Q.dequeue();
		Q.dequeue();
		System.out.println("Should print 3: " + Q.getFront());
		Q.dequeue();
		System.out.printf("Should print error message: ");
		try {
			Q.getFront();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

		/** Test for getLength **/
		System.out.println("\n**Testing getLength()**");
		System.out.println("Should print 0: " + Q.getLength());
		Q.enqueue(1);
		System.out.println("Should print 1: " + Q.getLength());

		/** Test for isEmpty **/
		System.out.println("\n**Testing isEmpty()**");
		System.out.println("Should print false: " + Q.isEmpty());
		Q.dequeue();
		System.out.println("Should print true: " + Q.isEmpty());

		/** Test for equals **/
		System.out.println("\n**Testing equals()**");
		int x = 0;
		System.out.println("Should print (false): " + Q.equals(x));
		System.out.println("Should print (true): " + Q1.equals(Q2));

		/** Test for enqueue **/
		System.out.println("\n**Testing enqueue()**");
		Q.enqueue(5);
		System.out.printf("Should print 5: " + Q);
		Q.enqueue(1);
		System.out.println("Should print 5 1: " + Q);

		/** Test for dequeue **/
		System.out.println("\n**Testing dequeue()**");
		Q.dequeue();
		System.out.printf("Should print 1: " + Q);
		Q.dequeue();
		System.out.printf("Should print error message: ");
		try {
			Q.dequeue();
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}

		/** Test for toString **/
		System.out.println("\n**Testing toString()**");
		Q.enqueue(10);
		Q.enqueue(10);
		Q.enqueue(10);
		System.out.printf("Should print 10 10 10: " + Q.toString());
		Q.dequeue();
		Q.dequeue();
		System.out.println("Should print 10: " + Q.toString());

		System.out.println("\n**Testing printReverse()**");
		Q.enqueue(20);
		Q.enqueue(30);
		Q.enqueue(40);
		Q.enqueue(50);
		Q.enqueue(60);
		System.out.printf("Queue before reversing (10 20 30 40 50 60): " + Q);
		System.out.printf("Queue after reversing (60 50 40 30 20 10): ");
		Q.printReverse();
		System.out.println();

		Q.dequeue();
		Q.dequeue();
		Q.dequeue();
		System.out.printf("\nQueue before reversing (40 50 60): " + Q);
		System.out.printf("Queue after reversing (60 50 40): ");
		Q.printReverse();
		System.out.println();

		Q.dequeue();
		Q.dequeue();
		Q.dequeue();
		System.out.printf("\nQueue before reversing (Should be empty): " + Q);
		System.out.printf("Queue after reversing (Should be empty): \n");
		Q.printReverse();

		Q.enqueue(20);
		Q.enqueue(2);
		Q.enqueue(3);
		Q.enqueue(5);
		Q.enqueue(10);

		System.out.println("\n**Testing isSorted()**");
		System.out.println("Should print false: " + Q.isSorted());
		Q.dequeue();
		Q.enqueue(15);
		Q.enqueue(20);
		System.out.println("Should print true: " + Q.isSorted());

		System.out.println("\n**Testing linearSearch()**");
		System.out.printf("Current Queue: " + Q);
		System.out.println("Should print 3: " + Q.linearSearch(5));
		System.out.println("Should print -1: " + Q.linearSearch(500));
		
		
		System.out.println("\n**Testing binarySearch()**");
		System.out.printf("Current Queue: " + Q);
		System.out.println("Should print 3: " + Q.binarySearch(5));
		System.out.println("Should print 2: " + Q.binarySearch(3));
		System.out.println("Should print 4: " + Q.binarySearch(10));
		System.out.println("Should print 6: " + Q.binarySearch(20));
		System.out.println("Should print 1: " + Q.binarySearch(2));
		System.out.println("Should print -1: " + Q.binarySearch(1));
		Q.enqueue(1);
		System.out.printf("Should print error message: ");
		
		try {
			Q.binarySearch(1);
		} catch (IllegalStateException e) {
			System.out.println(e);
		}
		

	}

}
