package blSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import button.ButtonModel;
import control.BLController;
import interf.IButtonDevice;
import interf.IButtonModel;
import interf.ILed;
import interf.ILedDevice;
import interfaces.IBLController;
import led.LedModel;
import led.concrete.LedMock;

class BLLogicTest {

	private ILedDevice ledMock;
	private IButtonDeviceForTest buttonMock;
	private ILed logicalLed;
	private IButtonModel logicalButton;
	private IBLController control;
	
	@Test
	void buttonLedLogicTest() {
		createSystem();
		assertTrue(!ledMock.isOn()); // led is off
		
		buttonMock.press();
		assertTrue(ledMock.isOn()); // led is turned on
		
		buttonMock.press();
		buttonMock.press();
		assertTrue(ledMock.isOn()); // led stays on
		
		buttonMock.release();
		assertTrue(ledMock.isOn());
		
		buttonMock.press();
		assertTrue(!ledMock.isOn()); //led is turned off
		
		buttonMock.press();
		assertTrue(!ledMock.isOn()); //led remains off
		
		buttonMock.release();
		assertTrue(!ledMock.isOn()); 
	}
	
	private void createSystem() {
		ledMock = new LedMock();
		buttonMock = new ButtonDeviceForTest();
		logicalButton = new ButtonModel();
		logicalLed = new LedModel(ledMock);
		control = new BLController(logicalLed);
		
		logicalButton.addObserver(control);
		buttonMock.addObserver(logicalButton);
	}

}
