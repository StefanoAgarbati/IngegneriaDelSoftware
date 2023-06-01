package led.actor;

import mactor.impl.MActor;
import mactor.impl.MActorMessage;

public class LedActor extends MActor {
	
	private LedSupport support;
	
	public LedActor(String name) {
		super(name);
		support = LedSupport.create(this, "LedConfig.json");
	}
	protected void processMsg(MActorMessage msg) {
		System.out.println("LedActor | message received " + msg.getName());
		switch(msg.getName()) {
		case "on": processOn(); break;
		case "off": processOff(); break;
		case "isOn": processIsOn(msg); break;
		}
	}

	private void processIsOn(MActorMessage msg) {
		if(support.isOn())
			sendReply("isOnReply", msg.getReceiver(), msg.getSender(), "true");
		else
			sendReply("isOnReply", msg.getReceiver(), msg.getSender(), "false");
	}

	private void processOff() {
		support.off();
	}

	private void processOn() {
		support.on();
	}
}
