/**
 * HashTest.java
 * @author abdulwasayrida
 * @author ameyadighe
 * CIS 22C, Lab 5
 */

//ADD MORE TESTS - 2 Method calls 
//TEST ANY EDGE CASE

public class HashTest {
    public static void main(String[] args) {
         Hash<Movie> t = new Hash<Movie>(20);
         Movie bond1 = new Movie("Dr No", "Terence Young", 1962, 59.5);
         Movie bond2 = new Movie("From Russia with Love", "Terence Young", 1963, 79.0);
         Movie bond3 = new Movie("Goldfinger", "Guy Hamilton", 1964, 125.0);
         Movie bond4 = new Movie("Thunderball", "Kevin McClory", 1965, 141.2);
         Movie bond5 = new Movie("Casino Royale", "Ken Hughes", 1967, 41.7);
         Movie bond6 = new Movie("You Only Live Twice", "Lewis Gilbert", 1967, 111.6);
         Movie bond7 = new Movie("On Her Majesty's Secret Service", "Peter R. Hunt", 1969, 82.0);
         Movie bond8 = new Movie("Diamonds are Forever", "Guy Hamilton", 1971, 116.0);
         Movie bond9 = new Movie("Live and Let Die", "Guy Hamilton", 1973, 161.8);
         Movie bond10 = new Movie("The Man with the Golden Gun", "Guy Hamilton", 1974, 97.6);
         t.insert(bond1);
         t.insert(bond2);
         t.insert(bond3);
         t.insert(bond4);
         t.insert(bond5);
         t.insert(bond6);
         t.insert(bond7);
         t.insert(bond8);
         t.insert(bond9);
         t.insert(bond10);
        
         System.out.println("***Testing Insert and toString***\n");
         System.out.print(t);
        
         System.out.println("***Testing CountBucket***\n");
         int count = t.countBucket(19);
         System.out.println("There are " + count + " movies at bucket 19\n");
         

        
         
         System.out.println("***Testing Search***\n");
         int inTable = t.search(bond9);
         if (inTable != -1) {
             System.out.println(bond9.getTitle() + " is stored in the table");
         } else {
             System.out.println(bond9.getTitle() + " is not stored in the table");
         }
         
         
         System.out.println("\n***Testing PrintBucket for Index 19***\n");
         
         t.printBucket(19);
      
         System.out.println("\n***Testing Remove***\n");
         t.remove(bond9);
         System.out.println(bond9.getTitle() + " should be removed from this index: \n");
         t.printBucket(19);
         
         inTable = t.search(bond9);
         if (inTable != -1) {
             System.out.println(bond9.getTitle() + " is stored in the table");
         } else {
             System.out.println(bond9.getTitle() + " is not stored in the table");
         }   
         
         
         System.out.println("\n\n---------------------------------------------");
         System.out.println("***Additional Method Calls***\n");
         
         /** NEW METHOD CALL*/
         System.out.println("***Testing Insert and toString***\n");
         t.remove(bond10);
         System.out.print(t.toString());
         t.remove(bond9);
         t.remove(bond8);
         System.out.print(t.toString());

         
         /** NEW METHOD CALLS*/
         System.out.println("***Testing CountBucket***\n");
         count = t.countBucket(5);
         System.out.println("There is " + count + " movie at bucket 5\n");
         try {
        	 int count2 = t.countBucket(-1);
         } catch (IndexOutOfBoundsException e) {
        	 System.out.println("Should print error message: " + e);
         }
         
         try {
        	 int count2 = t.countBucket(20);
         } catch (IndexOutOfBoundsException e) {
        	 System.out.println("Should print error message: " + e);
         }
         
         
         /** NEW METHOD CALLS*/
         System.out.println("\n***Testing Search***\n");
         inTable = t.search(bond10);
         if (inTable != -1) {
             System.out.println(bond10.getTitle() + " is stored in the table");
         } else {
             System.out.println(bond10.getTitle() + " is not stored in the table");
         }
         
         inTable = t.search(bond1);
         if (inTable != -1) {
             System.out.println(bond1.getTitle() + " is stored in the table");
         } else {
             System.out.println(bond1.getTitle() + " is not stored in the table");
         }
         Movie marvel1 = new Movie("Avengers", "Anthony Russo", 2012, 1500);
         inTable = t.search(marvel1);
         if (inTable != -1) {
             System.out.println(marvel1.getTitle() + " is stored in the table");
         } else {
             System.out.println(marvel1.getTitle() + " is not stored in the table");
         }
         
         
         /** NEW METHOD CALLS*/
         System.out.println("\n***Testing PrintBucket for Index 11 (should be empty)***\n");
         t.printBucket(11);
         System.out.println("\n***Testing PrintBucket for Index 5***\n");
         t.printBucket(5);
         
         System.out.println("\n***Testing Remove***\n");
         t.remove(bond7);
         System.out.println(bond9.getTitle() + " should be removed from this index (should now be empty): \n");
         t.printBucket(5);
         
         /** NEW METHOD CALLS*/
         System.out.println("\n***Testing getNumElements()***\n");
         System.out.println("Number of elements: " + t.getNumElements());
         t.remove(bond3);
         System.out.println("\n" + bond3.getTitle() + " is now removed");
         System.out.println("Number of elements: " + t.getNumElements());

    }
}