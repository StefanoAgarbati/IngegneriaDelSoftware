package led;

import interf.ILed;
import mactor.impl.MActor;


public class LedForActors implements ILed {

	private String ledActor;
	private MActor sender;
	private boolean state = false;
	
	public LedForActors(MActor senderActor, String ledActor) {
		this.ledActor = ledActor;
		this.sender = senderActor;
	}
	
	@Override
	public void on() {
		state = true;
		System.out.println("LedForActors | state " + state);
		sender.sendDispatch("on", sender.getName(), ledActor, "on");
		System.out.println("LedForActors | sendOn");
	}

	@Override
	public void off() {
		state = false;
		sender.sendDispatch("off", sender.getName(), ledActor, "off");
		System.out.println("LedForActors | sendOff");
	}

	@Override
	public boolean isOn() {
		return state;
	}

	

	
}
