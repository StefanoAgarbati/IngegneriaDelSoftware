package blSystemAppl;

import blSystem.BLSystemConfig;
import button.actor.ButtonAsActor;
import control.BLControllerAsActor;
import mactor.impl.MActor;
import mactor.impl.MActorContext;


public class MainButtonControlActorSystem extends MainBaseActorSystem {

	private MActor button;
	private MActor controller;
	
	protected void createComponents() {
		MActorContext.initContext(BLSystemConfig.buttonControlCtxName, BLSystemConfig.buttonControlCtxPort);
		MActorContext.registerRemoteContext(BLSystemConfig.ledCtxName, BLSystemConfig.ledCtxAddress, BLSystemConfig.ledCtxPort);
		MActorContext.registerRemoteActor(BLSystemConfig.ledActorName, BLSystemConfig.ledCtxName);
		button = new ButtonAsActor(BLSystemConfig.buttonActorName, BLSystemConfig.buttonType);
		controller = new BLControllerAsActor(BLSystemConfig.controlActorName, BLSystemConfig.ledActorName);
	}
	
	public static void main(String[] args) {
		System.out.println("MainButtonControlActorSystem");
		new MainButtonControlActorSystem().startTheSystem();
	}
}
