import java.util.NoSuchElementException;

/**
 * Class to test List.java
 * @author
 */

public class ListTest {
    public static void main(String[] args) {
        List<Integer> L = new List<>();
        System.out.println("Should print nothing (an empty list): " + L);
       
        System.out.println("**Testing addFirst**");
        L.addFirst(2);
        System.out.println("Should print 2: " + L);
        L.addFirst(1);
        System.out.println("Should print 1 2: " + L);

        System.out.println("**Testing getFirst**");
        System.out.println("Should print 1: " + L.getFirst()); //testing general case
        List<String> L2 = new List<>();
        try { //testing precondition
            System.out.println("Should print error: " + L2.getFirst());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
       
        /*     
        System.out.println("**Testing addLast**");
        L.addLast(2); //Testing Edge case: length == 0
        System.out.println("Should print 2: " + L);
        L.addLast(1); //Testing General case: length >= 1
        System.out.println("Should print 2 1: " + L); 
        */
       
        System.out.println("**Testing removeFirst**");
        L.removeFirst();
        System.out.println("Should print 2: " + L);
        L.removeFirst();
        System.out.println("Should print an empty list: " + L);
        System.out.println("Should an error message for an empty List: ");
        try {
            L.removeFirst();
        } catch(NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        //Tests for removeLast go here!
       
        System.out.println("**Testing isEmpty**");
        List L3 = new List();
        System.out.println("Should print true: " + L3.isEmpty());
        L3.addFirst(1);
        System.out.println("Should print false: " + L3.isEmpty());
        
        System.out.println("**Testing getLength**");
        System.out.println("Should print 1: " + L3.getLength());
        
    }

}
      
        



