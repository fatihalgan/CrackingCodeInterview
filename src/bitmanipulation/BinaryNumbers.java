package bitmanipulation;


public class BinaryNumbers {

	/**
	 * Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print
	 * the binary representation. If the number cannot be represented accurately in binary
	 * with at most 32 characters, print "ERROR."
	 */
	/**
	 * To print the decimal part, we can multiply by 2 and check if 2n is greater than or equal
	 * to 1.This is essentially "shifting" the fractional sum. 
	 * If r >= 1, then we know that n had a 1 right after the decimal point. By doing this
	 * continuously, we can check every digit.
	 */
	public static String printBinary(double num) {
		if(num >= 1 && num < 0) return "ERROR";
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while(num > 0) {
			/* Setting a limit on length: 32 characters */
			if(binary.length() >= 32) return "ERROR";
			double r = num * 2;
			if(r >= 1) {
				binary.append(1);
				num = r - 1;
			} else {
				binary.append(0);
				num = r;
			}
		}
		return binary.toString();
	}
	
	
	
	
	
}
