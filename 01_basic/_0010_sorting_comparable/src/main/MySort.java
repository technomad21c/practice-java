package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MySort {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Tom", 45, 80000));
		employees.add(new Employee("Sam", 56, 75000));
		employees.add(new Employee("Alex", 30, 120000));
		employees.add(new Employee("Peter", 25, 60000));
		
//		Collections.sort(employees);		
//		Collections.sort(employees, new EmployeeAgeComparator());
		Collections.sort(employees, new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getName().compareTo(e2.getName());
			}
		});
		System.out.println("sorted: " + employees);
		
		
	}
}
