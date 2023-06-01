package control;

import mactor.impl.MActor;
import mactor.impl.MActorMessage;

public class BLControllerActor extends MActor {
	
	private ControlSupport support;
	private String evName;
	
	public BLControllerActor(String name) {
		super(name);
		support = ControlSupport.create(this, "ControlConfig.json");
		evName = support.getEvName();
		System.out.println("BLControllerActor | created ");
	}

	@Override
	protected void processMsg(MActorMessage msg) {
		System.out.println("BLControllerActor | received msg " + msg.getName());
		System.out.println("BLControllerActor | received msg from" + msg.getSender());
		System.out.println("BLControllerActor | received msg body" + msg.getMsg());
		switch(msg.getName()) {
		case "buttonEv":
			support.update(msg.getMsg());
			break;
		}
	}

}
