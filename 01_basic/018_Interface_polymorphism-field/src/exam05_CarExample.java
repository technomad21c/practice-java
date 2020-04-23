//https://m.blog.naver.com/PostView.nhn?blogId=mals93&logNo=220716656982&proxyReferer=https:%2F%2Fwww.google.com%2F

public class exam05_CarExample {
	public static void main(String[] args) {
		exam04_Car myCar = new exam04_Car();
		myCar.run();
		
		myCar.frontLeft = new exam03_KumhoTire();
		myCar.backRight = new exam03_KumhoTire();
		
		myCar.run();
	}
}
