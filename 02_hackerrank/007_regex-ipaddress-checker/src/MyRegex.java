import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-regex

public class MyRegex {
	public static void main(String[] arsg) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String IP = in.next();
			System.out.println(IP.matches(new IPADDRRegex().pattern));
		}
	}

}
