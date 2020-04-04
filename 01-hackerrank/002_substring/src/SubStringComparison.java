import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class SubStringComparison {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		int k = scan.nextInt();
		
		SortedSet<String> sets = new TreeSet<String>();
		for (int i = 0; i <= str.length() - k; i++) {
			sets.add(str.substring(i, i+k));			
		}
		
		List<String> list = new ArrayList<String>();
//		list.addAll(sets);
//		System.out.println("List: " + list);
		System.out.println(sets.first());
		System.out.println(sets.last());
	}
}
