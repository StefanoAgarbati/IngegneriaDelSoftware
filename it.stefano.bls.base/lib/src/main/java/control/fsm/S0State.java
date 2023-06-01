package control.fsm;

import interf.ILed;

public class S0State extends BLControllerState {

	public S0State(ILed led) {
		super(led);
	}

	@Override
	public void update(String input) {
		if(input.equals("pressed"))
			turnOnLed();
	}
	
}
