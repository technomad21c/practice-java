import java.util.regex.Matcher;
import java.util.regex.Pattern;

//https://www.baeldung.com/java-count-chars

public class CharOccurrence {
	public static void main(String[] args) {
		String str = "elephantese";
		Character c = 'e';
		int count = 0;
		
		count = countOccurrences2(str, c);
		System.out.println("Occurences: " + count);
		
		
	}
	
	public static int countOccurrences1(String str, Character c) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c)
				count++;
		}
		
		return count;
	}
	
//	https://www.geeksforgeeks.org/count-occurrences-of-a-given-character-using-regex-in-java/
	public static int  countOccurrences2(String str, Character c) {
//		Pattern pattern = Pattern.compile(String.valueOf(c));
		Pattern pattern = Pattern.compile("[^e]*e");		
		Matcher matcher = pattern.matcher(str);
		int count = 0;
		while (matcher.find()) {
		    count++;
		}
		
		return count;		
	}
}
