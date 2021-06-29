package ex011_Json_Jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

// src: https://examples.javacodegeeks.com/jackson-annotation-examples/

public class JacksonJson {
    public void run() {
        List<Department> depts = new ArrayList<>(
                List.of(new Department("Supply Chain 1", 12345),
                        new Department("Supply Chain 2", 23456),
                        new Department("Supply Chain 3", 34567)
                ));
        JsonUnwrappedExample jue = new JsonUnwrappedExample(depts);
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
