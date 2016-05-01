package stringmanipulation;

public class CharReplacement {

	
	public static void main(String[] args) {
		System.out.println(substituteSpaces("Mr John Smith    ", 13));
	}
	
	
	public static String substituteSpaces(String str, int trueLength) {
		char[] source = str.toCharArray();
		int length = source.length;
		for(int i = trueLength - 1; i >= 0; i--) {
			length--;
			if(source[i] != ' ') source[length] = source[i];
			else {
				source[length] = '0';
				length--;
				source[length] = '2';
				length--;
				source[length] = '%';
			}
		}
		return String.copyValueOf(source);
	}
}
