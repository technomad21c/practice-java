package ex001_flatmap;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalFilter {
    public void run() {
        // https://www.javaprogramto.com/2020/05/java-filter-stream-of-optional.html
        List<Optional<String>> optionalList = Arrays.asList(
                Optional.of("hello"),
                Optional.empty(),
                Optional.of("world"),
                Optional.empty(),
                Optional.of("welcome to Java Programming")
        );

        List<String> nonEmptyValuesList = optionalList.stream()
                .filter(o -> o.isPresent())
                .map(Optional::get)
                .collect(Collectors.toList());

        System.out.println("Java 8 - filter");
        System.out.println(nonEmptyValuesList);

        List<String> nevl = optionalList.stream()
                .flatMap(optional -> optional.isPresent() ? Stream.of(optional.get()) : Stream.empty())
                .collect(Collectors.toList());
        System.out.println("Java 8 - flatMap");
        System.out.println(nevl);

        List<String> nevl2 = optionalList.stream()
                .flatMap(Optional::stream)
                .collect(Collectors.toList());

        System.out.println("Java 9 - filtermap with Optional::Stream");
        System.out.println(nonEmptyValuesList);
        System.out.println();

        // https://madplay.github.io/post/difference-between-map-and-flatmap-methods-in-java
        String[][] namesArray = new String[][] {
                {"kim", "taeng"}, {"mad", "play"},
                {"kim", "mad"}, {"taeng", "play"}};
        Set<String> namesWithFlatMap = Arrays.stream(namesArray)
                .flatMap(innerArray -> Arrays.stream(innerArray))
                .filter(name -> name.length() > 3)
                .collect(Collectors.toSet());
        System.out.println("Flatmap example");
        namesWithFlatMap.forEach(System.out::println);
        System.out.println();

        namesArray = new String[][]{
                {"kim", "taeng"}, {"mad", "play"}};

        Arrays.stream(namesArray)
                .flatMap(inner -> Arrays.stream(inner))
                .filter(name -> name.equals("taeng"))
                .forEach(System.out::println);
        Arrays.stream(namesArray)
                .map(inner -> Arrays.stream(inner))
                .forEach(names -> names.filter(name -> name.equals("taeng"))
                        .forEach(System.out::println));
        System.out.println("Map & Flatmap");
        namesWithFlatMap.forEach(System.out::println);
        System.out.println();

        Arrays.stream(namesArray)
                .flatMap(inner -> Arrays.stream(inner))
                .forEach(System.out::println);
        Arrays.stream(namesArray)
                .map(inner -> Arrays.stream(inner))
                .forEach(names -> names.forEach(System.out::println));

        System.out.println();
        System.out.println("Map Test");
        String[] names = new String[]{ "kim", "taeng", "mad", "play"};
        List<String> result = Arrays.stream(names)
                .flatMap(this::addNames)
                .collect(Collectors.toList());
        result.stream().forEach(System.out::println);

        System.out.println();
        System.out.println("Map Test 2");
        String[] names2 = new String[]{ "kim", "taeng", "mad", "play"};
        Stream<String> result2 = Arrays.stream(names2)
                .map(this::names)
                .flatMap(Optional::stream)
                .flatMap(m -> m.stream());


        result2.forEach(System.out::println);
    }

    private Optional<String> name(String name) {
        return Optional.of(new String(name + "1"));
    }
    private Optional<List<String>> names(String name) {
        return Optional.of(new ArrayList(List.of(name + "1", name + "2")));
    }
    Stream<String> addNames(String name) {
        if (name.equals("kim")) {
            return Arrays.stream(new String[] {"kim", "Jeong", "Choi", "Park", "Lee"});
        } else if(name.equals("mad")) {
            return Arrays.stream(new String[] {"mad", "crazy", "insane"});
        }
        return null;
    }
}
