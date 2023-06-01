package blSystemLocal;

import blSystem.BLSystemConfig;
import button.ButtonType;
import button.actor.ButtonAsActor;
import control.BLControllerAsActor;
import led.LedType;
import led.actor.LedAsActor;
import mactor.impl.MActor;
import mactor.impl.MActorContext;

public class MainButtonLedLocalActorSystem {

	private MActor button;
	private MActor controller;
	private MActor led;
	
	private String buttonType = ButtonType.GUI;
	private String ledType = LedType.GUI;
	
	public void startTheSystem() {
		configure();
		createComponents();
		activateComponents();
	}
	
	private void createComponents() {
		MActorContext.initContext("buttonControlCtx", "");
		button = new ButtonAsActor("button", buttonType);
		led = new LedAsActor("led", ledType);
		controller = new BLControllerAsActor("controller", "led");
	}
	private void activateComponents() {
		MActorContext.activateActors();
	}
	private void configure() {
		BLSystemConfig.setConfiguration();
		buttonType = BLSystemConfig.buttonType;
		ledType = BLSystemConfig.ledType;
	}
	
	public static void main(String[] args) {
		System.out.println("MainButtonLedLocalActorSystem");
		new MainButtonLedLocalActorSystem().startTheSystem();
	}
}
