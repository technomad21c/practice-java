package ex101_DesignPattern_Adapter.ex101_DesignPattern_Adapter;

public class Socket {
    public Volt getVolt() {
        return new Volt(120);
    }
}
