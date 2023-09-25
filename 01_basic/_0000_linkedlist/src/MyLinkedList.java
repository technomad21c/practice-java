import java.util.*;

public class MyLinkedList {
	public static void main(String args[]) {
		LinkedList<String> link = new LinkedList<String>();
		
		link.add("A");
		link.add("B");
		link.addLast("C");
		link.addFirst("D");
		link.add(2, "E");
		
//		link.remove("B");
//		link.remove(3);
//		link.removeFirst();
//		System.out.println("Linked List: " + link);
		
		boolean status = link.contains("E");
		if (status)
			System.out.println("contains E");
		else
			System.out.println("not contain E");
		
		Object element = link.get(2);
		System.out.println("element 2nd: " + element);
		System.out.println("list: " + link);	
		link.set(2,  "Y");
		System.out.println("list: " + link);
		
	}
}
