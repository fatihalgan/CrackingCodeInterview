package stringmanipulation;

public class ReverseString {

	public static void main(String[] args) {
		System.out.println(reverse("a"));
		System.out.println(reverse("ab"));
		System.out.println(reverse("abc"));
	}
	
	
	public static String reverse(String input) {
		if(input.length() <= 1) return input;
		return reverse(input.substring(1, input.length())) + input.substring(0, 1); 
	}
}
