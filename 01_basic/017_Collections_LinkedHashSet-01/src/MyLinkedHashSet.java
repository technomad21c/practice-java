import java.util.LinkedHashSet;

// https://www.geeksforgeeks.org/linkedhashset-in-java-with-examples/
// When iterating through a HashSet the order is unpredictable, 
// while a LinkedHashSet lets us iterate through the elements in the order in which they were inserted.

public class MyLinkedHashSet {
	public static void main(String[] args) {
		LinkedHashSet<String> linkedset = new LinkedHashSet<String>();
		linkedset.add("A");
		linkedset.add("B");
		linkedset.add("C");
		linkedset.add("D");
		
		linkedset.add("A"); // not added as A already exists
		linkedset.add("E");
		
		 System.out.println("Size of LinkedHashSet = " + 
                 linkedset.size());   
		 System.out.println("Original LinkedHashSet:" + linkedset);   
		 System.out.println("Removing D from LinkedHashSet: " + linkedset.remove("D"));   
		 System.out.println("Trying to Remove Z which is not "+ "present: " + linkedset.remove("Z"));   
		 System.out.println("Checking if A is present=" + linkedset.contains("A")); 
		 System.out.println("Updated LinkedHashSet: " + linkedset);
		 
		 for (String str : linkedset) {
			 System.out.println(str);
		 }
		 linkedset.forEach(str -> System.out.println(str));
	
		 
//		 https://www.javatpoint.com/java-linkedhashset
		 LinkedHashSet<Book> hs = new LinkedHashSet<Book>();
		 Book b1 = new Book.Builder(101, "Let us C")
				 .author("Yashwant KanetKar")
				 .publisher("BPB")
				 .quantity(8)
				 .build();
		 Book b2 = new Book.Builder(102, "Data Communications & Network")
				 .author("Forouzan")
				 .publisher("Mc Graw Hill")
				 .quantity(4)
				 .build();
		 Book b3 = new Book.Builder(103, "Operating System")
				 .author("Galvin")
				 .publisher("Wiley")
				 .quantity(6)
				 .build();
		 hs.add(b1);
		 hs.add(b2);
		 hs.add(b3);
		 
		 hs.forEach(b -> {
			 System.out.println(b.getId());
			 System.out.println(b.getName());
			 System.out.println(b.getAuthor());
			 System.out.println(b.getPublisher());
		 });
	}
}

