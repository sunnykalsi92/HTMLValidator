import java.io.File;
import java.util.Scanner;

public class Validator {

	public static String validator(String x) {
		//the validator takes in a string passed through the main class
		//runs it as a file and checks if it's a valid HTML file
		
		//create a new array bounded stack named tag
		ArrayBoundedStack<String> tag = new ArrayBoundedStack<>();
		String fileName = x; //passes through the file name
		String result = null;//this keeps track of what we read from the file
		String dummy = ""; // our return statement
		String[] fileArray;// the array we're going to keep all the tags in after they're read
		int tagCounter =0; // keeps track of any unmatched tags we come across
		
		try {//reads the file line by line, then adds the read part to result
			File file = new File(fileName);
	   		Scanner reader = new Scanner(file);
	        String line= null;
	        while(reader.hasNextLine()) {
	        	line = reader.nextLine();
	        	result = result + line;
	        }
	        reader.close();
	        //always close the reader.
	    }catch (Exception e) {
	    	System.out.println(e.getMessage());
	    }
		
		fileArray = Tag.findTags(result);
		//pass the results to the findTags method in the tag class. this takes the entire string and passes back an array of tags
		
		//start of validation process
		for(int i = 1; i< fileArray.length;i++) {
			if(tag.isEmpty()){//if tag is empty you don't compare
				if(Tag.hasEnd(fileArray[i])) {//if tag has an end you can add it to the stack.
					tag.push(fileArray[i]);
				} 
				else {
					System.out.println("No match needed: "+fileArray[i]);//prompt
				}
			}else{
				if(Tag.hasEnd(fileArray[i])) {//run this if the tag has an end
					String last = tag.top();//assign the top
					String current = fileArray[i];//assign what you're currently reading
					if(Tag.areMatching(last, current)) {//if they match, pop and print
						tag.pop();
						System.out.println("Matched: "+last+" and "+current);
					}else if(current.charAt(1)=='/'){//check if it's a closing tag
						if(tag.isEmpty()) {//if the stack is empty it's missing a start tag
							System.out.println("Missing a start tag: "+fileArray[i]);
						}else if (i+1<fileArray.length) {//make sure you don't go out of bounds of the array
							if (Tag.areMatching(last, fileArray[i+1])) {//make sure the next element doesn't match the next element in the array
								System.out.println("Missing a start tag: "+current);
								tagCounter++;
							}
						}
						else {
						tag.push(fileArray[i]);
					}
					}else {
					tag.push(fileArray[i]);
					}
				}else {//if the tag doesn't have an end dont' add to the stack
					System.out.println("No match needed: "+fileArray[i]);
				}
			}
		}
			//this loop makes sure that if there are any elements left in the stack
			//it prints out what they're missing and adds to the tagCounter
				while(!tag.isEmpty()) {
				String top = tag.top();
				if(top.charAt(1)=='/') {
					System.out.println("Missing a start tag: "+top);
					tag.pop();
					tagCounter++;
				} else {
					System.out.println("Missing a end tag: "+top);
					tag.pop();
					tagCounter++;
				}
			}
		//if the counter is higher then 0 set dummy to not valid.
		if (tagCounter >0) {
			dummy = ("This file had unmatched tags. This HTML is NOT valid!");
		} else {//else make the file valid
			dummy = ("All the tags matched! This HTML is valid!");
		}
		
		//return statement that says if the HTML is valid or not
	return dummy;
}
}

