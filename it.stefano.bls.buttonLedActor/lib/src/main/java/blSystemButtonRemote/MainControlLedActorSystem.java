package blSystemButtonRemote;

import blSystem.BLSystemConfig;
import control.BLControllerAsActor;
import led.LedType;
import led.actor.LedAsActor;
import mactor.impl.MActor;
import mactor.impl.MActorContext;

public class MainControlLedActorSystem {

	private MActor led;
	private MActor controller;
	
	private String ledType = LedType.GUI;
	
	private String buttonControlCtxAddress = "localhost";
	private String buttonControlCtxPort = "8085";
	private String port = "8084";
	
	public void startTheSystem() {
		configure();
		createComponents();
		activateComponents();
	}
	
	private void createComponents() {
		MActorContext.initContext("controlLedCtx", port);
		MActorContext.registerRemoteContext("buttonCtx", buttonControlCtxAddress, buttonControlCtxPort);
		led = new LedAsActor("led", ledType);
		controller = new BLControllerAsActor("controller", "led");
	}
	private void activateComponents() {
		MActorContext.activateActors();
	}
	private void configure() {
		BLSystemConfig.setConfiguration();
		ledType = BLSystemConfig.ledType;
	}
	
	public static void main(String[] args) {
		System.out.println("MainControlLedActorSystem");
		new MainControlLedActorSystem().startTheSystem();
	}
}
