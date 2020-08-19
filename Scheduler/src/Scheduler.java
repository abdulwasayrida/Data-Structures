/**
 * @author ameyadighe
 * @author abdulwasayrida
 */
import java.util.InputMismatchException; 
import java.util.Scanner;

public class Scheduler {
	public static void main(String[] args) {
		List<String> Schedule = new List<>();
		Scanner input = new Scanner(System.in);
		String res = "";
		System.out.println("Welcome to Scheduler app! \n");
		System.out.println("You have no upcoming events! \n");
		int l = 1;
		while (l == 1) {
			System.out.println("Select from the following options:\n" + "A: Add an event\n" + "R: Remove an event\n"
					+ "X: Exit \n");
			System.out.printf("Enter your choice: ");
			res = input.nextLine();
			if (res.equalsIgnoreCase("x")) {
				l = 2;
				break;
			} else if (res.equalsIgnoreCase("a")) {
				System.out.printf("\nPlease enter an event: ");
				String z = input.nextLine();
				Schedule.addFirst(z);
				System.out.println();
				System.out.println("\nYour current Schedule: ");
				Schedule.printNumberedList();
				System.out.println();
				if (Schedule.getLength() > 1) {
					System.out
							.println("\nYou just added the following event to your schedule: " + Schedule.getFirst());
					System.out.print("Would you like to move this event up in your schedule (Y/N): ");
					String x = input.nextLine();
					if (x.equalsIgnoreCase("y")) {
						while (true) {
							try {
								System.out.print("Enter the number of spaces: ");
								int y = input.nextInt();

								Schedule.placeIterator();
								for (int i = 0; i < y; i++) {
									Schedule.advanceIterator();
								}
								Schedule.addIterator(z);
								break;
							} catch (NullPointerException e) {
								System.out.println("Sorry! That input is invalid");
							} catch(InputMismatchException g) {
								System.out.println("Please enter numbers only!");
							}
						}
						Schedule.removeFirst();
						System.out.println("\nYour current Schedule: ");
						Schedule.printNumberedList();
						System.out.println();
					} else {
						System.out.println();
					}

				}
			} else if (res.equalsIgnoreCase("r")) {
				while (true) {
					try {
						System.out.print("Enter the number of the event to remove: ");
						int rem = input.nextInt();
						if (rem == Schedule.getLength()) {
							System.out.println("\n Removing: "+Schedule.getLast()+"\n");
							Schedule.removeLast();
							System.out.println("Your current Schedule: ");
							Schedule.printNumberedList();
						} else if (rem == 1) {
							System.out.println("\n Removing: "+Schedule.getFirst()+"\n");
							Schedule.removeFirst();
							System.out.println("Your current Schedule: ");
							Schedule.printNumberedList();
						} else {
							Schedule.placeIterator();
							for (int i = 0; i < rem-1; i++) {
								Schedule.advanceIterator();
							}
							System.out.println("\n Removing: "+Schedule.getIterator()+"\n");
							Schedule.removeIterator();
							System.out.println("Your current Schedule: ");
							Schedule.printNumberedList();
						}
						break;
					} catch (NullPointerException e) {
						System.out.print("Sorry! That input is invalid");
					}catch(InputMismatchException g) {
						System.out.println("Please enter numbers only!");
					}

				}

			}

		}
		System.out.print("\nGoodBye!");
	}

}

