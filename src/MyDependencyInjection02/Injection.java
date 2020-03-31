package MyDependencyInjection02;

public class Injection {
    public static Heater provideHeater() {
        return new A_Heater();
    }

    public static Pump providePump() {
        return new A_Pump(provideHeater());
    }

    public static CoffeeMaker provideCoffeeMaker() {
        return new CoffeeMaker(provideHeater(), providePump());
    }
}
