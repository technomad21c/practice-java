package ex013_Stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class ListStream {
    public void run() throws IOException {
        // find max, ef: https://www.baeldung.com/java-collection-min-max
        Person alex = new Person("Alex", 23);
        Person john = new Person("John", 40);
        Person peter = new Person("Peter", 32);
        List<Person> people = Arrays.asList(alex, john, peter);

        Person oldest = people.stream()
                            .max(Comparator.comparing(Person::getAge))
                            .orElseThrow(NoSuchElementException::new);
        System.out.println("Oldest: " + oldest.getName() + " (" + oldest.getAge() + ")");

        // list to map
        List<Employee> employees = List.of(
                new Employee(1, "John", "Dev", Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant())),
                new Employee(2, "Smith", "Dev", Date.from(LocalDate.now().minusDays(10).atStartOfDay(ZoneId.systemDefault()).toInstant())),
                new Employee(3, "Ken", "CS", Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant())),
                new Employee(4, "Doe", "CS", Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant())),
                new Employee(5, "Kim", "Dev", Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant())),
                new Employee(6, "Jeong", "Dev", Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant())));

        employees.stream()
                .forEach(s -> System.out.println(s.getName()));

// ref: https://www.baeldung.com/java-groupingby-collector
        Map<String, List<Employee>> mapEmp = employees.stream()
                .collect(groupingBy(Employee::getDept));
        mapEmp.entrySet().forEach(s -> System.out.println("Key: " + s.getKey() + ", Value: " + s.getValue().size()));

        Map<Date, List<Employee>> dateEmp = employees.stream()
                .collect(groupingBy(Employee::getDate));
        dateEmp.entrySet().forEach(s -> System.out.println("Key: " + s.getKey() + ", Value: " + s.getValue().size()));

        Map<Date, List<Employee>> tempEmp = employees.stream()
                .collect(groupingBy(Employee::getDate));
        List<Employee> filterEmp = tempEmp.get(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .stream()
                .filter(s -> "CS".equals(s.getDept()))
                .collect(Collectors.toList());
        filterEmp.forEach(s -> System.out.println("Name: " + s.getName() + ", Dept: " + s.getDept() + ", Date: " + s.getDate()));

        // load a file
//        List<String> lines = Files.readAllLines(Paths.get("src/ex013_ListStream/Fundmaster_CA_etf_2021-07-09.txt"));
//        for (String line : lines) {
//            System.out.println(line);
//        }

//        File file = new File("C:\\Users\\IIoTUser\\02_Java\\practice-java\\01_basic\\00_myExamples\\src\\ex013_ListStream\\Fundmaster_CA_etf_2021-07-09.txt");
//        URL url = file.toURI().toURL();
//        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
//        String i;
//        while ((i = br.readLine()) != null)
//            System.out.println(i);
//        br.close();

        var fileName = "src\\ex013_ListStream\\Fundmaster_CA_etf_2021-07-09.txt";
        Files.lines(Paths.get(fileName)).map(e -> {
         String[] fields = e.split(",");
         return fields[0];
        }).filter(e -> {
            String[] s = e.split(":");
            return s[1].equals("KR");
        }).forEach(System.out::println);

        // filter list elements with stream
        String excode = "TSX";

        Symbol sym1 = new Symbol("BB:CA", "TSX ");
        Map<String, Symbol> mapSymbol = Map.of("BB:CA", sym1);

        ArrayList<Fund> funds = new ArrayList<>(
                List.of(new Fund("BB:CA", "BB Fund"),
                        new Fund("APPLE", "AP Fund"),
                        new Fund("GOOGL", "GL Fund")));

        List<ExpandedSymbol> eSymbols = funds.stream()
                                                  .map(fund -> {
                                                      if (fund.getSymbol().equals(sym1.getSymbol()))
                                                          return new ExpandedSymbol(sym1, fund);
                                                      else  return new ExpandedSymbol(null, fund); })
                                                  .collect(Collectors.toList());

        eSymbols.forEach(s ->
                System.out.println("Symbol: " + s.getSymbol().getSymbol() +
                        ", excode: " + s.getSymbol().getExcode() +
                        ", fund: " + s.getFund().getFund()));
    }

    class ExpandedSymbol {
        private Symbol symbol;
        private Fund fund;

        public ExpandedSymbol(Symbol symbol, Fund fund) {
            this.symbol = symbol;
            this.fund = fund;
        }

        public Symbol getSymbol() {
            return symbol;
        }

        public void setSymbol(Symbol symbol) {
            this.symbol = symbol;
        }

        public Fund getFund() {
            return fund;
        }

        public void setFund(Fund fund) {
            this.fund = fund;
        }
    }

    class Fund {
        private String symbol;
        private String fund;

        public Fund(String symbol, String fund) {
            this.symbol = symbol;
            this.fund = fund;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getFund() {
            return fund;
        }

        public void setFund(String fund) {
            this.fund = fund;
        }
    }

    class Symbol {
        private String symbol;
        private String excode;

        public Symbol(String symbol, String excode) {
            this.symbol = symbol;
            this.excode = excode;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getExcode() {
            return excode;
        }

        public void setExcode(String excode) {
            this.excode = excode;
        }
    }

    class Person {
        String name;
        Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
