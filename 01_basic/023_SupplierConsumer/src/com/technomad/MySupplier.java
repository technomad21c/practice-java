package com.technomad;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MySupplier {

    public static void main(String[] args) {
        Supplier<Person> supplier = () -> {
            return new Person("Kim", 20, "developer");
        };
        Person p = supplier.get();
        System.out.println("Person -- Name: " + p.getName());

        Developer obj = factory(Developer::new);
        System.out.println(obj);

        Developer obj2 = factory(() -> new Developer("Jeong"));
        System.out.println(obj2);

        Consumer<String> consumer = (arg) -> {
            System.out.println(arg + " from Consumer");
        };
        consumer.accept("Hey Consumer");

        Consumer<String> consumer2 = (arg) -> {
            System.out.println(arg + " from Consumer2");
        };
        consumer.andThen(consumer2).accept("Hey Consumer");

        Consumer<List<Integer>> modify = list ->
        {
            for (int i = 0; i < list.size(); i++)
                list.set(i, 2 * list.get(i));
        };

        Consumer<List<Integer>> dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));

        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);

        modify.accept(list);
        dispList.accept(list);
    }

    public static Developer factory(Supplier<? extends Developer> s) {
        Developer developer = s.get();
        if (developer.getName() == null || "".equals(developer.getName())) {
            developer.setName("default");
        }

        developer.setSalary(BigDecimal.ONE);
        developer.setStart(LocalDate.of(2021, 03, 31));

        return developer;
    }
}
