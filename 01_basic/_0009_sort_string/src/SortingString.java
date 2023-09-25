import java.util.Arrays;

public class SortingString {
	public static void main(String[] args) {
		String str = "geeksforgeeks";
		String sorted = sortString(str);
		
		System.out.println("sorted string: " + sorted);
		
		int[] list = {4, 6, 2, 90, 12, 34};
		Arrays.sort(list);
		System.out.println("sorted int: " + Arrays.toString(list));
		String[] st = new String[] {"ab", "ac", "ad", "ba", "bb", "ca"};
		Arrays.sort(st);
		System.out.println("sorted string2: " + Arrays.toString(st));
	}
	
	public static String sortString(String s) {
		char[] temp = s.toCharArray();
		Arrays.sort(temp);
		
		return new  String(temp);
	}
}
