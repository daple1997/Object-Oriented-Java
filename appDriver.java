package _3;
/**
 * 
 * The driver class runs the whole package
 * 
 * @author Daniil Pleskach, 000791105
 *
 */

public class appDriver {
	/**
	 * 
	 * This main method that contains two objects and handles exceptions
	 * 
	 * @param args is required for the program to run
	 * @throws Exception handles exceptions thrown in the dogRace class 
	 */ 
	public static void main(String[] args) throws Exception {
		dogRace myDogRace = new dogRace ();
		@SuppressWarnings("unused")
		Menu menu = new Menu (myDogRace);
	}
}
