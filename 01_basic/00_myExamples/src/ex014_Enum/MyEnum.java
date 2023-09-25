package ex014_Enum;

public class MyEnum {
    public void run() {
        ListStatus status = ListStatus.parseEdi("L");
        System.out.println("Status: " + ListStatus.toString(status));
    }
}
