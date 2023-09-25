package _00100_sorting_comparable;

public class Employee implements Comparable<Employee> {
	private String name;
	private String id;
	private int salary;	
	
	public Employee(String name, String id, int salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}	
	@Override
//	public int compareTo(Employee emp) {
//		return this.salary - emp.salary;
//	}
	public int compareTo(Employee emp) {
		return this.name.compareTo(emp.name);
	}
	@Override
	public String toString() {		
		return "[" + this.name + ", " + this.id + ", " + this.salary + "]";
	}
}
