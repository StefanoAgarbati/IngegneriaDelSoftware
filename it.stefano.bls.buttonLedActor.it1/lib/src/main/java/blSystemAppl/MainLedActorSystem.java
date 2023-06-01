package blSystemAppl;

import blSystem.BLSystemConfig;
import led.actor.LedAsActor;
import mactor.impl.MActor;
import mactor.impl.MActorContext;


public class MainLedActorSystem extends MainBaseActorSystem {

	private MActor led;
	
	
	protected void createComponents() {
		MActorContext.initContext(BLSystemConfig.ledCtxName, BLSystemConfig.ledCtxPort);
		MActorContext.registerRemoteContext(BLSystemConfig.controlCtxName, BLSystemConfig.controlCtxAddress, BLSystemConfig.controlCtxPort);
		MActorContext.registerRemoteActor(BLSystemConfig.controlActorName, BLSystemConfig.controlCtxName);
		led = new LedAsActor(BLSystemConfig.ledActorName, BLSystemConfig.ledType);
	}
	
	public static void main(String[] args) {
		System.out.println("MainLedActorSystem");
		new MainLedActorSystem().startTheSystem();
	}
}
