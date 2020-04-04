// source: https://www.softwaretestinghelp.com/java-coding-interview-programs/

public class ReverseString {
	public static void main(String[] args) {
		String str = "Automation";
		StringBuilder str2 = new StringBuilder();
		str2.append(str);
		str2 = str2.reverse();
		System.out.println(str2);
		System.out.println("*******************");
		
		char chars[] = str.toCharArray();
		for (int i=chars.length-1; i>=0; i--) {
			System.out.print(chars[i]);
		}
	}
}
