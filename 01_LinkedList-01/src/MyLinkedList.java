//https://www.tutorialspoint.com/java/util/java_util_linkedlist.htm

import java.util.*;

public class MyLinkedList {
	public static void main(String args[]) {
		LinkedList<String> link = new LinkedList<String>();
		
		link.add("A");
		link.add("B");
		link.addLast("C");
		link.addFirst("D");
		link.add(2, "E");
		link.add("F");
		link.add("G");
		System.out.println("Linked List: " + link);
		
		link.remove("B");
		link.remove(3);
		link.removeFirst();
		link.removeLast();
		System.out.println("Linked List after deletion: " + link);
		
		boolean status = link.contains("E");
		if (status)
			System.out.println("Linked List contatins E");
		else
			System.out.println("Linked List does not contain E");
		
		int size = link.size();
		System.out.println("The size of Linked List is " + size);
			
		Object element = link.get(2); 
        System.out.println("Element returned by get() : " + element); 
        link.set(2, "Y"); 
        System.out.println("Linked list after change : " + link);       
	}
}
