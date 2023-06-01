package button.actor;

import mactor.impl.MActor;
import mactor.impl.MActorMessage;


public class ButtonActor extends MActor {

	
	public ButtonActor(String name) {
		super(name);
		ButtonSupport support = new ButtonSupport(this, "ButtonConfig.json");
	}

	@Override
	protected void processMsg(MActorMessage msg) {
	}

}
