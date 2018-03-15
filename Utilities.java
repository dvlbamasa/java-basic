import java.util.Scanner;
import java.util.Random;

public class Utilities {

	Scanner scanner = new Scanner(System.in);
	Random random = new Random();	

	public void printArray(String [][] arrayOfAscii, int numberOfRows, int numberOfColumns) {
		for (int row = 0; row < numberOfRows; row++) {
			for (int column = 0; column < numberOfColumns; column++) {
				System.out.print(arrayOfAscii[row][column]);
				System.out.print(column == numberOfColumns-1 ? "" : " | ");
			}
			System.out.println("");
			for (int k = 0; k < numberOfColumns * 5; k++)
				System.out.print("-");
			System.out.println("");
		}
	}

	public void search(String [][] arrayOfAscii, int numberOfRows, int numberOfColumns) {
		boolean stringFound = false;
		System.out.print("Enter the ASCII characters to be searched: ");
		String newString = scanner.next();
		for (int row = 0; row < numberOfRows; row++) {
			for (int column = 0; column < numberOfColumns; column++) {
				if (arrayOfAscii[row][column].contains(newString)){
					System.out.println("***" + newString + " can be found at row " + row + ", column " + column + ".");
					stringFound = true;
				}
			}
		}
		if (!stringFound) {
			System.out.println(newString + " was not found on the array.");
		}
	}

	public void edit(String [][] arrayOfAscii) {
		try {
			System.out.print("Enter the row number to be edited: ");
			int row = scanner.nextInt();
			System.out.print("Enter the column number to be edited: ");
			int column = scanner.nextInt();
			System.out.print("Enter the new ASCII characters: ");
			String newString = scanner.next();
			if (newString.length() > 3) {
				System.out.println("***The new ASCII characters should not be more than 3.");
			}
			else {
				arrayOfAscii[row][column] = newString;
				System.out.println("***Array element successfully edited.");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("***Wrong array index!");
		} catch (java.util.InputMismatchException e) {
			System.out.println("***Wrong input!");
		}
	}

	public void printMenu() {
		System.out.print("*****RANDOMIZER APP MENU*****\n" + 
						"1. Search" + "\n" +
						"2. Edit" +  "\n" +
						"3. Print" + "\n" +
						"4. Reset" + "\n" +
						"5. Exit" + "\n" + 
						"Enter the number of your choice: ");
	}

	public void randomizeArrayContent(String [][] arrayOfAscii, int numberOfRows, int numberOfColumns) {
		char randomChar;
		for (int row = 0; row < numberOfRows; row++) {
			for (int column = 0; column < numberOfColumns; column++) {
				arrayOfAscii[row][column] = "";
				for (int k = 0; k < 3; k++) {
					randomChar = (char)(random.nextInt(94) + 32);
					arrayOfAscii[row][column] = arrayOfAscii[row][column].concat(randomChar+"");
				}
			}
		}
	}
}