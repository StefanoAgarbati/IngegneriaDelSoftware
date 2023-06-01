package control.fsm2;

import interf.ILed;

public class BLFsmActions {
	
	private ILed led;
	
	public BLFsmActions(ILed aLed) {
		this.led = aLed;
	}
	public void execute(String action) {
		if(action.equals("on"))
			on();
		else if(action.equals("off"))
			off();
	}
	
	private void on() {
		led.on();
	}
	
	private void off() {
		led.off();
	}
}
