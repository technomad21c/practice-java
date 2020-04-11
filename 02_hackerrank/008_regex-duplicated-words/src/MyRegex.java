import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//https://www.hackerrank.com/challenges/duplicate-word/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
public class MyRegex {
	public static void main(String[] args) {
//		solution by @RodneyShag
//		String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
//		solution by @4godspeed
		String regex = "\\b([a-z]|[A-Z]+)(\\s+\\1\\b)+";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		
		Scanner in = new Scanner(System.in);
		int numSentences = Integer.parseInt(in.nextLine());
		
		DuplicatedWordsRegex myReg = new DuplicatedWordsRegex();
		myReg.setRegex(regex);
		
		while (numSentences-- > 0) {
			String input = in.nextLine();			
			System.out.println(myReg.returnWordswithoutDuplication(input));
		}
		
		in.close();	
	}
}
