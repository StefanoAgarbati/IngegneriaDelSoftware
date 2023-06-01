package blSystemAppl;

import blSystem.BLSystemConfig;
import control.BLControllerAsActor;
import interfaces.IApplication;
import led.LedType;
import led.actor.LedAsActor;
import mactor.impl.MActor;
import mactor.impl.MActorContext;

public class MainControlLedActorSystem extends MainBaseActorSystem {

	private MActor led;
	private MActor controller;
	
	protected void createComponents() {
		MActorContext.initContext(BLSystemConfig.controlLedCtxName, BLSystemConfig.controlLedCtxPort);
		MActorContext.registerRemoteContext(BLSystemConfig.buttonCtxName, BLSystemConfig.buttonCtxAddress, BLSystemConfig.buttonCtxPort);
		led = new LedAsActor(BLSystemConfig.ledActorName, BLSystemConfig.ledType);
		controller = new BLControllerAsActor(BLSystemConfig.controlActorName, BLSystemConfig.ledActorName);
	}
	
	public static void main(String[] args) {
		System.out.println("MainControlLedActorSystem");
		new MainControlLedActorSystem().startTheSystem();
	}
}
