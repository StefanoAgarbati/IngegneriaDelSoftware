package control.fsm;

import interf.ILed;

public class Son1State extends BLControllerState {

	public Son1State(ILed led) {
		super(led);
	}

	@Override
	public void update(String input) {
		if(input.equals("pressed"))
			turnOffLed();
	}

}
