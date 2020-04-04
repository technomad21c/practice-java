//https://www.hackerrank.com/challenges/java-string-reverse/problem?h_r=next-challenge&h_v=zen

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();
		
		char[] arrA = A.toCharArray();
		char[] reverse = new char[arrA.length];
		int j = 0;
		for (int i = arrA.length - 1; i > -1; i--) {
			reverse[j++] = arrA[i];			
		}		
		
		boolean palindrome = true;
		for (int i = 0; i < arrA.length; i++) {
			if (arrA[i] != reverse[i]) {
				palindrome = false;
				break;
			}
		}
		
		System.out.println("A: " + new String(arrA) + ", B: " + new String(reverse));
		if (palindrome == true) {			
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}	
		
//	 	solution by @avinash1991
		boolean flag=true;
	    for(int i=0;i<A.length()/2 && flag==true;i++)
	    {
	        if(Character.valueOf(A.charAt(i)).compareTo(Character.valueOf(A.charAt(A.length()-i-1)))!=0){               
	        	flag=false;            
	        }
	    }
	    System.out.println((flag==true ? "Yes" :"No"));
		
//		solution by @SeanRMunoz
		System.out.println(A.equalsIgnoreCase(new StringBuilder(A).reverse().toString()) ? "Yes" : "No");
		
	        
	}
}
