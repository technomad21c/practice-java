package MyDependencyInjection02;

public class A_Pump implements Pump {
    private final Heater heater;

    public A_Pump(Heater heater) {
        this.heater = heater;
    }

    public void pump() {
        if (heater.isHot()) {
            System.out.println("A_Pump => pumping");
        }
    }
    
}
