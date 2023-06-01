package button.concrete;

import interf.IButtonDevice;
import observable.GenericObservable;

public class ButtonDevice extends GenericObservable implements IButtonDevice {

	private boolean state = false;
	
	protected void setState(boolean aState) {
		state = aState;
		updateObservers();
	}

	private void updateObservers() {
		String state = this.state ? "pressed" : "released";
		updateObservers(state);
	}

}
