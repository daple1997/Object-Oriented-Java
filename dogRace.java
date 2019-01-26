package _3;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * The classes handles the reads the data in the dogs.txt, adds a dog, 
 * 	creates a report of the dogs, saves changes and displays the current
 * 	date. The path to dogs.txt is set as a constant. An array list is
 * 	created from Assignment1, and a scanner and an Assignment1 objects are
 *  created.
 * 
 * @author Daniil Pleskach, 000791105
 *
 */

public class dogRace {
	
	private final String DOG_FILE = "res/dogs.txt"; 
	
	ArrayList<Assignment1> DogList;
	Scanner input;
	Assignment1 oneDog;
	
	/**
	 * 
	 * The method carries over the two objects so they can be used in 
	 * 	makeDogList().
	 * 
	 * @throws Exception handles exceptions from makeDogList(). 
	 */
	public dogRace() throws Exception{
		DogList = new ArrayList<Assignment1>();
		input = new Scanner(System.in);
		makeDogList();
	}
	/**
	 * 
	 * The method has a File object and a scanner Object that are both used
	 * 	to collect data from dogs.txt. The while loop parses through data
	 * 	and recognizes a dog every 5th segment with a space as delimiter.
	 *  Then, it adds it to the oneDog object as 5 parameters and adds it
	 *  to the array list object. Finally, the scanner object is closed.
	 * 
	 * @throws Exception handles exceptions thrown by the File object and
	 * 	Scanner object.
	 */
	
	private void makeDogList() throws Exception{
		File myFile = new File(DOG_FILE);
		Scanner reader = new Scanner(myFile);
		String[] Line;
		
		while (reader.hasNext()) {
			Line = reader.nextLine().split(" ");
			Assignment1 oneDog = new Assignment1(Line[0], Line[1],
										 Double.parseDouble(Line[2]),
										 Integer.parseInt(Line[3]),
										 Line[4]);
			DogList.add(oneDog);
		}
		reader.close();
	}
	/**
	 * the method adds a dog according to ID, name, running time, penalties
	 * 	and course code. A boolean is created to check if the input data is
	 * 	right. The ID must be 5 characters long(digit,letter, 3 digits), both
	 * 	the running time and penalty must be over zero, and the code should
	 *  be "G","g","J","j","T" and"t". If the input is right the data is
	 *  input into the Assignment1 parameters and added to the array list.
	 *  Otherwise, the user it is not. 
	 * 	
	 */
	
	public void addDog() {
		boolean b = true;
		System.out.print("Enter a 5 character ID(digit,letter,3 digits): ");
		String id = input.nextLine();
		if(id.length() != 5 || !Character.isDigit(id.charAt(0)) || 
				!Character.isLetter(id.charAt(1)) || 
				!Character.isDigit(id.charAt(2)) || !Character.isDigit(id.charAt(3)) || 
				!Character.isDigit(id.charAt(4)) ) {
			
			System.out.println("\nInvalid input!");
			b = false;
		}
		
		System.out.print("Enter the name of the dog: ");
		String name = input.nextLine();
		
		System.out.print("Enter the Running Time(more than zero): ");
		double runTime = input.nextDouble();
		if(runTime <= 0) {
			System.out.println("\nInvalid input!");
			b = false;
		}
		
		System.out.print("Enter the penalties: ");
		int penalty = input.nextInt();
		if(penalty <= 0) {
			System.out.println("\nInvalid input!");
			b = false;
		}
		
		System.out.print("Enter the code: ");
		String code = input.next();
		
		if(!code.equalsIgnoreCase("G") && !code.equalsIgnoreCase("J") &&
				!code.equalsIgnoreCase("T")  ) {
			System.out.println("\nInvalid input!");
			b = false;
		} 
		if(b) {
			Assignment1 oneDog = new Assignment1(id, name, runTime, penalty, code);
					
			DogList.add(oneDog);
					
			
			System.out.println("\nThe new dog was added!");
		}
		else {
			System.out.println("\nA mistake was made. Try again.");
		}
	}
	/**
	 * the method creates a report using the getCurrentDate() and printData()
	 * 	to make 3 charts for each course. The letter of the course is used as
	 * 	a parameter for the printData().
	 * @throws Exception handles errors
	 */
	public void createReport() throws Exception {
			System.out.printf("%-15s%28s%47s%n","Report","GAMBLERS – Course Time: 56.7",
					getCurrentDate());
			
			printData("G");
			System.out.printf("%-15s%28s%47s%n","Report","JUMPERS – Course Time: 23.5",
					getCurrentDate());
			printData("J");
			
			System.out.printf("%-15s%28s%47s%n","Report","Titling – Course Time: 67.9",
					getCurrentDate());
			printData("T");
	}
	/**
	 * 
	 * @param code 
	 * @throws Exception
	 */
	public void printData(String code) throws Exception{
		System.out.printf("%-15s%15s%15s%15s%15s%15s%n","ID","Name", "Running Time",
				"Penalty","Total Time","Over/Under");
		for(int i = 0 ; i< DogList.size(); i++) {
			if(DogList.get(i).getCode().equalsIgnoreCase(code)) {
				System.out.printf("%-15s%15s%15.1f%15d%15s%+15.1f%n",DogList.get(i).getId(),
						DogList.get(i).getName(), DogList.get(i).getRunTime(),
						DogList.get(i).getPenalty(), DogList.get(i).getTotalTime(),
						DogList.get(i).getDifference() );
			}
		}
		winningDog(code);
		mostPenalties(code);
		System.out.println();
	}
	
