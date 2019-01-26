package _3;


import java.util.Scanner;
/**
 * 
 * the menu class give the user options that perform actions
 * 
 * @author Daniil Pleskach, 000791105
 *
 */
public class Menu {
	Scanner keyboard;
	/**
	 * 
	 * The constructor contains an object and a method
	 * 
	 * @param myDogRace refers to the dogRace object it is used as a parameter
	 * 		  in the Menu method
	 * @throws Exception handles exception of runMenu
	 */
	public Menu(dogRace myDogRace) throws Exception{
		keyboard = new Scanner(System.in);
		runMenu(myDogRace);
	}
	/**
	 * the method displays a menu with three options 
	 */
	
	private void displayMenu() {
		System.out.print("Please select one of these options:\n"
				+ "[1] Add a dog \n"
				+ "[2] Create a report \n"
				+ "[3] Exit \n"
				+ "\n"
				+ "Enter a number: ");
	}
	/**
	 * 
	 * the method returns the int that the user inputs
	 * 
	 * @return an int value from the scanner object
	 */
	private int promptUser() {
		return keyboard.nextInt();
	}
	/**
	 * 
	 * the method runs the menu so that the input from promptUser() is 
	 * 	activated accordingly. Option 1 uses addDog(), option 2 uses 
	 * 	createReport() and option 3 uses saveChanges().
	 * 
	 * @param myDogRace refers to the dogRace object it is used as a parameter
	 * 		  in the runMenu method
	 * @throws Exception handles exceptions from the dogRace class
	 */
	
	private void runMenu(dogRace myDogRace) throws Exception {
		int option;
		boolean repeat = true;
		
		
		while (repeat) {
			displayMenu();
		    option = promptUser();
		    
			switch(option) {
			case 1:
				myDogRace.addDog();
				break;
			case 2:
				myDogRace.createReport();
				break;
			case 3:
				myDogRace.saveChanges();
				repeat = false;
				break;
			default:
			System.out.println("Invalid input! Please try again.");
			}
		}
		
		
	}
}
