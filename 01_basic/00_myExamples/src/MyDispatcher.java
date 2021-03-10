import ex001_flatmap.OptionalFilter;
import ex002_optional.MyOptional;
import ex004_ArrayStream.MyArrayStream;
import ex005_Reflection.PersonReflection;
import ex006_Pattern.MyPattern;
import ex007_Thread.MyExecutor;
import ex007_Thread.MyRunnable;

public class MyDispatcher {
    public static void main(String[] args) {
        int exampleId = 6;

        switch (exampleId) {
            case 6:
                MyExecutor me = new MyExecutor();
                me.run();
                MyRunnable mr = new MyRunnable();
                mr.run();
                break;
            case 5:
                MyPattern mp = new MyPattern();
                mp.run();
                break;
            case 4:
                PersonReflection pr = new PersonReflection();
                pr.run();
                break;
            case 3:
                MyArrayStream mas = new MyArrayStream();
                mas.run();
                break;
            case 2:
                MyOptional mo = new MyOptional();
                mo.run();
                break;
            case 1:
                OptionalFilter optFilter = new OptionalFilter();
                optFilter.run();
                break;
            default:
        }
    }
}
