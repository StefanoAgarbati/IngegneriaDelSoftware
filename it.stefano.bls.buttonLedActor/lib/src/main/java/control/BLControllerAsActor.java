package control;


import interf.ILed;
import interfaces.IBLController;
import led.LedForActors;
import mactor.impl.MActor;
import mactor.impl.MActorMessage;

public class BLControllerAsActor extends MActor {
	
	private String led;
	private IBLController control;
	
	public BLControllerAsActor(String name, String led) {
		super(name);
		this.led = led;
		this.subscribe("buttonEv");
		ILed ledForActors = new LedForActors(this, led);
		control = new BLController(ledForActors);
		System.out.println("BLControllerAsActor | created ");
	}

	@Override
	protected void processMsg(MActorMessage msg) {
		System.out.println("BLControllerAsActor | received msg " + msg.getName());
		System.out.println("BLControllerAsActor | received msg from" + msg.getSender());
		System.out.println("BLControllerAsActor | received msg body" + msg.getMsg());
		switch(msg.getName()) {
		case "buttonEv":
			control.update(msg.getMsg());
			break;
		}
	}

}
