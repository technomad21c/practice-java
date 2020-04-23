
class Driver {
	public void drive(Vehicle vehicle) {
		vehicle.run();
	}
}

interface Vehicle {
	public void run();
}

class Bus implements Vehicle {
	@Override
	public void run() {
		System.out.println("Bus is running");
	}
	
	public void checkFare() {
		System.out.println("check bus fare");
	}
}

class Texi implements Vehicle {
	@Override
	public void run() {
		System.out.println("Texi is running");
	}
}

public class DriverExample {
	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		Texi texi = new Texi();
		
		driver.drive(bus);
		driver.drive(texi);
		
		
		// type casting to object
		Vehicle vehicle = new Bus();
		vehicle.run();
		// vehicle.checkFare();  // error
		
		Bus bus2 = (Bus) vehicle;
		bus2.run();
		bus2.checkFare();
	}
}
