package ex101_DesignPattern_Adapter.ex101_DesignPattern_Adapter;

public class SocketObjectAdapterImpl implements SocketAdapter {
    private Socket sock = new Socket();

    public Volt get120Volt() {
        return sock.getVolt();
    }

    public Volt get12Volt() {
        Volt v = sock.getVolt();
        return convertVolt(v, 10);
    }

    public Volt get3Volt() {
        Volt v = sock.getVolt();
        return convertVolt(v, 40);
    }

    public Volt convertVolt(Volt v, int i) {
        return new Volt(v.getVolts()/i);
    }

}
