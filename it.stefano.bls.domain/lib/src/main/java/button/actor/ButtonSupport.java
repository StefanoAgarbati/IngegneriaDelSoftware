package button.actor;

import button.ButtonFactory;
import interf.IButtonDevice;
import mactor.impl.MActor;
import observable.IObserver;
import utils.ConfigReader;

public class ButtonSupport {
	
	private IButtonDevice device;
	private IObserver buttonObserver;
	
	protected ButtonSupport(MActor actor, String config) {
		ConfigReader reader = new ConfigReader(config);
		device = ButtonFactory.createButtonDevice(reader.getString("type"));
		buttonObserver = new ButtonObserver(actor);
		device.addObserver(buttonObserver);
	}
	public static ButtonSupport create(MActor actor, String config) {
		return new ButtonSupport(actor, config);
	}

}
