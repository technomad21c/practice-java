//https://www.baeldung.com/java-palindrome
package palindrome;

import java.util.Collections;
import java.util.stream.IntStream;

public class PalindromeChecker {
	public static void main(String[] args) {
		String text = "abcedecba";	
		
		if (isPalindromeUsingIntStream(text))
			System.out.println("TEXT: " + text + " is palindrome");
		else
			System.out.println("TEXT: " + text + " is not palindrome");
	}
	
	public static boolean isPalindromeUsingIntStream(String text) {
//		 noneMatch() returns true if none of the stream elements match the given predicate
		String temp = text.replaceAll("\\s+", "").toLowerCase();
		return IntStream.range(0, temp.length() / 2).allMatch(i -> temp.charAt(i) == temp.charAt(temp.length() - i -1));
	}
	
	public boolean isPalindromeReverseTheString(String text) {
	    StringBuilder reverse = new StringBuilder();
	    String clean = text.replaceAll("\\s+", "").toLowerCase();
	    char[] plain = clean.toCharArray();
	    for (int i = plain.length - 1; i >= 0; i--) {
	        reverse.append(plain[i]);
	    }
	    return (reverse.toString()).equals(clean);
	}
}
