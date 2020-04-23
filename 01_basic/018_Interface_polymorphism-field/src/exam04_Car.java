
public class exam04_Car {
	exam01_Tire frontLeft = new exam02_HankookTire();
	exam01_Tire frontRight = new exam02_HankookTire();
	exam01_Tire backLeft = new exam02_HankookTire();
	exam01_Tire backRight = new exam02_HankookTire();
	
	void run() {
		frontLeft.roll();
		frontRight.roll();
		backLeft.roll();
		backRight.roll();
	}
}
