import java.util.Scanner;

public class MyAnagram {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String a = scan.nextLine().toLowerCase();
		String b = scan.nextLine().toLowerCase();
		
		System.out.println("Anagram: " + (isAnagram(a, b)? "true" : "false"));
	}
	
	public static boolean isAnagram(String a, String b) {
		if (a.length() != b.length()) 
			return false;
		
		for (char c : a.toCharArray()) {
			if (countCharacter(a, c) != countCharacter(b, c)) 
				return false;
		}
		
		return true;
	}
	
	public static long countCharacter(String s, char c) {
		return s.chars().filter(ch -> ch == c).count();
	}
}

//	Scanner scan = new Scanner(System.in);
//	String a = scan.nextLine().toLowerCase();
//	String b = scan.nextLine().toLowerCase();
//	
//	System.out.println(isAnagram(a, b)? "Anagrams" : "not Anagrams");;
//}
//
//public static boolean isAnagram(String a, String b) {
//	if (a.length() != b.length()) 
//		return false;
//	
//	for (char c : a.toCharArray()) {
//		if (countCharOccurrence(a, c) != countCharOccurrence(b, c)) {
//			return false;
//		}
//	}
//	
//	return true;	
//}
//
//public static long countCharOccurrence(String s, char c) {
//	long count = 0;
//	count = s.chars().filter(ch -> ch == c).count();
//	
//	return count;
//}