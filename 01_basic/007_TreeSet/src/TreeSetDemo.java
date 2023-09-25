package src;

import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class TreeSetDemo {
	public static void main(String[] args) {
		TreeSet<Integer> ts1 = new TreeSet<>();
		ts1.add(14);
		ts1.add(8);
		ts1.add(200);
		ts1.add(48);
		ts1.add(7);
		ts1.add(124);
		
		System.out.println("TreeSet: " + ts1);
		System.out.println("The first element by first() is: " + ts1.last());
		System.out.println("TreeSet: " + ts1);		
		System.out.println("The first element by pollFirst() is: " + ts1.pollFirst());
		System.out.println("TreeSet: " + ts1);		
		System.out.println("The Last element by pollLast() is: " + ts1.pollLast());
		System.out.println("TreeSet: " + ts1);		
		System.out.println("The removed element by remove() is: " + ts1.remove(48));
		System.out.println("TreeSet: " + ts1);		
		
		System.out.println("----------");
		System.out.println("headSet()");
		ts1.add(14);
		ts1.add(8);
		ts1.add(200);
		ts1.add(48);
		ts1.add(7);
		ts1.add(124);
		System.out.println("TreeSet: " + ts1);
		TreeSet<Integer> headSet = new TreeSet<>();
		headSet = (TreeSet<Integer>)ts1.headSet(30);
		Iterator itr = headSet.iterator();
		System.out.println("The resultant value: " );
		while (itr.hasNext()) {
			System.out.println(itr.next() + " ");
		}
		
		System.out.println("----------");
		System.out.println("tailSet()");
		System.out.println("TreeSet: " + ts1);
		TreeSet<Integer> tailSet = new TreeSet<>();
		tailSet = (TreeSet<Integer>)ts1.tailSet(14);
		for (Integer item : tailSet) {
			System.out.println(item + " ");
		}
		
		System.out.println("----------");
		System.out.println("subSet()");
		System.out.println("TreeSet: " + ts1);
		TreeSet<Integer> subSet = new TreeSet<>();
		subSet = (TreeSet<Integer>) ts1.subSet(8,  124);		
		for (Integer item : subSet) {
			System.out.println(item + " ");
		}
		
	}
}
