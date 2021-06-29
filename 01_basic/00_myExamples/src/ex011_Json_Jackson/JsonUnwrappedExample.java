package ex011_Json_Jackson;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.util.List;


public class JsonUnwrappedExample {
    @JsonUnwrapped
    public List<Department> depts;


    public JsonUnwrappedExample(List<Department> depts) {
        this.depts = depts;
    }
}
