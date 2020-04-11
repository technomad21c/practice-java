//https://www.hackerrank.com/challenges/java-primality-test/problem

import java.math.BigInteger; 
import java.util.Scanner;

public class PrimeNumberChecker {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		
		boolean isPrime = false;
		if (isPrimeNumber(new BigInteger(input)))
			System.out.println("prime");
		else
			System.out.println("not prime");
	}
	
	static public boolean isPrimeNumber(BigInteger bi) {
		
		return bi.isProbablePrime(1);
	}
}
