import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;



//https://www.hackerrank.com/challenges/java-anagrams/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen

public class MyAnagram {
	public static void main(String[] args) {
		String a = "";
		String[] b= {"Steer", "Cars", "Ardvark"};
		
		File file = new File("src/test-input.txt");
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(fileReader);
			a = bufReader.readLine();
			//b = bufReader.readLine().trim().toLowerCase().split("\\s+");
			
			
			System.out.println("this is a debug message");
			System.out.println(a);
			System.out.println(b[0] +", "+  b[1]);
       			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		solution(a, b);
	}
	
	public static boolean solution(String a, String[] b) {
		List<String> listComparisonStrings = Arrays.asList(b);
		boolean isAnagram = false;
		a = a.toLowerCase();
		for (String str : listComparisonStrings) {			
			if (isAnagram(a, str.toLowerCase())) { 
				isAnagram = true;
				System.out.println("Angagram");
			}
			
		}				
		System.out.println(isAnagram? "true" : "false");
		return isAnagram;		
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
	
	public static long countCharOccurrence(String s, char c) {
		long count = 0;
		count = s.chars().filter(ch -> ch == c).count();		
		return count;
	}
	
}
