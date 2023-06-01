package led.actor;

import interf.ILedDevice;
import led.LedFactory;
import led.LedType;
import mactor.impl.MActor;
import mactor.impl.MActorMessage;

public class LedAsActor extends MActor {
	private boolean state = false;
	private ILedDevice device;
	private String ledType = LedType.MOCK;
	
	public LedAsActor(String name, String ledType) {
		super(name);
		this.ledType = ledType;
		device = createLedDevice();
	}
	private ILedDevice createLedDevice() {
		return LedFactory.createLedDevice(ledType);
	}
	protected void processMsg(MActorMessage msg) {
		System.out.println("LedAsActor | message received " + msg.getName());
		switch(msg.getName()) {
		case "on": processOn(); break;
		case "off": processOff(); break;
		case "isOn": processIsOn(msg); break;
		}
	}

	private void processIsOn(MActorMessage msg) {
		if(state)
			sendReply("isOnReply", msg.getReceiver(), msg.getSender(), "true");
		else
			sendReply("isOnReply", msg.getReceiver(), msg.getSender(), "false");
	}

	private void setState(boolean aState) {
		this.state = aState;
	}
	
	private void processOff() {
		setState(false);
		device.off();
	}

	private void processOn() {
		setState(true);
		device.on();
	}
}
