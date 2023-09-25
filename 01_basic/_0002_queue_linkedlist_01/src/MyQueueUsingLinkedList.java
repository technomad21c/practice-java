import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Stream;

public class MyQueueUsingLinkedList {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		for (int i=0; i<5; i++) {
			q.add(i);
		}
		
		System.out.println("queue: " + q);		
		int val = q.remove();
		System.out.println("val: " + val);		
		System.out.println(q);
		
		Stack<String> stack = new Stack<String>();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.pop();

		Stream stream = stack.stream();

		stream.forEach((element) -> {
		    System.out.println(element);  // print element
		});
	}
}
