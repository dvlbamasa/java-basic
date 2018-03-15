import java.util.Scanner;
import java.util.Random;

public class RandomizerApp {

	Scanner scanner = new Scanner(System.in);

	public int numberOfRows;
	public int numberOfColumns;

	public int userChoice = 0;

	public final int SEARCH  = 1;
	public final int EDIT = 2;
	public final int PRINT = 3;
	public final int RESET = 4;
	public final int EXIT = 5;

	public String arrayOfAscii [][];
	
	Utilities utilities = new Utilities();

	public RandomizerApp() {
		resetAll();
		startApp();
	}

	public void resetAll() {
		getInput();
		initializeArray();
		utilities.randomizeArrayContent(arrayOfAscii, numberOfRows, numberOfColumns);
		utilities.printArray(arrayOfAscii, numberOfRows, numberOfColumns);
	}

	public void getInput() {
		try {
			System.out.print("Enter number of rows: ");
			numberOfRows = scanner.nextInt();
			System.out.print("Enter number of columns: ");
			numberOfColumns = scanner.nextInt();
		} catch (java.util.InputMismatchException e) {
			System.out.println("***Wrong input!");
			scanner.nextLine();
			getInput();
		}	
	}

	public void initializeArray() {
		arrayOfAscii = new String [numberOfRows][numberOfColumns];
	}

	public void startApp() {
		while (userChoice != EXIT) {
			try {
				utilities.printMenu();
				userChoice = scanner.nextInt();
				if (userChoice == SEARCH) {
					utilities.search(arrayOfAscii, numberOfRows, numberOfColumns);
				}
				else if (userChoice == EDIT) {
					utilities.edit(arrayOfAscii);
				}
				else if (userChoice == PRINT) {
					utilities.printArray(arrayOfAscii, numberOfRows, numberOfColumns);
				}
				else if (userChoice == RESET) {
					resetAll();
				}
				else if (userChoice == EXIT) {
					System.out.println("***App terminated.");
				}
				else {
					System.out.println("***Wrong input choice!");
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("***Wrong input choice!");
				scanner.nextLine();
			}
		}
		System.exit(0);
	}
}