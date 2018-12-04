

public class Tag {
	//this method takes in a string and checks for any <tags>, if it finds the tag
	//it then adds it to the fileArray and return it. This makes sure any attributes of the tags
	//are not added to the array.
	public static String[] findTags(String line) {
		String fileString=" ";//string of tags
		String[] fileArray;//array of tags
      for (int i = 0; i< line.length();i++) {
	        	if(line.charAt(i)=='<') {//check if that part of the string starts with a <
	        		String tag = "";
	        		while(line.charAt(i) != ' ' && line.charAt(i) != '>') {
	        			tag = tag + line.charAt(i);
	        			i++;
	        			//reads and adds to the tag until it hits a > or a empty space
	        		}
	        		if(line.charAt(i) == ' ') {
	        		while(line.charAt(i) != '>') {
	        			i++;//if it hits a empty space it skips that char
	        		}
	        		}
	        		if(line.charAt(i) == '>') {
	        		tag = tag + line.charAt(i);
	        		fileString = fileString +" " +tag;
	        		//if it hits a > it adds it to the tag, and adds the tag to the fileString
	        		}
	        	}	
	    }
      fileArray = fileString.split("\\s+");
      //convert the string to an array by splitting all the spaces
      return fileArray;
      //return the array
        }
	
	//This method takes a string and checks if it has a end tag. either a true or false.
       public static boolean hasEnd(String tag1) {
    	   String tag = tag1;
    	   tag = tag.replace("<", "");//removes <
    	   tag = tag.replace(">","");//removes >
    	   //each empty tag has a if statement.
    	   if( tag == "area") {
    		  return false; 
    	   }else if(tag.equalsIgnoreCase("base")) {
     		  return false; 
     	   }else if(tag.equalsIgnoreCase("br")) {
     		  return false; 
     	   }else if(tag.equalsIgnoreCase("param")) {
     		  return false; 
     	   }else if (tag.equalsIgnoreCase("col")) {
    		   return false;
    	   }else if (tag.equalsIgnoreCase("command")) {
    		   return false;
    	   }else if (tag.equalsIgnoreCase("embed")) {
    		   return false;
    	   }else if (tag.equalsIgnoreCase("hr")) {
    		   return false;
    	   }else if (tag.equalsIgnoreCase("image")) {
    		   return false;
    	   }else if (tag.equalsIgnoreCase("input")) {
    		   return false;
    	   }else if (tag.equalsIgnoreCase("keygen")) {
    		   return false;
    	   }else if (tag.equalsIgnoreCase("link")) {
    		   return false;
    	   }else if (tag.equalsIgnoreCase("meta" )) {
    		   return false;
    	   }else if (tag.equalsIgnoreCase("source")) {
    		   return false;
    	   }else if (tag.equalsIgnoreCase("track")) {
    		   return false;
    	   }else if (tag.equalsIgnoreCase("wbr")) {
    		   return false;
    	   }else {//if they aren't a empty tag method return a true.
    		   return true;
    	   }
       }
       
       //This method takes in two tags and checks if they're the same
       //makes sure to check for the / to indicate a end tag.
       public static boolean areMatching(String tag, String tag2) {
    	 String firstTag = tag.toLowerCase();//first tag
    	 String endTag = tag2.toLowerCase();//end tag
    	 String testTag = "<";
    	 for(int i = 2; i< endTag.length();i++) {//starts at i=2 because we don't care about </
    		testTag = testTag +endTag.charAt(i);
    	 }
    	 if(testTag.equals(firstTag)) {
    		 return true;
    		 //return true if they are equal
    	 }
    	 else {
    		 return false;
    		 //return false if they are not equal
    		 }
    	 }
       
}
       
        
	


