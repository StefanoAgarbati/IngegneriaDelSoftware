package led;

import interf.ILedObservable;
import observable.GenericObservable;

public class LedObservable extends GenericObservable implements ILedObservable {
	
	private boolean state = false;
	
	@Override
	public void on() {
		state = true;
		updateObservers("on");
	}

	@Override
	public void off() {
		state = false;
		updateObservers("off");
	}

	@Override
	public boolean isOn() {
		return state;
	}

}
