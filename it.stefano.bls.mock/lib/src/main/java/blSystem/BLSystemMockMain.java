package blSystem;

import button.ButtonFactory;
import button.ButtonType;
import control.BLController;
import control.IBLController;
import interf.IButtonDevice;
import interf.IButtonModel;
import interf.ILed;
import interf.ILedDevice;
import led.LedFactory;
import led.LedType;

public class BLSystemMockMain {
	private IButtonModel button;
	private ILed led;
	private IBLController control;
	private IButtonDevice concreteButton;
	private ILedDevice concreteLed;
	
	public void startTheSystem(String config) {
//		if(config == null)
//			BLSystemConfig.setConfiguration();
//		else
//			BLSystemConfig.setConfiguration(config);
		createComponents();
		connectComponents();
	}
	
	private void createComponents() {
		concreteButton = createConcreteButton();
		concreteLed = createConcreteLed();
		button = createLogicalButton();
		led = createLogicalLed(concreteLed);
		control = createControl(led);
		
	}
	
	private IBLController createControl(ILed led) {
		return new BLController(led);
	}

	private ILed createLogicalLed(ILedDevice ledDevice) {
		return LedFactory.createLogicalLed(ledDevice);
	}

	private IButtonModel createLogicalButton() {
		return ButtonFactory.createLogicalButton();
	}

	protected ILedDevice createConcreteLed() {
		return LedFactory.createLedDevice(LedType.MOCK);
	}

	protected IButtonDevice createConcreteButton() {
		return ButtonFactory.createButtonDevice(ButtonType.MOCK);
	}

	private void connectComponents() {
		button.addObserver(control);
		concreteButton.addObserver(button);
	}
	
	public static void main(String[] args) {
		new BLSystemMockMain().startTheSystem(null);
	}
}