	/**
	 * The method finds and prints the winning dog for the course. 
	 * @param code assigns a course code
	 */
	private void winningDog(String code) {
		String name = "";
		double bestTime = 9999.9;
		for(int i = 0 ; i< DogList.size(); i++) {
			if(DogList.get(i).getCode().equalsIgnoreCase(code)) {
				if(DogList.get(i).getTotalTime() < bestTime) {
					bestTime = DogList.get(i).getTotalTime();
					name = DogList.get(i).getName();
				}
			}
		}	
		System.out.printf("%-15s%15s%15s%-15.1f %n","Winning Dog: ",name,
				"Time: ", bestTime);
	}
	/**
	 * 
	 * The method prints the dog with the most penalties. If no penalties
	 *  were given the name is printed as "N/A". 
	 * 
	 * @param code code assigns a course code
	 */
	private void mostPenalties(String code) {
		String name = "N/A";
		int penalty = 0;
		for(int i = 0 ; i< DogList.size(); i++) {
			if(DogList.get(i).getCode().equalsIgnoreCase(code)) {
				if(DogList.get(i).getPenalty() > penalty) {
					penalty = DogList.get(i).getPenalty();
					name = DogList.get(i).getName();
				}
			}
		}
		System.out.printf("%-15s%15s%15s%-15d%n","Most Penalties: ",name,
				"Penalties: ", penalty);
	}
	/**
	 * 
	 * the method saves a new dog from the array list onto the dog.txt and 
	 * exits the program. 
	 * 
	 * @throws Exception handles exception thrown by the FileWriter and 
	 * 	PrintWriter objects.
	 */
	public void saveChanges() throws Exception{
		FileWriter fw = new FileWriter(DOG_FILE,false);
		PrintWriter pw = new PrintWriter(fw);
		
		for(int i =0; i< DogList.size();i++) {
			pw.print(DogList.get(i).getId()+" ");
			pw.print(DogList.get(i).getName()+" ");
			pw.print(DogList.get(i).getRunTime()+" ");
			pw.print(DogList.get(i).getPenalty()+" ");
			pw.print(DogList.get(i).getCode()+" ");
			pw.println();
		}
		
		pw.close();
		fw.close();
		System.out.println("Changes Saved!");
	}
	
	/**
	 * 
	 * the method returns the current date as a String.
	 * 
	 * @return currentDate returns the formatted current date
	 */
	private String getCurrentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");  
	    Date date = new Date();  
	    String currentDate = formatter.format(date);  
		return currentDate;
	}
	
}
