import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegularExpressionSyntaxChecker {
	public static void main(String[] arg) {
		Scanner scan = new Scanner(System.in);
		int num = Integer.valueOf(scan.nextLine());		
		
		while (num-- > 0) {
			String syntax = scan.nextLine();
			try {
				Pattern pattern = Pattern.compile(syntax);
				System.out.println("Valid");
			} catch(PatternSyntaxException exception) {
				System.out.println("Invalid");
			}
		}
		
		scan.close();
	}
}
