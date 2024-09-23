package ex017_Predicate;

// https://www.geeksforgeeks.org/java-8-predicate-with-examples/

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MyPrediciate {

    public void run() {
        Predicate<Integer> lesserthan = i -> (i < 18);
        System.out.println(lesserthan.test(10));

        Predicate<Integer> greaterThanTen = (i) -> i > 10;
        Predicate<Integer> lowerThanTwenty = (i) -> i < 20;
        boolean result = greaterThanTen.and(lowerThanTwenty).test(15);
        System.out.println(result);

        boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15);
        System.out.println(result2);

        pred(8, (i) -> i > 7);

        Predicate<String> hasLengthOf10 = (i) -> i.length() > 10;
        Predicate<String> containsLetterA = p -> p.contains("A");
        String containA = "And";
        boolean outcome = hasLengthOf10.or(containsLetterA).test(containA);
        System.out.println(outcome);
        boolean outcome2 = hasLengthOf10.and(containsLetterA).test(containA);
        System.out.println(outcome2);

        List<User> users = new ArrayList<User>();
        users.add(new User("John", "admin"));
        users.add(new User("Jeong", "admin"));
        users.add(new User("Doe", "member"));
        List admins = process(users, (User u) -> u.getRole().equals("admin"));
        System.out.println("Admins: " + admins);

    }

    private void pred(int number, Predicate<Integer> predicate) {
        if (predicate.test(number)) {
            System.out.println("Number: " + number);
        }
    }

    class User {
        String name, role;
        User(String a, String b) {
            name = a;
            role = b;
        }
        String getRole() { return role; }
        String getName() { return name; }
        public String toString() {
            return "User Name : " + name + " with role :" + role;
        }
    }

    private List<User> process(List<User> users, Predicate<User> predicate) {
        List<User> result = new ArrayList<User>();
        for (User user: users) {
            if (predicate.test(user)) {
                result.add(user);
            }
        }

        return result;
    }



}
