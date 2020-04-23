//https://futurecreator.github.io/2018/08/26/java-8-streams/

package mystream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class MyStream {
	public static void main(String[] args) {
		Stream<String> names = Arrays.asList("John", "BoB", "Doe", "Smith").stream();
		names.forEach(System.out::println);
		
		String[] names2 = new String[]{"Eric", "Elena", "Java"};
		List<String> names3 = Arrays.asList(names2);		
		Stream<String> stream1 = names3.stream();			
		
		String[] arr = new String[]{"a", "b", "c"};
		Stream<String> stream3 = Arrays.stream(arr);
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
		
		Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5);
		
		IntStream intStream = IntStream.range(1, 5); // [1, 2, 3, 4]
		LongStream longStream = LongStream.rangeClosed(1, 5); // [1, 2, 3, 4, 5]		
		
		List<String> ls = Arrays.asList("Eric", "Elena", "Java");
		List<String> filterednames =  ls.stream().
				map(String::toUpperCase).
				filter(name -> name.contains("E")).
				collect(Collectors.toList());
		System.out.println(filterednames);
		
		IntStream.of(14, 11, 20, 39, 23)
		  .sorted()
		  .boxed()
		  .collect(Collectors.toList());
		// [11, 14, 20, 23, 39]
		
		//reverse sorting
		List<String> lang = Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");
		List<String> sortedlang = lang.stream()
			.sorted()
			.collect(Collectors.toList());
		System.out.println(sortedlang);
		System.out.println(lang);
		sortedlang = lang.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		System.out.println(sortedlang);
		
		// sorting by length
		sortedlang = lang.stream()
				.sorted(Comparator.comparing(String::length))
				.collect(Collectors.toList());
		System.out.println(sortedlang);
		sortedlang = lang.stream()
				.sorted((s1, s2) -> s2.length() - s1.length())
				.collect(Collectors.toList());
		System.out.println(sortedlang);
		sortedlang = lang.stream()
				.sorted((s1, s2) -> s2.length() - s1.length())
				.collect(Collectors.toList());
		System.out.println(sortedlang);		
		
		// collect
		List<Product> productList = 
				  Arrays.asList(new Product(23, "potatoes"),
				                new Product(14, "orange"),
				                new Product(13, "lemon"),
				                new Product(23, "bread"),
				                new Product(13, "sugar"));
		List<String> productNames = productList.stream()
				.map(Product::getName)
				.collect(Collectors.toList());
		System.out.println(productNames);
	
		// return string 
		String listToString = 
				 productList.stream()
				  .map(Product::getName)
				  .collect(Collectors.joining(" : ", "<", "]]"));
		System.out.println(listToString);
		
		// grouping
		Map<Integer, List<Product>> collectorMapOfLists =
				 productList.stream()
				  .collect(Collectors.groupingBy(Product::getAmount));
		System.out.println(collectorMapOfLists);
		
		// matching: anyMatch, allMatch, noneMatch
		List<String> names4 = Arrays.asList("Eric", "Elena", "Java");

		boolean anyMatch = names4.stream()
		  .anyMatch(name -> name.contains("a"));  // true
		boolean allMatch = names4.stream()
		  .allMatch(name -> name.length() > 3);  // true
		boolean noneMatch = names4.stream()
		  .noneMatch(name -> name.endsWith("s")); // true
	}
}


class Product {
	private int amount;
	private String name;
	
	Product(int amount, String name) {
		this.amount = amount;
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) { 
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}