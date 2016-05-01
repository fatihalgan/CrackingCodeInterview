package stringmanipulation;

import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

public class FilterChars {

	public static void main(String[] args) {
		String sentence = "Hello World";
		String tobeExtracted = "lo";
		
		Stream.of(sentence.split("")).map(c -> c.toLowerCase()).filter(
			c -> tobeExtracted.toLowerCase().indexOf(c, 0) == -1).forEach(System.out::print);
			
	}
}
