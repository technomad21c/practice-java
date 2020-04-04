import java.util.Stack;

public class StackClassExample {
	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		
		s.push("Jack");
		s.push("Queen");
		s.push("King");
		s.push("Ace");
		
		System.out.println("Stack => " + s);
		System.out.println();
		
		String top = s.pop();
		System.out.println("Stack Pop: " + top);
		System.out.println("Stack => " + s);
		
		top = s.peek();
		System.out.println("Stack Peek: " + top);
		System.out.println("Stack => " + s);		
	}
}
