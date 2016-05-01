package stringmanipulation;

public class CompressionCharCount {

	public static void main(String[] args) {
		System.out.println(compress("aabccccaaa"));
	}
	
	public static String compress(String source) {
		if(source.length() < 2) return source;
		StringBuilder target = new StringBuilder();
		char previous = source.charAt(0);
		int count = 1;
		for(int i = 1; i < source.length(); i++) {
			char current = source.charAt(i);
			if(current == previous) {
				count++;
			} else {
				target.append(previous + "" + count);
				count = 1;
			}
			previous = current;
		}
		target.append(previous + "" + count);
		return target.toString();
	}
}
