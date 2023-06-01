package button.actor;

import mactor.impl.MActor;
import observable.GenericObserver;

public class ButtonObserver extends GenericObserver {

	private MActor button;
	
	public ButtonObserver(MActor button) {
		this.button = button;
	}
	
	@Override
	public void update(String data) {
		button.publish("buttonEv", data);
		System.out.println("ButtonObserver | event published | " + data);
	}

}
