import javax.swing.plaf.synth.SynthSeparatorUI;

public class MyStack<E> {
	private E[] stack = null;
	private int top = -1;

	public MyStack(int size) {
		stack = (E[]) new Object[size];
	}
	
	public E pop() {
		if (top < 0) {
			return null;			
		}
		else {
			return stack[top--];			
		}
	}
	
	public boolean push(E e) {
		if (top + 1 == stack.length ) {
			System.out.println("Stack overflow");
			return false;
		} else {
			stack[++top] = e;
			return true;
		}
	}
	
	public String toString() {
		if (top < 0) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<=top; i++) {
			sb.append(stack[i] + ",");
		}
		
		sb.setLength(sb.length()-1);
		return sb.toString();		
	}
	
	public static void main(String args[]) {
		MyStack<Integer> ms = new MyStack<>(10);
		ms.push(10);
		ms.push(20);
		ms.push(30);
		ms.push(40);
		ms.push(50);
		ms.push(60);
		ms.push(70);
		ms.push(80);
		ms.push(90);
		ms.push(200);
		
		
		System.out.println(ms);
		
//		System.out.println("popped data: " + ms.pop());
//		System.out.println("popped data: " + ms.pop());
		System.out.println(ms);
	}
}
