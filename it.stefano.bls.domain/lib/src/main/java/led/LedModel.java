package led;

import interf.ILed;
import interf.ILedDevice;

public class LedModel implements ILed {

	private boolean state = false;
	private ILedDevice device;
	
	public LedModel(ILedDevice device) {
		setLedDevice(device);
	}
	@Override
	public void on() {
		state = true;
		device.on();
	}

	@Override
	public void off() {
		state = false;
		device.off();
	}

	@Override
	public boolean isOn() {
		return state;
	}
	
	private void setLedDevice(ILedDevice aLedDevice) {
		this.device = aLedDevice;
	}

}
