package MySortingMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class MyStringMap {
	private static Map<String, Map<String, VisitCount>> allVisitMap = new HashMap();
//	static int count;
	
	public static void main(String[] args) {
		initialize();
//		allVisitMap.forEach( (k, v) -> {
//			v.forEach((i, j) -> {
//				System.out.println("service: " + k + ", " + "user: " + i + ", visits: " + j.getCount());
//			});
//		});
		String userName = "a";
		AtomicReference<Integer> count = new AtomicReference<>();  // https://stackoverflow.com/questions/30026824/modifying-local-variable-from-inside-lambda/30039206#30039206
		count.set(0);
		
		allVisitMap.entrySet().forEach(e -> {
			Map<String, VisitCount> r = e.getValue().entrySet().stream().filter(t -> t.getKey().equals(userName)).collect(Collectors.toMap(k -> k.getKey(), v->v.getValue()));			
			r.forEach((k, v) -> count.set(count.get() + v.getCount()));
		});

		System.out.println("Count: " + count.get());
		
		String serviceName = "service-1";
		Map<String, Map<String, VisitCount>> results = allVisitMap.entrySet().stream().filter(e -> e.getKey().equals(serviceName)).collect(Collectors.toMap(e -> e.getKey(), v -> v.getValue()));		 
		results.forEach( (k, v) -> {
			v.forEach((i, j) -> {
				System.out.println("service: " + k + ", " + "user: " + i + ", visits: " + j.getCount());
			});
		});
		
//		Map<String, Map<String, VisitCount>> ret = allVisitMap.entrySet().stream().filter(e -> ((Entry<String, Map<String, VisitCount>>) e.getValue()).getKey().equals(serviceName)).collect(Collectors.toMap(e -> e.getKey(), v -> v.getValue()));
		
		
//		for (Map.Entry<String, Map<String, VisitCount>> e : results.entrySet()) {
//			System.out.println(e.getKey());
//		}
		
	}
	
	public static void initialize() {
		Map<String, VisitCount> visitMap = new HashMap();
		String user = "a";
		VisitCount v = new VisitCount.Builder(10).build();
		visitMap.put(user, v);
		user = "b";
		v = new VisitCount.Builder(15).build();
		visitMap.put(user,  v);
		user = "c";
		v = new VisitCount.Builder(20).build();
		visitMap.put(user,  v);		
		
		allVisitMap.put("service-1", visitMap);		
		
		visitMap = new HashMap();
		user = "a";
		v = new VisitCount.Builder(3).build();
		visitMap.put(user, v);		
		user = "c";
		v = new VisitCount.Builder(7).build();
		visitMap.put(user,  v);		
		
		allVisitMap.put("service-2", visitMap);		
	}
}
