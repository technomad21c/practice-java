// source: https://www.softwaretestinghelp.com/java-coding-interview-programs/

import java.util.Scanner;

public class SwapTwoNumbers {
	public static void main(String args[]) {
		int x, y;
		System.out.print("Enter x and y");
		Scanner in = new Scanner(System.in);
		
		x = in.nextInt();
		y = in.nextInt();
		
		System.out.print("Before Swapping\nx = " + x + "\ny = " + y);
		
		x = x + y;
		y = x - y;
		x = x - y;
		
		System.out.println("After Swapping without third variable\nx = " + x + "\ny = "
		 + y);
	}
}
