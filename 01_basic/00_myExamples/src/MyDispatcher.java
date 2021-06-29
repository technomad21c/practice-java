import ex001_flatmap.OptionalFilter;
import ex002_optional.MyOptional;
import ex004_ArrayStream.MyArrayStream;
import ex005_Reflection.PersonReflection;
import ex006_Pattern.MyPattern;
import ex007_Thread.MyExecutor;
import ex007_Thread.MyRunnable;
import ex008_ObjectMemberNullChecking.ex008_ObjectMemberNullChecking.MyObjectNull;
import ex009_Logging.MyLogging;
import ex010_StringConversion.StringConversion;
import ex011_Json_Jackson.JacksonJson;
import ex101_DesignPattern_Adapter.ex101_DesignPattern_Adapter.MyAdaptorPattern;


public class MyDispatcher {
    public static void main(String[] args) {
        try {
            switch (11) {
                case 11:
                    JacksonJson jj = new JacksonJson();
                    jj.run();
                    break;
                case 101:
                    MyAdaptorPattern map101 = new MyAdaptorPattern();
                    map101.run();
                    break;
                case 10:
                    StringConversion sc = new StringConversion();
                    sc.run();
                    break;
                case 9:
                    MyLogging ml009 = new MyLogging();
                    ml009.run();
                    break;
                case 7:
                    MyObjectNull mon = new MyObjectNull();
                    mon.run();
                    break;

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
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
