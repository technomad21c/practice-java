import java.util.Arrays;

public class SortingString {
	public static void main(String[] args) {
		String str = "geeksforgeeks";
		String sorted = sortString(str);
		System.out.println("Original: " + str);
		System.out.println("Sorted  : " + sorted);
		
		int[] list = {4, 6, 2, 90, 12, 34};
		System.out.println("Original: " + Arrays.toString(list));
		System.out.println("Sorted  : " + Arrays.toString(sortInt(list)));
		
	}
	
	public static String sortString(String s) {
		char[] temp = s.toCharArray();
		Arrays.sort(temp);
		
		return new String(temp);
	}

	public static int[] sortInt(int[] list) {	
		Arrays.sort(list);
		
		return list;
	}
	
}
