package control.fsm1;

import java.util.HashMap;
import java.util.Map;

import interf.ILed;

public abstract class BLControllerState implements IState {

	private ILed led;
	private Map<String, IState> transitions = new HashMap<>();
	
	public BLControllerState(ILed aLed) {
		this.led = aLed;
	}
	public void addTransition(String input, IState next) {
		transitions.put(input, next);
	}
	public IState getNextState(String input) {
		IState next = transitions.get(input);
		if(next != null)
			return next;
		return this;
	}
	protected void turnOnLed() {
		led.on();
	}
	protected void turnOffLed() {
		led.off();
	}

}
