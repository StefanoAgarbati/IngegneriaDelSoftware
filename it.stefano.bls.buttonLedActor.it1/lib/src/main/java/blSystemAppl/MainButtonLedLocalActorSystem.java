package blSystemAppl;

import blSystem.BLSystemConfig;
import button.actor.ButtonAsActor;
import control.BLControllerAsActor;
import led.actor.LedAsActor;
import mactor.impl.MActor;
import mactor.impl.MActorContext;

public class MainButtonLedLocalActorSystem extends MainBaseActorSystem {

	private MActor button;
	private MActor controller;
	private MActor led;
	
	protected void createComponents() {
		MActorContext.initContext("buttonLedCtx", "");
		button = new ButtonAsActor(BLSystemConfig.buttonActorName, BLSystemConfig.buttonType);
		led = new LedAsActor(BLSystemConfig.ledActorName, BLSystemConfig.ledType);
		controller = new BLControllerAsActor(BLSystemConfig.controlActorName, BLSystemConfig.ledActorName);
	}
	
	public static void main(String[] args) {
		System.out.println("MainButtonLedLocalActorSystem");
		new MainButtonLedLocalActorSystem().startTheSystem();
	}
}
