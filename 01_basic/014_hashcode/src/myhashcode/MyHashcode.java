package myhashcode;

import java.util.HashMap;
import java.util.Map;

public class MyHashcode {
	public static void main(String[] args) {
		Nesoy p1 = new Nesoy();
		p1.setAge(20);
		p1.setName("John");
		
		Nesoy p2 = new Nesoy();
		p2.setAge(20);
		p2.setName("John");
		
		System.out.println(p1.equals(p2));
		
		Map<Nesoy, Integer> map = new HashMap<Nesoy, Integer>();
		map.put(p1,  1);
		map.put(p2,  1);
		System.out.println(map.size());
	}
}
