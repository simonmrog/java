
public class WorkingWithStrings {
	
	public static void main(String args[]) {
		
		String string1 = "I am a string";
		String string2 = "I am a string aswell";
		String string3 = "This is another String";
		String string4 = "This IS ANOTHER STRING";
		
		if (string1.equals(string2)) //method which returns true of the string1 is the same as the string2
			System.out.println("The strings are equal");
		else System.out.println("The strings are NOT equal");
		
		if (string3.equalsIgnoreCase(string4)) //Same as "equals()" but ignoring cases
			System.out.println("The letters of the strings are equal");
		else System.out.println("The letters of the strings are NOT equal");
		
		//Two ways of getting the difference between the length of string2 and the length of string1
		System.out.println(string2.compareTo(string1)); 
		System.out.println(string2.length() - string1.length()); 
		System.out.println(string1.compareTo(string2)); 
		System.out.println(string1.length() - string2.length());
		
		//returns the char at position 3 of the string
		System.out.println("Position 3 of string: " + string2.charAt(3)); 
		
		//Returns the position of the substring "string" if exists, else returns -1
		System.out.println("Position of 'string':" + string1.indexOf("string"));
		System.out.println("Position of 'car':" + string1.indexOf("car"));
		
		//turns the string to upper case 
		System.out.println(string1.toUpperCase());
		
		//turns the string to lower case 
		System.out.println(string4.toLowerCase());
		
		//creates a substring from the position 0 to 4 (without includying it)
		String substr = string4.substring(0, 4);
		System.out.println("Substring from 0 to 3: " + substr);
	}
}
