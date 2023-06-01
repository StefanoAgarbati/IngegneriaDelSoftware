package button.actor;


import button.ButtonFactory;
import interf.IButtonDevice;
import mactor.impl.MActor;
import mactor.impl.MActorMessage;
import observable.IObserver;

public class ButtonAsActor extends MActor{

	private boolean state = false;
	private IButtonDevice device;
	private IObserver buttonObserver;
	
	public ButtonAsActor(String name, String type) {
		super(name);
		buttonObserver = new ButtonObserver(this);
		device = ButtonFactory.createButtonDevice(type);
		device.addObserver(buttonObserver);
	}

	@Override
	protected void processMsg(MActorMessage msg) {
		
	}

}
