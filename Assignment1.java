package _3;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * This class contains id, name, running time, penalty and code private
 * instance fields.
 * 
 * @author Daniil Pleskach, 000791105
 *
 */

public class Assignment1 {
	private String id, code, name;
	private double runTime;	
	private int penalty;
	/**
	 * Constructor assigns values for id, name, runTime, penalty and code.
	 * 
	 * @param id a string for the ID of the competitors (digit, letter,
	 * 	3 digits)
	 * @param name a string for the name of the competitors without 
	 * 	      spaces
	 * @param runTime a double for the running time of the competitors
	 * 		  in seconds 
	 * @param penalty an int for the penalties received by the competitors,
	 * 		  one penalty is an addition of one second to the running time
	 * @param code a String for the type of course the competitors are
	 * 		  running
	 */
	
	public Assignment1 (String id, String name, double runTime, int penalty, String code) {
		this.id = id;
		this.name = name;
		this.runTime = runTime;
		this.penalty = penalty;
		this.code = code;
	}
	/**
	 * 
	 * The setter assigns a String value to ID
	 * 
	 * @param id for the ID of a new competitor
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 
	 * the getter accesses the value of id
	 * 
	 * @return id returns the String value
	 */
	
	public String getId() {
		return id;
	}
	/**
	 * 
	 * The setter assigns a String value to name
	 * 
	 * @param n for the name of new competitor
	 */
	public void setName(String n) {
		name = n;
	}
	/**
	 * 
	 * the getter accesses the value of name
	 * 
	 * @return name returns the String value
	 */
	
	public String getName() {
		return name;
	}
	/**
	 * 
	 * The setter assigns a double value to runTime
	 * 
	 * @param run assigns a double to runTime
	 */
	
	public void setRunTime(double run) {
		runTime = run;
	}
	/**
	 * 
	 * the getter accesses the value of runTime
	 * 
	 * @return runTime returns the double value
	 */
	public double getRunTime() {
		return runTime;
	}
	/**
	 * 
	 * the setter assigns an int to penalty
	 * 
	 * @param penalty assigns the int value
	 */
	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}
	/**
	 * 
	 * the getter accesses the value of penalty
	 * 
	 * @return penalty returns the int value
	 */
	public int getPenalty() {
		return penalty;
	}
	/**
	 * 
	 * the getter accesses the value of penalty and runTime
	 * 
	 * @return (double)penalty + runTime return the double value
	 */
	
	public double getTotalTime( ) {
		return (double)penalty + runTime;
	}
	/**
	 * 
	 * the setter assigns a String to code
	 * 
	 * @param code assigns the String value
	 */
	
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 
	 * the getter accesses the value of code
	 * 
	 * @return code returns the String value
	 */
	
	public String getCode() {
		return code;
	}
	/**
	 *  the getter accesses the value of runTime minus the records for the
	 * courses and handles exceptions
	 * 
	 * @return diff returns the double value
	 * @throws Exception
	 */
	
	public double getDifference() throws Exception{
		double [] record = new double [3];
		final String COURSE_FILE = "courses.txt";
		File myFile = new File(COURSE_FILE);
		Scanner reader = new Scanner(myFile);
		String [] recordNameArray;
		for (int i = 0; i < 3; i ++) {
			String recordName = "";
			recordNameArray = new String [2];
			recordNameArray = reader.nextLine().split(" ");
			recordName = recordNameArray[1];
			record[i] = Double.parseDouble(recordName);
		}
		reader.close();
		double diff = 0;
		switch(code) {
		case "G":
		case "g":
			diff = getRunTime() - record[0];
			break;
		case "J":
		case "j":
			diff = getRunTime() - record[1];
			break;
		case "T":
		case "t":
			diff = getRunTime() - record[2];
			break; 
	    default:
	    	System.out.println("Invalid input");
	    	break;
		}
		return diff;			
	}

}
