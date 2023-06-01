package blSystem;

import button.ButtonFactory;
import control.BLController;
import interf.IButtonDevice;
import interf.IButtonModel;
import interf.ILed;
import interf.ILedDevice;
import interfaces.IBLController;
import led.LedFactory;

public class MainBLSystem {

	private IButtonModel button;
	private ILed led;
	private IBLController control;
	private IButtonDevice concreteButton;
	private ILedDevice concreteLed;
	
	public void startTheSystem(String config) {
		if(config == null)
			BLSystemConfig.setConfiguration();
		else
			BLSystemConfig.setConfiguration(config);
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

	private ILedDevice createConcreteLed() {
		return LedFactory.createLedDevice(BLSystemConfig.ledType);
	}

	private IButtonDevice createConcreteButton() {
		return ButtonFactory.createButtonDevice(BLSystemConfig.buttonType);
	}

	private void connectComponents() {
		concreteButton.addObserver(button);
		button.addObserver(control);
	}
	
	public static void main(String[] args) {
		new MainBLSystem().startTheSystem(null);
	}
}
