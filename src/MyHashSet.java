// src: https://opentutorials.org/module/516/6446

import java.util.HashSet;
import java.util.Iterator;

public class MyHashSet {
    public static void main(String[] args) {
        HashSet<Integer> A = new HashSet<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);

        HashSet<Integer> B = new HashSet<Integer>();
        B.add(3);
        B.add(4);
        B.add(5);

        HashSet<Integer> C = new HashSet<Integer>();
        C.add(1);
        C.add(2);

        System.out.println(A.containsAll(B));
        System.out.println(A.containsAll(C));

        System.out.println("A set members");
        Iterator i = A.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        System.out.println("A & B");
        A.retainAll(B);
        i = A.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        System.out.println("A - B");
        A.remove(B);
        i = A.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }


        System.out.println("A + B");
        A.addAll(B);
        i = A.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

    }
}
