/**
 * StackTest.java 
 * @author abdulwasayrida
 * @author ameyadighe
 */

import java.util.NoSuchElementException;

public class StackTest { 

	public static void main(String[] args) {
		
		/** Test for Constructor **/
		System.out.println("**Testing Constructors**");
		Stack<Integer> S = new Stack<>();
		System.out.printf("Should print nothing : " + S);
		S.push(3);
		S.push(2);
		System.out.println("Should print 2 3 : " + S);

		
		/** Test for Copy Constructor **/
		System.out.println("**Testing Copy Constructor**");
		Stack<Integer> S1 = new Stack<>(S);
		System.out.printf("Copied List (2 3): " + S1);
		
		Stack<Integer> S2 = new Stack<>(S1);
		System.out.printf("Copied List (2 3): " + S2);
		
		
		/** Test for Peek **/
		System.out.println("\n**Testing peek()**");
		System.out.println("Should print 2: " + S.peek());
		S.push(1);
		System.out.println("Should print 1: " + S.peek());
		
		/** Test for getLength **/
		System.out.println("\n**Testing getLength()**");
		System.out.println("Should print 3: " + S.getLength());
		S.pop();
		S.pop();
		S.pop();
		System.out.println("Should print 0: " + S.getLength());
		
		

		/** Test for isEmpty **/
		System.out.println("\n**Testing isEmpty()**");
		System.out.println("Should print true: " + S.isEmpty());
		S.push(1);;
		System.out.println("Should print false: " + S.isEmpty());
		
		/** Test for equals **/
		System.out.println("\n**Testing equals()**"); //Need to fix equals
		int x = 0;
		

		System.out.println("Should print (false): " + S.equals(x));
		System.out.println("Should print (true): " + S1.equals(S2)); //Why is this printing false?
	
		
		/** Test for push **/
		System.out.println("\n**Testing push()**");
		S.push(11);
		System.out.printf("Should print 11 1: " + S);
		
		S.push(19);
		System.out.printf("Should print 19 11 1: " + S);
		
		/** Test for pop **/
		System.out.println("\n**Testing pop()**");
		S.pop();
		S.pop();
		System.out.printf("Should print 1: " + S);
		S.pop();
		System.out.printf("Should print empty list: " + S);
		System.out.printf("Should print error message: ");
		try {
			S.pop();
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		
		
		
		
		/** Test for toString **/
		System.out.println("\n**Testing toString()**");
		S.push(20);
		S.push(20);
		S.push(20);
		System.out.printf("Should print 20 20 20: " + S.toString());
		S.pop();
		S.pop();
		System.out.println("Should print 20: " + S.toString());
		S.pop();
		
		/** Test for printReverse **/
		S.push(3);
		S.push(2);
		System.out.println("**Testing printReverse()**");
		System.out.printf("Stack before reversing (2 3): " + S);
	 	System.out.printf("Stack after reversing (3 2): ");
		S.printReverse();
		System.out.println();
		 
		S.push(13);
		S.push(99);
		System.out.printf("\nStack before reversing (99 13 2 3): " + S);
	 	System.out.printf("Stack after reversing (3 2 13 99): ");
		S.printReverse(); 
		System.out.println();
		
		System.out.println("\n**Testing isSorted()**");
		System.out.println("Should print false: " + S.isSorted());
		Stack<Integer> Stack = new Stack<>();
		Stack.push(8);
		Stack.push(5);
		Stack.push(2);
		Stack.push(1);
		System.out.println("Should print true: " + Stack.isSorted());
		
		System.out.println("\n**Testing linearSearch()**");
		System.out.printf("Current Stack: " + S);
		System.out.println("Should print 1: " + S.linearSearch(99));
		System.out.println("Should print -1: " + S.linearSearch(500));
		
		System.out.println("\n**Testing binarySearch()**");
		System.out.printf("Current Stack: " + Stack.toString());
		System.out.println("Should print 3: " + Stack.binarySearch(5));
		System.out.println("Should print -1: " + Stack.binarySearch(3));
		System.out.println("Should print 1: " + Stack.binarySearch(1));
		
		Stack.push(1111);
		System.out.printf("Should print error message: ");
		try {
			S.binarySearch(1);
		} catch (IllegalStateException e) {
			System.out.println(e);
		}
		
	}

}
