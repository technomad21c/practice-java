import ex001_flatmap.OptionalFilter;
import ex002_optional.MyOptional;
import ex004_ArrayStream.MyArrayStream;
import ex005_Reflection.PersonReflection;
import ex006_Pattern.MyPattern;
import ex007_Thread.MyExecutor;
import ex007_Thread.MyRunnable;
import ex008_ObjectMemberNullChecking.MyObjectNull;
import ex101_DesignPattern_Adapter.MyAdaptorPattern;

public class MyDispatcher {
    public static void main(String[] args) {

        switch (101) {
            case 101:
                MyAdaptorPattern map101 = new MyAdaptorPattern();
                map101.run();
                break;

            case 007:
                MyObjectNull mon = new MyObjectNull();
                mon.run();
                break;

            case 006:
                MyExecutor me = new MyExecutor();
                me.run();
                MyRunnable mr = new MyRunnable();
                mr.run();
                break;

            case 005:
                MyPattern mp = new MyPattern();
                mp.run();
                break;

            case 004:
                PersonReflection pr = new PersonReflection();
                pr.run();
                break;

            case 003:
                MyArrayStream mas = new MyArrayStream();
                mas.run();
                break;

            case 002:
                MyOptional mo = new MyOptional();
                mo.run();
                break;

            case 001:
                OptionalFilter optFilter = new OptionalFilter();
                optFilter.run();
                break;

            default:
        }
    }
}
