import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-dequeue/problem

public class MyDeque {
	
	public static void main(String[] args) {
//		solution1();
		
//		solution by @readyready15728
//		https://www.hackerrank.com/challenges/java-dequeue/forum		
		solution2();
		
	}
	
	public static void solution2() {
		Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        
        int n = in.nextInt();
        int m = in.nextInt();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int input = in.nextInt();
            
            deque.add(input);
            set.add(input);
            
            if (deque.size() == m) {
                if (set.size() > max) max = set.size();
                int first = deque.remove();
                if (!deque.contains(first)) set.remove(first);
            }
        }
        
        System.out.println(max);
    }
	
	public static void solution1() {
		Scanner in = new Scanner(System.in);
	    Deque deque = new ArrayDeque<>();
	    int n = in.nextInt();
	    int m = in.nextInt();
	
	    for (int i = 0; i < n; i++) {
	        int num = in.nextInt();
	        deque.add(num);
	    }
	    
	    
	    
	    int uniqueNumbers = 0;
	    while (deque.size() >= m) {
	    	List<Integer> subarr = getSubArray(deque, m);
	    	System.out.println(subarr);
	    	int count = countUniqueNumber(subarr);
	    	System.out.println("count: " + count);
	    	if (count > uniqueNumbers) 
	    		uniqueNumbers = count;
	    	deque.pop();
	    }
	    System.out.println("unique number: " + uniqueNumbers);

	}
	public static int countUniqueNumber(List<Integer> arr) {		
				
		List<Integer> un = new ArrayList<>();
		
		for ( Integer i : arr ) {
			if (!un.contains(i))
				un.add(i);
		}
		
		return un.size();
	}
	public static List<Integer> getSubArray(Deque deque, int size) {
		List<Integer> subArray = new ArrayList<>();
		while (size-- > 0) {
			subArray.add((int)deque.poll());
		}		
		
		Collections.reverse(subArray);
		for (Integer i : subArray) {
			deque.addFirst(i);
		}
		
		return subArray;
	}
}
