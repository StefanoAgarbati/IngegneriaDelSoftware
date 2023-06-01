package blSystemButtonRemote;

import blSystem.BLSystemConfig;
import button.ButtonType;
import button.actor.ButtonAsActor;
import mactor.impl.MActor;
import mactor.impl.MActorContext;

public class MainButtonActorSystem {

	private MActor button;
	
	private String buttonType = ButtonType.GUI;
	
	private String controlLedCtxAddress = "localhost";
	private String controlLedCtxPort = "8084";
	private String controlLedCtxName = "controlLedCtx";
	private String port = "8085";
	
	public void startTheSystem() {
		configure();
		createComponents();
		activateComponents();
	}
	
	private void createComponents() {
		MActorContext.initContext("buttonCtx", port);
		MActorContext.registerRemoteContext(controlLedCtxName, controlLedCtxAddress, controlLedCtxPort);
		button = new ButtonAsActor("button", buttonType);
	}
	private void activateComponents() {
		MActorContext.activateActors();
	}
	private void configure() {
		BLSystemConfig.setConfiguration();
		buttonType = BLSystemConfig.buttonType;
	}
	
	public static void main(String[] args) {
		System.out.println("MainButtonActorSystem");
		new MainButtonActorSystem().startTheSystem();
	}
	
	
}
