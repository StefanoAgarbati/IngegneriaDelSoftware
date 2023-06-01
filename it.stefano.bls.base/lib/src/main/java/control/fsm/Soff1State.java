package control.fsm;

import interf.ILed;

public class Soff1State extends BLControllerState {

	public Soff1State(ILed led) {
		super(led);
	}

	@Override
	public void update(String input) {
		if(input.equals("pressed"))
			turnOnLed();
	}

}
