import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class MyLambda {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		System.out.print("input the number to find out prime: ");
//		int n = Integer.parseInt(br.readLine().trim());
		int n = 11;
		boolean b = IntStream.range(2, n).noneMatch(i -> n % i == 0);
		System.out.println(b);
		
		Stream<String> names = Arrays.asList("John", "Bob", "Doe", "Smith").stream();
		names.forEach(System.out::println);
		
		String[] names2 = new String[] {"Eric", "Elena", "Java"};
		List<String> names3= Arrays.asList(names2);
		Stream<String> stream1 = names3.stream();
		
		String[] arr = new String[] {"a", "b", "c"};
		Stream<String> stream3 = Arrays.stream(arr);
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
		
		Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5);
		IntStream intStream = IntStream.range(1,  5);
		LongStream longStream = LongStream.rangeClosed(1, 5);
		
		List<String> ls = Arrays.asList("Eric", "Elena", "Java");
		List<String> filterednames = ls.stream().
				map(String::toUpperCase).
				filter(name -> name.contains("E")).
				collect(Collectors.toList());
		
		IntStream.of(14, 11, 20, 39, 23)
			.sorted()
			.boxed()
			.collect(Collectors.toList());
		
		List<String> lang = Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");
		List<String> sortedlang = lang.stream()
				.sorted()
				.collect(Collectors.toList());
		sortedlang = lang.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		
		sortedlang = lang.stream()
				.sorted(Comparator.comparing(String::length).reversed().thenComparing(String::compareTo).reversed())
				.collect(Collectors.toList());
		System.out.println(sortedlang);
		
		sortedlang = lang.stream()
				.sorted((s1, s2) -> s2.length() - s1.length())
				.collect(Collectors.toList());
		

		List<Product> productlist = Arrays.asList(
				new Product(23, "potatoes"),
				new Product(14, "orange"),
                new Product(13, "lemon"),
                new Product(23, "bread"),
                new Product(13, "sugar"));
		List<String> productNames = productlist.stream().map(Product::getName).collect(Collectors.toList());
		
		String joinedname = productlist.stream()
				.map(Product::getName)
				.collect(Collectors.joining(" : ", "<", ">"));
		System.out.println(joinedname);
		
		Map<Integer, List<Product>> collectorMapOfLists =
				productlist.stream()
				.collect(Collectors.groupingBy(Product::getAmount));
		
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
	
