//https://devbox.tistory.com/entry/Java-%EC%A0%9C%EB%84%A4%EB%A6%AD
//https://cornswrold.tistory.com/180

package mygeneric;

class EmployeeInfo {
	public int rank;
	EmployeeInfo(int rank) {
		this.rank = rank;
	}
}

class Person<T, S> {
	public T info;
	public S id;
	
	Person(T info, S id) {
		this.info = info;
		this.id = id;
	}
	
	public <U> void printInfo(U info) {
		System.out.println(info);
	}
}

public class MyGenericDemo {
	public static void main(String[] args) {
		EmployeeInfo e = new EmployeeInfo(1);
		Integer i = new Integer(10);
		
		Person<EmployeeInfo, Integer> p1 = new Person<EmployeeInfo, Integer>(e, i);
		System.out.println(p1.id.intValue());
		
		p1.<EmployeeInfo>printInfo(e);
		p1.printInfo(e);
	}
}
