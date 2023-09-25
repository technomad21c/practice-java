package ex012_HashMapStream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class HashMapStream {
    public void run() {
        // nest hashmap
        Map<String, Map<String, String>> excodeFunds = new HashMap<>();
        excodeFunds.computeIfAbsent("NYE", k -> new HashMap<String, String>()).put("URB:NSD", "URB:NSD Funds Data");
        excodeFunds.computeIfAbsent("NYE", k -> new HashMap<String, String>()).put("URB:NYE", "URB:NYE Funds Data");

        String symbol = "URB:NSD";
        String xcd = "NYE";
        System.out.println("*** Fund data: " + excodeFunds.get(xcd).get(symbol));
        if (excodeFunds.containsKey(xcd)) {
            System.out.println("*** Fund data: " + excodeFunds.get(xcd).get(symbol));
            List<String> t = excodeFunds.get(xcd).entrySet().stream()
                    .filter(e -> e.getKey().equals(symbol))
                    .map(Map.Entry::getValue)
//                    .findFirst();
                    .collect(Collectors.toList());

            System.out.println("***: " + t.get(0));

            Optional<List<String>> symFunds = Optional.ofNullable(excodeFunds.get(xcd).entrySet().stream()
                    .filter(e -> e.getKey().equals(symbol))
                    .map(e -> e.getValue())
                    .collect(Collectors.toList()));

            if (symFunds.isPresent()) {
                System.out.println("symbol filtered by excode: " + symFunds.get().get(0));
            }
        }
    }
}
