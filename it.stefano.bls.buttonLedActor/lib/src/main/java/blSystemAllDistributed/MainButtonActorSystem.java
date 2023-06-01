package blSystemAllDistributed;

import blSystem.BLSystemConfig;
import button.ButtonType;
import button.actor.ButtonAsActor;
import mactor.impl.MActor;
import mactor.impl.MActorContext;

public class MainButtonActorSystem {

	private MActor button;
	
	private String buttonType = ButtonType.GUI;
	
	private String controlCtxAddress = "localhost";
	private String controlCtxPort = "8084";
	private String controlCtxName = "controlCtx";
	private String port = "8085";
	
	public void startTheSystem() {
		configure();
		createComponents();
		activateComponents();
	}
	
	private void createComponents() {
		MActorContext.initContext("buttonCtx", port);
		MActorContext.registerRemoteContext(controlCtxName, controlCtxAddress, controlCtxPort);
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
