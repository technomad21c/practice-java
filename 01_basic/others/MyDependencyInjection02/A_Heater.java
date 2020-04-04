package MyDependencyInjection02;

public class A_Heater implements Heater {
    boolean heating;

    public void on() {
        System.out.println("A_Heater! heating... .. .");
        this.heating = true;
    }

    public void off() { this.heating = false; }

    public boolean isHot() { return heating; }
}
