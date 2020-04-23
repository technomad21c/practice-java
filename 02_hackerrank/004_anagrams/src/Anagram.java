import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-anagrams/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen

public class Anagram {
	public static void main(String[] args) {	
		Map<Character, Long> dictA = new HashMap<>();
		Map<Character, Long> dictB = new HashMap<>();
		
		Scanner scan = new Scanner(System.in);
		String a = scan.nextLine().toLowerCase();
		String b = scan.nextLine().toLowerCase();
		
		System.out.println(isAnagram(a, b) ? "Anagrams" : "Not Anagrams");
//		dictA = countOccurrences(a);
//		dictB = countOccurrences(b);
//		System.out.println(dictA);
//		System.out.println(dictB);		
//		if (dictA.equals(dictB)) {
//			System.out.println("Anagrams");
//		} else {
//			System.out.println("Not Anagrams");
//		}
	}	
	
	public static boolean isAnagram(String a, String b) {
		boolean isAnagram = true;
		if (a.length() != b.length())
			return false;
		
		for (Character c : a.toCharArray()) {
			if (countCharOccurrence(a, c) != countCharOccurrence(b, c)) {
				isAnagram = false;
				break;
			}
		}
		
		return isAnagram;
	}
	
	
	public static HashMap<Character, Long> countOccurrences(String s) {
		HashMap<Character, Long> hm = new HashMap<>();
		long count = 0;
		for (Character c : s.toCharArray()) {
			if (hm.containsKey(c) != true) {
				count = countCharOccurrence(s, c);
				hm.put(c, count);
//				System.out.println("character: " + c + ", occurrences: " + count);
			}
		}
		
		return hm;
	}
	
	
	public static long countCharOccurrence(String s, char c) {
		long count = 0;
		count = s.chars().filter(ch -> ch == c).count();		
		return count;
	}
	
}
