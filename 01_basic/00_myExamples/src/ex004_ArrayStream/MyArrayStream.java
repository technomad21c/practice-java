package ex004_ArrayStream;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MyArrayStream {
    enum Mobile {
        Samsung(400), Nokia(250), Motorola(325);

        int price;

        Mobile(int p) {
            price = p;
        }

        int showPrice() {
            return price;
        }
    }

    public void run() {
        String[]  TmxExcodes = {"TMX", "CDX"};
        boolean result = Arrays.stream(TmxExcodes).anyMatch("TMX"::contains);
        System.out.println("Result: " + result);

        System.out.println("Mobile List: ");
        for (Mobile m : Mobile.values()) {
            System.out.println(m + " costs " + m.showPrice() + " dollars");
        }

        Mobile ret;
        ret = Mobile.valueOf("Samsung");
        System.out.println("selected: " + ret);


        String symbol = "IIPR:NYE";
        if (symbol.startsWith("IIPR")) {
            System.out.println("***");
        }

        char ch = 'Y';
        if (ch == 'Y') {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }

        List<Integer> list= new LinkedList<>();
        System.out.println("List of odd numbers in our list.");
        for (int i=1;i<=10;i++) {
            list.add(i);
        }

        Integer[] b =  list.toArray(new Integer[0]);
        System.out.println("Size: " + b.length);
        for (int i = 0; i <b.length; i++) {
            System.out.println(b[i]+" ");
        }
    }
}
