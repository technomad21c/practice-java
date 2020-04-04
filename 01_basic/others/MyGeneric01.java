// src: https://opentutorials.org/module/516/6237


class EmployeeInfo {
    public int rank;
    EmployeeInfo(int rank) { this.rank = rank; }
}

class Person<T, S> {
    public T info;
    public S id;

    Person(T info, S id) {
        this.info = info;
        this.id = id;
    }
}


public class MyGeneric01 {
    public static void main(String[] arsgs) {
        EmployeeInfo e = new EmployeeInfo(1);
        Integer i = new Integer(10);
//        Person<EmployeeInfo, Integer> p1 = new Person<EmployeeInfo, Integer>(e, i);
        Person<EmployeeInfo, Integer> p1 = new Person<>(e, i);
//        Person p1 = new Person(e, i);
        System.out.println(p1.id.intValue());

    }
}
