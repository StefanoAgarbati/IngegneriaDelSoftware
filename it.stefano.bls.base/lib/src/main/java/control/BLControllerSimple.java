package control;

import interf.ILed;
import interfaces.IBLController;
import observable.GenericObserver;


public class BLControllerSimple extends GenericObserver implements IBLController {

	private ILed led;
	
	public BLControllerSimple(ILed led) {
		setLed(led);
	}
	
	private void setLed(ILed led) {
		this.led = led;
	}

	@Override
	public void update(String data) {
		if(data.equals("pressed")) {
			if(led.isOn())
				led.off();
			else
				led.on();
		}
	}

}
