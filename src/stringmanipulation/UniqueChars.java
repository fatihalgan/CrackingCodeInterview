package stringmanipulation;

import java.util.HashMap;

public class UniqueChars {

	// use a bit vector to compute if a string has all unique characters.
	//define a checker variable (int allows 32 bits, so it can hold a bit vector for
	//all ASCII lowercase chars between [a-z].)
	//let val be str.charAt(i) - 'a' (index in the bitvector)
	//let checker hold the bitvector
	//checker |= (1 << val) marks the char in the bitvector
	//checker & (1 << val) == 0 tells the character(val) is not yet in the bitvector
	public boolean isUniqueChars(String str) {
		int checker = 0;
		for(int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if((checker & (1 << val)) > 0) return false;
			checker |= (1 << val);
		}
		return true;
	}
	
	//Use a simple array to hold all letters of alphabet
	//let's say the alphabet consists of 256 characters
	public boolean isUniqueChars2(String str) {
		if(str.length() > 256) return false;
		boolean[] charSet = new boolean[256];
		for(int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if(charSet[val]) return false;
			charSet[val] = true;
		}
		return true;
	}
}
