// src: https://server-engineer.tistory.com/233

package myDependencyInjection01;

public class MyDriver {
    public static void main(String[] args) {
        Tire tire = new KoreaTire();
        Car car = new Car();
        car.setTire(tire);

        System.out.println(car.getTireBrand());
    }
}
