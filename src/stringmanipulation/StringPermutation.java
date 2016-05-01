package stringmanipulation;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

	public static void main(String[] args) {
		String source = "";
		System.out.println(StringPermutation.computePermutations(null, source));
		System.out.println(StringPermutation.isPermutation("hello", "eohll"));
		System.out.println(StringPermutation.isPermutation("hi there", "there is"));
		System.out.println(StringPermutation.isPermutation("", ""));
	}
	
	
	private static List<String> computePermutations(List<String> accumulator, String word) {
		if(accumulator == null) accumulator = new ArrayList<>();
		if(word.length() == 0) return accumulator;
		char prefix = word.charAt(0);
		String posfix = word.substring(1, word.length());
		accumulator = insertChar(prefix, accumulator);
		return computePermutations(accumulator, posfix);
	}
	
	private static List<String> insertChar(char c, List<String> source) {
		List<String> result = new ArrayList<>();
		if(source.size() == 0) {
			source.add(String.valueOf(c));
			return source;
		}
		source.stream().forEach(s -> {
			for(int i = 0; i <= s.length(); i++) {
				String newStr = new StringBuilder(s).insert(i, c).toString();
				result.add(newStr);
			}
		});
		return result;
	}
	
	private static boolean isPermutation(String source, String target) {
		if(source.length() != target.length()) return false;
		int[] compare = new int[256];
		for(int i = 0; i < source.length(); i++) {
			char c = source.charAt(i);
			int index = (int)c;
			compare[index]++;
		}
		for(int i = 0; i < target.length(); i++) {
			char c = target.charAt(i);
			int index = (int)c;
			compare[index]--;
			if(compare[index] < 0) return false; 
		}
		return true;
	}
	
	//s1 = xy = waterbottle
	//x = wat
	//y = erbottle
	//s2 = erbottlewat
	//So, we need to check if there's a way to split si into x and y such that xy = si and yx =
	//s2. Regardless of where the division between x and y is, we can see that yx will always
	//be a substring of xyxy.That is, s2 will always be a substring of slsl.
	public boolean isRotation(String s1, String s2) {
		int len = s1.length();
		/* check that si and s2 are equal length and not empty */
		if(len == s2.length() && len > 0) {
			/* concatenate si and si within new buffer */
			String s1s1 = s1 + s1;
			return isSubstring(s1s1, s2);
		}
		return false;
	}
	
	public boolean isSubstring(String s1, String s2) {
		return true;
	}

}

