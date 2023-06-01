package blSystem;

import button.concrete.ButtonDevice;

public class ButtonDeviceForTest extends ButtonDevice implements IButtonDeviceForTest {

	@Override
	public void press() {
		super.setState(true);
	}

	@Override
	public void release() {
		super.setState(false);
	}

	

}
