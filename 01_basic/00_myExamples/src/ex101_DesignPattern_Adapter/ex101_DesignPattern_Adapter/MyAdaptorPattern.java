package ex101_DesignPattern_Adapter.ex101_DesignPattern_Adapter;
//https://blog.seotory.com/post/2017/09/java-adapter-pattern

public class MyAdaptorPattern {
    public void run() {
        SocketClassAdapterImpl sock = new SocketClassAdapterImpl();
        Volt v = sock.get120Volt();
        System.out.println("Volt : " + v.getVolts());

        v = sock.get3Volt();
        System.out.println("Volt : " + v.getVolts());
    }
}

