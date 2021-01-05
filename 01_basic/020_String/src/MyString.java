
public class MyString {
    public static void main(String[] args) {
        String oldString = "Innovative Canada";
        int index = oldString.replace(' ', '.').indexOf('.');
        String newString = index > -1 ? oldString.substring(0, index) : oldString;
        System.out.println("result: " + newString);
    }
}
