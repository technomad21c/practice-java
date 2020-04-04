// src: https://nesoy.github.io/articles/2018-06/Java-equals-hashcode

package myhashcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyHashCode01 {

    public static void main(String[] args) {
        Nesoy p1 = new Nesoy();
        p1.setAge(27);
        p1.setName("Brandon");

        Nesoy p2 = new Nesoy();
        p2.setAge(27);
        p2.setName("Brandon");

        System.out.println(p1.equals(p2));

        Map<Nesoy, Integer> map = new HashMap<Nesoy, Integer>();
        map.put(p1, 1);
        map.put(p2, 1);
        System.out.println(map.size());

        Set set = map.entrySet();
        Iterator itr = set.iterator();
        while (itr.hasNext()) {
            Map.Entry entry = (Map.Entry) itr.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}