abstract class Info {
    public abstract int getLevel();
}

class EmployeeInfo2 extends Info {
    public int rank;
    EmployeeInfo2(int rank) {this.rank = rank; }
    public int getLevel() {
        return this.rank;
    }
}

class Person2<T extends Info> {
    public T info;
    Person2(T info) { this.info = info; }
}

public class MyGeneric02 {
    public static void main(String[] ars) {
        Person2 pi = new Person2(new EmployeeInfo2(1));
//        Person2<String> p2 = new Person2<String>("부장");
    }
}
