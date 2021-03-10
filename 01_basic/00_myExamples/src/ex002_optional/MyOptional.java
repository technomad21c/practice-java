package ex002_optional;

import java.util.*;

public class MyOptional {
    public void run() {
        String str = new String("math");
//        Optional<List<String>> subjects = Optional.ofNullable(new ArrayList<>( ));
        Optional<List<String>> subjects = Optional.ofNullable(null);

//        System.out.println(subjects.get().add(str));

//        for ( String sub : subjects.get()) {
//            System.out.println(sub);
//        }

        subjects.ifPresentOrElse(
                sub -> System.out.println(sub),
                () -> System.out.println("Noo")
        );

        Optional<List<String>> res = find("Korea");

        List<String> list = new LinkedList<String>(List.of("exchanges", "tsx", "symbols", "bb-ca"));
        list.remove(0);
        System.out.println(list);

        Map<String, String> symbols = new HashMap<>();
        symbols.put("1", "one");
        symbols.put("2", "two");
        symbols.put("3", "three");

        System.out.println(symbols.get("1"));

    }

    private Optional<List<String>> find(String country) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("Canada", new ArrayList(List.of("Ottawa", "Toronto")));

        return Optional.ofNullable(map.get("Korea"));
    }
}
