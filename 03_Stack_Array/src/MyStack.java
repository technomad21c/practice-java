
public class MyStack {
	private int top;
	private Integer[] stack;
	
	MyStack(int size) {		
		stack = new Integer[size];
		top = -1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean push(int data) {
		if (top + 1 == stack.length) {
			System.out.println("Stack overflow");
			return false;
		} else {
			top = top + 1;
			stack[top] = data;
			return true;
		}

	}
	
	public Integer pop() {
		Integer ret;
		
		if (top == -1) {
			System.out.println("Stack underflow");
			ret = -1;
		} else {
			ret = stack[top--];
		}
		
		return ret;		
	}
	
	public void display() {		
		for (int i = 0; i <= top; i++) {		
			System.out.println(stack[i] + ", ");
		}
	}
	
	public static void main(String args[]) {
		MyStack stack = new MyStack(10);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		
		stack.display();
		
		
	}
}
