package control.fsm1;

import interf.ILed;

public class TurnOnAction implements IStateAction {

	private ILed led;
	
	public TurnOnAction(ILed aLed) {
		this.led = aLed;
	}
	
	@Override
	public void execute() {
		led.on();
	}

}
