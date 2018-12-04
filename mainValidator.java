import java.util.*;
import java.io.*;
public class mainValidator {

	public static void main(String[] args) {
		// This is the main method of the HTML validator
		//It's purpose is to take in a HTML file and check if all the tags match up
		//if it finds unmatched tags it flags the file as invalid.
		
		String fileName;//stores the file that we're going to test
		Scanner in = new Scanner(System.in); //needed to ask the user what file we're going to test
		int counter = 2;//counter for the do while loop to make sure that we have a valid file.
		
		 do {
		    try {//try statement to catch any exceptions when the program trys to read the file
				System.out.println("Please enter the name of the input file you would like to validate.");
				fileName = in.nextLine();
				//asks the user for a file and sets it equal to fileName
				File file = new File(fileName);
				//creates a new file object so we can read it.
		   		Scanner reader = new Scanner(file);
		   		//create a new scanner object so we can read the file.
				counter = 1;
				//if the program comes this far that means the file is readable so we put the counter to 1
				reader.close();
				//always close the reader
				System.out.print(Validator.validator(fileName));
				//hands over the file name to our validator.
		    }
		    catch (Exception e) {
		    	System.out.println("Couldn't read that file, please try again!");
		    	//handles the exception thrown by the try statement and promts the reader to try again.
		    }
		 }while (counter ==2);
		 in.close();
		 //always close your scanners.
		 }
	}


