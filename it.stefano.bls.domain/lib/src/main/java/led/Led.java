package led;

import interf.ILed;

public abstract class Led implements ILed {

	private boolean state = false;
	
	@Override
	public void on() {
		setState(true);
		doOn();
	}

	protected abstract void doOn();

	private void setState(boolean aState) {
		this.state = aState;
	}

	@Override
	public void off() {
		setState(true);
		doOff();
	}

	protected abstract void doOff();

	@Override
	public boolean isOn() {
		return state;
	}

}
