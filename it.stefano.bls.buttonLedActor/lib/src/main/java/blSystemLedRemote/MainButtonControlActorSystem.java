package blSystemLedRemote;

import blSystem.BLSystemConfig;
import button.ButtonType;
import button.actor.ButtonAsActor;
import control.BLControllerAsActor;
import mactor.impl.MActor;
import mactor.impl.MActorContext;


public class MainButtonControlActorSystem {

	private MActor button;
	private MActor controller;
	
	private String buttonType = ButtonType.GUI;
	
	private String ledAddress = "localhost";
	private String ledPort = "8084";
	private String port = "8085";
	
	public void startTheSystem() {
		configure();
		createComponents();
		activateComponents();
	}
	
	private void createComponents() {
		MActorContext.initContext("buttonControlCtx", port);
		MActorContext.registerRemoteContext("ledCtx", ledAddress, ledPort);
		MActorContext.registerRemoteActor("led", "ledCtx");
		button = new ButtonAsActor("button", buttonType);
		controller = new BLControllerAsActor("controller", "led");
	}
	private void activateComponents() {
		MActorContext.activateActors();
	}
	private void configure() {
		BLSystemConfig.setConfiguration();
		buttonType = BLSystemConfig.buttonType;
	}
	
	public static void main(String[] args) {
		System.out.println("MainButtonControlActorSystem");
		new MainButtonControlActorSystem().startTheSystem();
	}
}
