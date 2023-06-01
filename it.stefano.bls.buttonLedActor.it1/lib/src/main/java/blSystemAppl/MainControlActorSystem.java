package blSystemAppl;

import blSystem.BLSystemConfig;
import control.BLControllerAsActor;
import mactor.impl.MActor;
import mactor.impl.MActorContext;

public class MainControlActorSystem extends MainBaseActorSystem {

	private MActor controller;
	
	protected void createComponents() {
		MActorContext.initContext(BLSystemConfig.controlCtxName, BLSystemConfig.buttonControlCtxPort);
		MActorContext.registerRemoteContext(BLSystemConfig.ledCtxName, BLSystemConfig.ledCtxAddress, BLSystemConfig.ledCtxPort);
		MActorContext.registerRemoteActor(BLSystemConfig.ledActorName, BLSystemConfig.ledCtxName);
		controller = new BLControllerAsActor(BLSystemConfig.controlActorName, BLSystemConfig.ledActorName);
	}
	
	public static void main(String[] args) {
		System.out.println("MainControlActorSystem");
		new MainControlActorSystem().startTheSystem();
	}
	
}
