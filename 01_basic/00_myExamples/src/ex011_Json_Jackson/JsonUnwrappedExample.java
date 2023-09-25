package ex011_Json_Jackson;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.util.List;
import java.util.Map;

public class JsonUnwrappedExample {
    @JsonUnwrapped
    public Map<String, Department> mapDepts;

    @JsonUnwrapped
    public List<Department> depts;

    public Map<String, Department> getMapDepts() {
        return mapDepts;
    }

    public void setMapDepts(Map<String, Department> mapDepts) {
        this.mapDepts = mapDepts;
    }

    public List<Department> getDepts() {
        return depts;
    }

    public void setDepts(List<Department> depts) {
        this.depts = depts;
    }

    public JsonUnwrappedExample(Map<String, Department> mapDepts, List<Department> depts) {
        this.mapDepts = mapDepts;
        this.depts = depts;
    }
}
