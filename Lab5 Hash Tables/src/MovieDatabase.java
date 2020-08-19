
/**
 * MovieDatabase.java
 * @author abdulwasayrida
 * @author ameyadighe
 * CIS 22C, Lab 5
 */

import java.util.Scanner; 
import java.io.File;
import java.io.IOException;

public class MovieDatabase {
	private final int NUM_MOVIES = 26;
	Hash<Movie> ht = new Hash<>(NUM_MOVIES * 2);
	BST<Movie> bst = new BST<>();

	public static void main(String[] args) throws IOException {

		MovieDatabase m = new MovieDatabase();
		String title;
		String director;
		int year;
		double grossMillions;
		File file = new File("movies.txt");
		Scanner input = new Scanner(file);

		while (input.hasNextLine()) {
			title = input.nextLine();
			director = input.nextLine();
			year = input.nextInt();
			grossMillions = input.nextDouble();
			if (input.hasNextLine()) {
				input.nextLine();
				input.nextLine();
			}
			m.ht.insert(new Movie(title, director, year, grossMillions));
			m.bst.insert(new Movie(title, director, year, grossMillions));
		}

		input.close();

		Scanner sc = new Scanner(System.in);
		String res = "";
		int l = 1;
		System.out.println("Welcome to the Bond Movie Database!\n");
		while (l == 1) {
			System.out.println("Please select from one of the following options:\n");

			System.out.println("Select from the following options:\n" + "A: Add a Movie\n" + "D: Display all Movies\n"
					+ "R: Remove a Movie\n" + "S: Search for a Movie\n" + "X: Exit");
			System.out.println("\nEnter your choice: ");
			res = sc.nextLine();
			if (res.equalsIgnoreCase("x")) {
				l = 2;
				break;
			} else if (res.equalsIgnoreCase("a")) {
				System.out.println("\nAdding a Movie!\n");
				System.out.print("Enter the title: ");
				title = sc.nextLine();
				System.out.print("Enter the director: ");
				director = sc.nextLine();
				System.out.print("Enter the year: ");
				year = sc.nextInt();
				System.out.print("Enter the gross in millions: $");
				grossMillions = sc.nextDouble();
				m.ht.insert(new Movie(title, director, year, grossMillions));
				m.bst.insert(new Movie(title, director, year, grossMillions));
				System.out.println("\n" + title + " was added!\n");
				sc.nextLine();

			} else if (res.equalsIgnoreCase("d")) {
				System.out.println("Please select one of the following optionhs:\n" + "\n" + "S. Sorted\n"
						+ "U. Unsorted\n" + "\n" + "");
				System.out.printf("Enter Your Choice: ");
				res = sc.nextLine();
				if (res.equalsIgnoreCase("S")) {
					m.bst.inOrderPrint();
				} else if (res.equalsIgnoreCase("U")) {
					System.out.print(m.ht);
				} else {
					System.out.println("Invalid Option");

				}

			} else if (res.equalsIgnoreCase("r")) {
				System.out.println("\nRemoving a Movie!\n");
				System.out.print("Enter the Title: ");
				title = sc.nextLine();
				System.out.print("Enter the Director: ");
				director = sc.nextLine();
				Movie movieDelete = new Movie(title, director, 0, 0);
				if (m.ht.search(movieDelete) == -1) {
					System.out.println("\nI cannot find " + director + "'s " + title + " in the database.\n");
				} else {
					System.out.println(
							"\n" + movieDelete.getDirector() + "'s " + movieDelete.getTitle() + " was removed!\n");
					m.ht.remove(movieDelete);
					m.bst.remove(movieDelete);
				}

			} else if (res.equalsIgnoreCase("s")) {
				System.out.println("Searching for a Movie!\n");
				System.out.print("Enter the title: ");
				title = sc.nextLine();
				System.out.print("Enter the director: ");
				director = sc.nextLine();
				Movie movieSearch = new Movie(title, director, 0, 0);
				int inTable = m.ht.search(movieSearch);
				if (inTable != -1) {
					System.out.println("\n" + director + "'s " + title + " is in the database!\n");
				} else {
					System.out.println("\n" + director + "'s " + title + " is not in the database.\n");
				}

			} else {
				System.out.println("\nInvalid Selection!\n");
			}

		}
		sc.close();
		System.out.print("\nGoodBye!");
	}
}