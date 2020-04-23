package myfibonacci;

public class MyFibonacci {
	public static void main(String[] args) {
		int n = 10;
		
		fibonacci(n);
	}
	
	static void fibonacci(int n) {	
		if (n < 1) {
			System.out.printf("%d, ", 0);
		} else if (n < 2) {
			System.out.printf("%d, %d", 0, 1);
		} else {
			System.out.printf("%d, %d", 0, 1);
			int prev1 = 0;
			int prev2 = 1;
			int val   = 0;
			for (int i = 0; i <= n; i++) {
				val   = prev1 + prev2;
				System.out.printf(", %d", val);
				prev1 = prev2;
				prev2 = val;
				
			}
			
		}
	}
}
