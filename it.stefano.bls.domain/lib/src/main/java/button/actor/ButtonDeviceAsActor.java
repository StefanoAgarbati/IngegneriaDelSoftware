package button.actor;

import button.ButtonFactory;
import interf.IButtonDevice;
import mactor.impl.MActor;
import mactor.impl.MActorMessage;
import observable.IObserver;

public class ButtonDeviceAsActor extends MActor {

	private IButtonDevice device;
	private IObserver buttonObserver;
	
	public ButtonDeviceAsActor(String name, String buttonType) {
		super(name);
		buttonObserver = new ButtonObserver(this);
		device = ButtonFactory.createButtonDevice(buttonType);
		device.addObserver(buttonObserver);
	}

	@Override
	protected void processMsg(MActorMessage msg) {
	}

}
