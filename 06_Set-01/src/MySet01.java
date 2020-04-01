//https://www.geeksforgeeks.org/set-in-java/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MySet01 {
	public static void main(String[] args) {
		Set<String> hashSet = new HashSet<>();
		hashSet.add("Geeks");
		hashSet.add("For");
		hashSet.add("Geeks");
		hashSet.add("Example");
		hashSet.add("Set");
		System.out.println("Set: " + hashSet);

		// sorting using TreeSet
		Set<String> treeSet = new TreeSet<>(hashSet);
		treeSet.add("Jeong");
		System.out.println(treeSet);
		
		System.out.println("---------------------------");
				
		Set<Integer> a = new HashSet<>();
		a.addAll(Arrays.asList(new Integer[] {1,3,2,4,8,9,0}));
		Set<Integer> b = new HashSet<>();
		b.addAll(Arrays.asList(new Integer[] {1,3,7,5,4,0,7,5}));
		
		Set<Integer> union = new HashSet<>(a);
		union.addAll(b);
		System.out.println("Set Uniion " + union);
		
		Set<Integer> intersection = new HashSet<>(a);
		intersection.retainAll(b);
		System.out.println("Set Intersection " + intersection);
		
		Set<Integer> difference = new HashSet<>(a);
		difference.removeAll(b);
		System.out.println("Set Difference " + difference);
		
	}
}
