package ex011_Json_Jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// src: https://examples.javacodegeeks.com/jackson-annotation-examples/

public class JacksonJson {
    public void run() {
        String[] cn = {"C", "B", "A", "D", " "};
        String coi = null;
        switch (cn[4]) {
            case "U":
                coi = "US";
                break;
            case "C":
                coi = "CA";
                break;
            case "":
                coi = "null";
                break;
            default:
                coi = "default";
        }
        System.out.println("COI: " + coi);

        List<Department> depts = new ArrayList<>(
                List.of(new Department("Supply Chain 1", 12345),
                        new Department("Supply Chain 2", 23456),
                        new Department("Supply Chain 3", 34567)
                ));

        Map<String,  Department> mapDepts = Map.of(
                "SC1", new Department("Supply Chain 1", 12345),
                "SC2", new Department("Supply Chain 2", 23456),
                "SC3", new Department("Supply Chain 3", 34567));

        JsonUnwrappedExample jue = new JsonUnwrappedExample(mapDepts, depts);

        List<String> strings = new ArrayList<>();
        Optional<List<String>> optStrings = Optional.ofNullable(strings);
        if (optStrings.isEmpty() || optStrings.get().size() == 0) {
            System.out.println("Option is empty!");
        }

        try {
            System.out.println("***");
            String result = new ObjectMapper().writerWithDefaultPrettyPrinter()
                    .writeValueAsString(jue);
            System.out.println(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
