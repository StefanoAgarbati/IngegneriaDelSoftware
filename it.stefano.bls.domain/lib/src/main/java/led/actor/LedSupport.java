package led.actor;

import interf.ILedDevice;
import led.LedFactory;
import mactor.impl.MActor;
import utils.ConfigReader;

public class LedSupport {

	private ILedDevice device;
	private MActor actor;
	private boolean state = false;
	
	public static LedSupport create(MActor actor, String config) {
		return new LedSupport(actor, config);
	}
	
	public LedSupport(MActor actor, String config) {
		ConfigReader reader = new ConfigReader(config);
		device = LedFactory.createLedDevice(reader.getString("type"));
		this.actor = actor;
	}
	
	private void setState(boolean aState) {
		this.state = aState;
	}
	public boolean isOn() {
		return state;
	}
	public void off() {
		setState(false);
		device.off();
	}

	public void on() {
		setState(true);
		device.on();
	}
}
