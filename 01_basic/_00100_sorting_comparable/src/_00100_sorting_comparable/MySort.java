package _00100_sorting_comparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MySort {
	public static void main(String[] args) {
		String[] s = {"Monday", "Tudesday", "Wednessday", "Thursday", "Friday", "Saturday", "Sunday"};
		Arrays.sort(s);
		System.out.println(Arrays.toString(s));
		int[] i = { 1, 4, 5, 7, 9};
		Arrays.sort(i);
		System.out.println(Arrays.toString(i));		
		
		List<Employee> emps = new ArrayList<> ();
		emps.add(new Employee("b", "0001", 90000));
		emps.add(new Employee("c", "0002", 90000));
		emps.add(new Employee("a", "0003", 90000));
		emps.add(new Employee("c", "0004", 70000));
		Collections.sort(emps);		
		System.out.println("Sorted List by name: " + emps);
		
		Collections.sort(emps, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				if (o1.getSalary() > o2.getSalary())
					return -1;
				else if (o1.getSalary() < o2.getSalary())
					return 1;
				
				return o1.getName().compareTo(o2.getName());
			}
		});
		System.out.println("Sorted List by salary: " + emps);		
		
		TreeMap<Employee, Integer> map = new TreeMap<>();
		map.put(new Employee("a", "0001", 80000), 30);
		map.put(new Employee("c", "0003", 70000), 40);
		map.put(new Employee("b", "0002", 90000), 50);		
		System.out.println("Sorted List by salary: " + map.toString());
		
		List<String> words = Arrays.asList("two", "one", "three", "four", "five");
		Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
		System.out.println("Sorted List by length: " + words.toString());
		
		List<String> lang = Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");
		List<String> sortedlang = lang.stream()
				.sorted()
				.collect(Collectors.toList());
		sortedlang = lang.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		
		sortedlang = lang.stream()
				.sorted(Comparator.comparing(String::length))
				.collect(Collectors.toList());
		
		sortedlang = lang.stream()
				.sorted((s1, s2) -> s2.length() - s1.length())
				.collect(Collectors.toList());
		System.out.println(sortedlang);
	}
}
