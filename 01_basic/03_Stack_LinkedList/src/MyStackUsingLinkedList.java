//https://www.geeksforgeeks.org/queue-interface-java/

 
import java.util.Queue; 
  
public class MyStackUsingLinkedList 
{ 
	private class Node {
		int data;
		Node next;
	}
	
	Node top;
	MyStackUsingLinkedList() {
		this.top = null;
	}
	
	public void push(int data) {
		Node newNode = new Node();
		
		if (newNode == null) {
			System.out.println("Heap Overflow");
			return;
		}
		
		newNode.data = data;
		newNode.next = top;
		top = newNode;
	}
	
	public boolean isEmpty() {
		return top == null; 
	}
	
	public int pop() {
		if (isEmpty() == true) {
			System.out.println("Stack underflow");
			return -1;
		} else {
			int ret = top.data;
			top = top.next;
			return ret;
		}
	}
		
	public int peek() {
		if (isEmpty() == true) {
			System.out.println("Stack underflow");
			return -1;
		} else {
			return top.data;
		}
	}
	
	public void display() {
		Node temp = top;
		if (isEmpty() == true) {
			System.out.println("Stack is emtpy()");
			return;
		} else {
			while (temp != null) {
				System.out.println("Node: " + temp.data);
				temp = temp.next;
			}
		}
	}
		
	public static void main(String args[]) {		 
		MyStackUsingLinkedList obj = new MyStackUsingLinkedList();
        
        obj.push(11); 
        obj.push(22); 
        obj.push(33); 
        obj.push(44); 
  
        obj.display(); 
        System.out.printf("\nTop element is %d\n", obj.peek()); 
     
        System.out.println("Popped Node: " + obj.pop()); 
        obj.pop();   
        obj.display();   
        System.out.printf("\nTop element is %d\n", obj.peek()); 
	}
  
} 