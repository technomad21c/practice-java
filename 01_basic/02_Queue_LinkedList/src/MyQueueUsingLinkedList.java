//https://www.geeksforgeeks.org/queue-interface-java/

import java.util.Iterator;
import java.util.LinkedList; 
import java.util.Queue; 
  
public class MyQueueUsingLinkedList 
{ 
  public static void main(String[] args) 
  { 
    Queue<Integer> q = new LinkedList<>(); 
  
    // Adds elements {0, 1, 2, 3, 4} to queue 
    for (int i=0; i<5; i++) 
     q.add(i); 
  
    // Display contents of the queue. 
    System.out.println("Elements of queue-"+q); 
  
    // To remove the head of queue. 
    int removedele = q.remove();
       
    
    System.out.println("removed element-" + removedele); 
  
    System.out.println(q); 
  
    // To view the head of queue 
    int head = q.peek(); 
    System.out.println("head of queue-" + head); 
  
    // Rest all methods of collection interface, 
    // Like size and contains can be used with this 
    // implementation. 
    int size = q.size(); 
    System.out.println("Size of queue-" + size); 
    
    for (Integer i : q) {    	
    	System.out.println(i);
    }
    System.out.println(q);
    
// ================================================================    
//    https://www.geeksforgeeks.org/linked-list-in-java/
    
 // Creating object of class linked list 
    LinkedList<String> object = new LinkedList<String>(); 

    // Adding elements to the linked list 
    object.add("A"); 
    object.add("B"); 
    object.addLast("C"); 
    object.addFirst("D"); 
    object.add(2, "E"); 
    object.add("F"); 
    object.add("G"); 
    System.out.println("Linked list : " + object); 

    // Removing elements from the linked list 
//    object.remove("B"); 
//    object.remove(3);
    object.remove(); 
//    object.removeFirst(); 
//    object.removeLast(); 
    System.out.println("Linked list after deletion: " + object); 

    // Finding elements in the linked list 
    boolean status = object.contains("E"); 

    if(status) 
        System.out.println("List contains the element 'E' "); 
    else
        System.out.println("List doesn't contain the element 'E'"); 

    // Number of elements in the linked list 
    size = object.size(); 
    System.out.println("Size of linked list = " + size); 

    // Get and set elements from linked list 
    Object element1 = object.get(2); 
    System.out.println("Element returned by get() : " + element1); 
    object.set(2, "Y"); 
    System.out.println("Linked list after change : " + object); 
    
    
    
 // ================================================================    
//    http://tutorials.jenkov.com/java-collections/queue.html
    
    Queue queueA = new LinkedList();

    queueA.add("element 0");
    queueA.add("element 1");
    queueA.add("element 2");

    //access via Iterator
    Iterator iterator = queueA.iterator();
    while(iterator.hasNext()){
      String element11 = (String) iterator.next();
    }

    //access via new for-loop
    for(Object object1 : queueA) {
        String elementstr1 = (String) object1;
    }
    
    Object firstElement = queueA.element();
    firstElement = queueA.peek();
    
  } 
} 