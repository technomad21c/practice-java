//https://howtodoinjava.com/java8/intstream-examples/
	
import java.util.Iterator;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyIntStream {
	public static void main(String[] args) {
		Iterator itr = IntStream.of(1,2,3).iterator();
		while (itr.hasNext()) { 
			System.out.println(itr.next());
		}
		
		IntStream str = IntStream.of(11, 22, 33, 44, 55);
		str.forEach(s -> System.out.println(s));
		
		List<Integer> ints = IntStream.of(1,2,3,4,5)
	            .boxed()
	            .collect(Collectors.toList());	          
		System.out.println(ints);
		
		itr = IntStream.range(0,5).iterator();
		while (itr.hasNext()) { 
			System.out.println(itr.next());
		}
		
		itr = IntStream.rangeClosed(0,5).iterator();
		while (itr.hasNext()) { 
			System.out.println(itr.next());
		}
		
		itr = IntStream.iterate(100, i -> i+3).limit(10).iterator();
		while (itr.hasNext()) { 
			System.out.println(itr.next());
		}
		
		str = IntStream.iterate(3, i -> i+3).limit(10);
		str.forEach(s -> System.out.println(s));
		
		IntStream stream = IntStream.generate(() 
	            -> { return (int)(Math.random() * 10000); });
		stream.limit(10).forEach(System.out::println); 
		
		
//		https://howtodoinjava.com/java8/java8-intpredicate/
		IntPredicate isOdd = argument -> argument % 2 == 1;
		 
        //1. Use predicate directly         
        System.out.println( isOdd.test(9) );    //true
        System.out.println( isOdd.test(10) );   //false
         
        //2. Use predicate in filters         
        stream = IntStream.range(1, 10);
        List<Integer> oddNumbers = stream.filter(isOdd)
                        .boxed()
                        .collect(Collectors.toList());         
        System.out.println(oddNumbers);
        
        
//        https://www.geeksforgeeks.org/intstream-nonematch-java-examples/
        // Creating an IntStream 
        stream = IntStream.of(3, 9, 12, 14);   
        // Check if no element of stream 
        // is divisible by 5 using 
        // IntStream noneMatch(Predicate predicate) 
        boolean answer = stream.noneMatch(num -> num % 5 == 0);  
        // Displaying the result 
        System.out.println(answer); 
		
		stream = IntStream.range(1, 100);
        List<Integer> primes = stream.filter(MyIntStream::isPrime)
                                    .boxed()
                                    .collect(Collectors.toList());         
        System.out.println(primes);
	}
	
	public static boolean isPrime(int i) 
    {
//		 noneMatch() returns true if none of the stream elements match the given predicate
        IntPredicate isDivisible = index -> i % index == 0;
        return i > 1 && IntStream.range(2, i).noneMatch(isDivisible);
    }
	
	public static boolean isP(int i) {
		IntPredicate isDivisible = index -> i % index == 0;
		return i > 0 && IntStream.range(2,  i).noneMatch(isDivisible);
	}
}
