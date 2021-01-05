// https://www.tutorialspoint.com/Callback-using-Interfaces-in-Java
package mycallback;

interface ClickEventHandler {
	public void handleClick();
}

class ClickHandler implements ClickEventHandler {
	public void handleClick() {
		System.out.println("Clicked");
	}
}

class Button {
	public void onClick(ClickEventHandler clickHandler) {
		clickHandler.handleClick();
	}
}

public class CallbackInterface {
	public static void main(String[] args) {
		Button button = new Button();
		ClickHandler clickHandler = new ClickHandler();
		button.onClick(clickHandler);
		
		Button button1 = new Button();
		button1.onClick(new ClickEventHandler() {
			@Override
			public void handleClick() {
				System.out.println("Button Clicked");
			}
		});
	}
}
