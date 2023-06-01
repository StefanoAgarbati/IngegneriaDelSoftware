package led.concrete;

import interf.ILedDevice;

public abstract class LedDevice implements ILedDevice {

	private boolean state = false;
	
	@Override
	public void on() {
		setState(true);
		doOn();
	}

	protected abstract void doOn();

	@Override
	public void off() {
		setState(false);
		doOff();
	}

	protected abstract void doOff();

	@Override
	public boolean isOn() {
		return state;
	}
	
	private void setState(boolean aState) {
		this.state = aState;
	}

}
