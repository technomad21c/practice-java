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
		
		System.out.println(isAnagram2(a, b) ? "Anagrams" : "Not Anagrams");
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
	
//	another solution by @battlizer (https://www.hackerrank.com/battlizer)
	public static boolean isAnagram2(String a, String b) {
		if(a.length() != b.length()) 
			return false;
		
	    int c[] = new int[26], d[] = new int[26] ;
	    a = a.toUpperCase();
	    b = b.toUpperCase();
	    for(int i=0; i<a.length(); i++){
	        c[a.charAt(i) - 'A']++;
	        d[b.charAt(i) - 'A']++;
	    }
	    for(int i =0;i<26; i++)
	        if(c[i] != d[i] ) return false;
	    return true;
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
