// src: https://faith-developer.tistory.com/147
// src: https://backback.tistory.com/m/161  ( DI on Spring framework)
package MyDependencyInjection02;

public class CoffeeMaker {
    private final Heater heater;
    private final Pump pump;

    public CoffeeMaker(Heater heater, Pump pump) {
        this.heater = heater;
        this.pump = pump;
    }

    public void brew() {
        heater.on();
        pump.pump();
        System.out.println("===== coffee... =====");
        heater.off();
    }
}
