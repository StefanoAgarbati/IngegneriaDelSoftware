package blSystemAppl;

import blSystem.BLSystemConfig;
import button.actor.ButtonAsActor;
import mactor.impl.MActor;
import mactor.impl.MActorContext;

public class MainButtonActorSystem extends MainBaseActorSystem { 

	private MActor button;
	
	protected void createComponents() {
		MActorContext.initContext(BLSystemConfig.buttonCtxName, BLSystemConfig.buttonCtxPort);
		MActorContext.registerRemoteContext(BLSystemConfig.controlCtxName, BLSystemConfig.controlCtxAddress, BLSystemConfig.controlCtxPort);
		button = new ButtonAsActor(BLSystemConfig.buttonActorName, BLSystemConfig.buttonType);
	}
	
	public static void main(String[] args) {
		System.out.println("MainButtonActorSystem");
		new MainButtonActorSystem().startTheSystem();
	}
	
	
}
