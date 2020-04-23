package practice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//https://www.codejava.net/java-core/collections/sorting-arrays-examples-with-comparable-and-comparator

public class SortingObjects {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Tom", 45, 80000));
		employees.add(new Employee("Sam", 56, 75000));
		employees.add(new Employee("Alex", 30, 120000));
		employees.add(new Employee("Peter", 25, 60000));
		
		
		System.out.println("Before sorting: " + employees);				
		Collections.sort(employees);
		System.out.println("After sorting : " + employees);
		
		Employee[] es = employees.toArray(new Employee[employees.size()]);
		System.out.println(Arrays.toString(es));
		
		System.out.println("sort using Comparator");
		System.out.println("Before sorting : " + employees);
		Collections.sort(employees, new EmployeeAgeComparator());
		System.out.println("After sorting : " + employees);		
		
		System.out.println("sort using Anonymous class");
		System.out.println("Before sorting : " + employees);
		Collections.sort(employees, new Comparator<Employee>() {
		    @Override
		    public int compare(Employee emp1, Employee emp2) {
		        return emp1.getName().compareTo(emp2.getName());
		    }
		});
		System.out.println("After sorting : " + employees);
		
		System.out.println("sort using lambda");
		System.out.println("Before sorting : " + employees);
		Collections.sort(employees, ((Employee e1, Employee e2) -> {
			return e1.getAge() - e2.getAge();
		}) );
		System.out.println("After sorting : " + employees);
	}
}
