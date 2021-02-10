import com.technomad.ex001_flatmap.OptionalFilter;

public class MyDispatcher {
    public static void main(String[] args) {
        int exampleId = 1;

        switch (exampleId) {
            case 1:
                OptionalFilter optFilter = new OptionalFilter();
                optFilter.run();
            default:
        }
    }
}
