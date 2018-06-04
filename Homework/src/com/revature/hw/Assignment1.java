package com.revature.hw;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assignment1 {
	public static String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
				int whiteSpacecount = 0;
		int numberofWords = 0;
		//next removes white spaces from the ends
		String newPhrase = phrase.trim();
		newPhrase = newPhrase.replace('-', ' ');
		newPhrase = newPhrase.toUpperCase();
		//next ignores extra spaces in between words
		for(int j = 0; j < newPhrase.length() -1; j++ )
		{
			if(Character.isWhitespace(newPhrase.charAt(j))) {
				whiteSpacecount++;	
				if(Character.isWhitespace(newPhrase.charAt(j+1))) {
					whiteSpacecount--;}	
				}
		}
		numberofWords = whiteSpacecount +1;
		char [] acronymReturn = new char[numberofWords];
		acronymReturn[0]=newPhrase.charAt(0);
		int counter =0;
		int atCounter = 1;

		for(int i = 1; i < newPhrase.length()-1; i++) {		
	
			if(!Character.isWhitespace(newPhrase.charAt(i))
					&& i < newPhrase.length() -1) {
				counter ++;
			}
			if(Character.isWhitespace(newPhrase.charAt(i))&&
					((Character.isWhitespace(newPhrase.charAt(i+1)))||newPhrase.charAt(i)=='-')) {
				counter++;
				}
			if(Character.isWhitespace(newPhrase.charAt(i))
					&& i < newPhrase.length() -1 &&
					(!Character.isWhitespace(newPhrase.charAt(i+1)))) {
				acronymReturn[atCounter] = newPhrase.charAt(counter+2);
				atCounter++;
				counter++;
			}
		}	
		return new String(acronymReturn);
	}
	
	public static String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length -1, j = 0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}
	public static int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		int score = 0;
		string = string.toUpperCase();
		char [] input = new char [string.length()];
		if(1==1) {
		for(int i = 0; i < input.length; i++) {
			switch (string.charAt(i)) {
			case 'A': score = score+1; break;
			case 'E': score = score+1; break;
			case 'I': score = score+1; break;
			case 'O': score = score+1; break;
			case 'U': score = score+1; break;
			case 'L': score = score+1; break;
			case 'N': score = score+1; break;
			case 'R': score = score+1; break;
			case 'S': score = score+1; break;
			case 'T': score = score+1; break;
			case 'D': score = score+2; break;
			case 'G': score = score+2; break;
			case 'B': score = score+3; break;
			case 'C': score = score+3; break;
			case 'M': score = score+3; break;
			case 'P': score = score+3; break;
			case 'F': score = score+4; break;
			case 'H': score = score+4; break;
			case 'V': score = score+4; break;
			case 'W': score = score+4; break;
			case 'Y': score = score+4; break;
			case 'K': score = score+5; break;
			case 'J': score = score+8; break;
			case 'X': score = score+8; break;
			case 'Q': score = score+10; break;
			case 'Z': score = score+10; break;
			default: score= score +0; break;
			}
		}
		return score;
		}
		return 0;
	}
	public static String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
		//Character.isDigit(string.charAt(index)) return true if char is a number
		if(1==1) {
		int counter = 0;
		for(int i = 0; i < string.length(); i++) {
			if(Character.isDigit(string.charAt(i))){
				counter++;
			}
		}
		System.out.println("Number of digits: "+counter);
		if(counter > 11) {
			throw new IllegalArgumentException ("bigger than 11");
		}
		if(string.length() > 9 && counter < 8) {
			throw new IllegalArgumentException ("non numerics");
		}
		char [] cleaned = new char[counter];
		counter=0;
		for(int i = 0; i < string.length(); i++) {
			if(Character.isDigit(string.charAt(i))){
				cleaned[counter]=string.charAt(i);
				counter++;
			}
			if(!Character.isDigit(string.charAt(i))) {
				;
			}
		}
		return new String(cleaned);}
		return null;
	}
	public static Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		String words [] = string.split(",\\s\n|,\\s|\\s|-|,|\n"); 
		if(1==1) {
		for(int i = 0; i <words.length; i++) {
			System.out.println(words[i]);
		}
		Map<String, Integer> myMap = new HashMap<>();
		for(int i = 0; i <words.length; i++) {
			if(!myMap.containsKey(words[i])) {
			myMap.put(words[i], 1);}
			else if(myMap.containsKey(words[i])) {
				myMap.put(words[i], myMap.get(words[i]) + 1);}
		}
		System.out.println(Arrays.asList(myMap));
		return myMap;}
		return null;
	}
	public static String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration
		// String [] words = string.split(",\\s\n|,\\s|\\s|-|,|\n"); 
		String ay = "ay";
		//for(int i = 0; i < string.length()-1; i++) {
		if(1==1) {
		if (string.startsWith("sch")) {
			string = string.substring(3);
			string = string.concat("sch");
			string = string.concat(ay);
			System.out.println(string);
			return string;
		}
		if (string.startsWith("th")) {
			string = string.substring(2);
			string = string.concat("th");
			string = string.concat(ay);
			System.out.println(string);
			return string;
		}
		if (string.startsWith("ch")) {
			string = string.substring(2);
			string = string.concat("ch");
			string = string.concat(ay);
			System.out.println(string);
			return string;
		}
		if (string.startsWith("sh")) {
			string = string.substring(2);
			string = string.concat("sh");
			string = string.concat(ay);
			System.out.println(string);
			return string;
		}
		if (string.startsWith("kn")) {
			string = string.substring(2);
			string = string.concat("kn");
			string = string.concat(ay);
			System.out.println(string);
			return string;
		}
		
			switch (string.charAt(0)) {
			case 'a': string = string.concat(ay); break;
			case 'e': string = string.concat(ay); break;
			case 'i': string = string.concat(ay); break;
			case 'o': string = string.concat(ay); break;
			case 'u': string = string.concat(ay); break;
			case 'y': string = string.substring(1); string = string.concat(ay); break;
			case 'b': string = string.substring(1); string = string.concat(ay); break;
			case 'c': string = string.substring(1); string = string.concat(ay); break;
			case 'd': string = string.substring(1); string = string.concat(ay); break;
			case 'f': string = string.substring(1); string = string.concat(ay); break;
			case 'g': string = string.substring(1); string = string.concat(ay); break;
			case 'h': string = string.substring(1); string = string.concat(ay); break;
			case 'j': string = string.substring(1); string = string.concat(ay); break;
			case 'k': string = string.substring(1); string = string.concat(ay); break;
			case 'l': string = string.substring(1); string = string.concat(ay); break;
			case 'm': string = string.substring(1); string = string.concat(ay); break;
			case 'n': string = string.substring(1); string = string.concat(ay); break;
			case 'p': string = string.substring(1); string = string.concat(ay); break;
			case 'q': string = string.substring(1); string = string.concat(ay); break;
			case 'r': string = string.substring(1); string = string.concat(ay); break;
			case 's': string = string.substring(1); string = string.concat(ay); break;
			case 't': string = string.substring(1); string = string.concat(ay); break;
			case 'v': string = string.substring(1); string = string.concat(ay); break;
			case 'w': string = string.substring(1); string = string.concat(ay); break;
			case 'x': string = string.substring(1); string = string.concat(ay); break;
			case 'z': string = string.substring(1); string = string.concat(ay); break;
			
			
			default: ; break;
			//}
			}
		
		//System.out.println(string);
		return string;}
		return null;
	}
	public static boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		int size = String.valueOf(input).length();
		double sum = 0;
		int remainder = 0;
		int n = input;
		double check = (double)n;
		
		while(n > 0) {
			remainder= n%10;
			sum = sum + Math.pow(remainder, size);
			n = n/10;
			
		}
		if(check == sum) {
			return true;
		}
		return false;
	}


	public static void main(String[] args) {
		
//	    System.out.println(reverse("test"));
//	    System.out.println( acronym(" Testing,   two-strings now "));
//	    Triangle t1 = new Triangle(0.5, 0.4, 0.3);
//	    System.out.println("The triangle is equilateral? "+t1.isEquilateral());
//	    System.out.println("The triangle is isoceles? "+t1.isIsosceles());
//	    System.out.println("The triangle is scalene? "+t1.isScalene());
//	    System.out.println(getScrabbleScore("cabbage"));
//	    System.out.println(cleanPhoneNumber("(223) 456-7890999"));
	    //   System.out.println(wordCount("one, \ntwo, \nthree"));
//		List<String> sortedList = Collections.unmodifiableList(Arrays.asList("1", "3", "4", "6", "8", "9", "11"));
//		System.out.println(sortedList.size());
//		System.out.println((sortedList.size()+1)/2);
//		toPigLatin("therapy");
		int n = 153;
		int size = String.valueOf(n).length();
		System.out.println(15%10);
		System.out.println(15/10);
		System.out.println(size);
		System.out.println(Math.pow(3,3));
		System.out.println(isArmstrongNumber(10));
		
	    
	}
}
