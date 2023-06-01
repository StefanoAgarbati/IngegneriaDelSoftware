package control.fsm1;

import interf.ILed;

public class TurnOffAction implements IStateAction {

	private ILed led;
	
	public TurnOffAction(ILed aLed) {
		this.led = aLed;
	}
	
	@Override
	public void execute() {
		led.off();
	}

}
