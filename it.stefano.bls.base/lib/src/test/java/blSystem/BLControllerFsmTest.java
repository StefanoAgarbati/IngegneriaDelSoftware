package blSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import control.fsm.BLControllerFsm;
import interf.ILed;
import interfaces.IBLController;
import led.LedModel;
import led.concrete.LedMock;

class BLControllerFsmTest {

	private IBLController controller;
	private ILed led;
	
	@BeforeEach
	void initController() {
		
	}
	
	@Test
	void testBLControllerFsmLogic() {
		
		led = new LedModel(new LedMock());
		controller = new control.fsm.BLControllerFsm(led);
		
		doControlLogic(controller);
	}
	
	@Test
	void testBLControllerFsm1Logic() {
		
		led = new LedModel(new LedMock());
		controller = new control.fsm1.BLControllerFsm(led);
		
		doControlLogic(controller);
	}
	
	@Test
	void testBLControllerFsm2Logic() {
		
		led = new LedModel(new LedMock());
		controller = new control.fsm2.BLControllerFsm(led);
		
		doControlLogic(controller);
	}
	
	private void doControlLogic(IBLController controller) {
		controller.update("pressed");
		assertTrue(led.isOn());
		controller.update("pressed");
		assertTrue(led.isOn());
		controller.update("released");
		assertTrue(led.isOn());
		controller.update("pressed");
		assertTrue(!led.isOn());
		controller.update("released");
		assertTrue(!led.isOn());
	}

}
