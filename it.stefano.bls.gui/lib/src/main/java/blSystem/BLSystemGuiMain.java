package blSystem;

import button.ButtonFactory;
import button.ButtonType;
import interf.IButtonDevice;
import interf.ILedDevice;
import led.LedFactory;
import led.LedType;

public class BLSystemGuiMain extends BLSystemMockMain {
	
	protected ILedDevice createConcreteLed() {
		return LedFactory.createLedDevice(LedType.GUI);
	}

	protected IButtonDevice createConcreteButton() {
		return ButtonFactory.createButtonDevice(ButtonType.GUI);
	}
	
	public static void main(String[] args) {
		new BLSystemGuiMain().startTheSystem(null);
	}
}
