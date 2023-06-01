package blSystemLedRemote;

import blSystem.BLSystemConfig;
import led.LedType;
import led.actor.LedAsActor;
import mactor.impl.MActor;
import mactor.impl.MActorContext;


public class MainLedActorSystem {

	private MActor led;
	
	private String ledType = LedType.GUI;
	
	private String port = "8084";
	private String controlAddress = "localhost";
	private String controlPort = "8085";
	
	public void startTheSystem() {
		configure();
		createComponents();
		activateComponents();
	}
	private void createComponents() {
		MActorContext.initContext("ledCtx", port);
		MActorContext.registerRemoteContext("buttonControlCtx", controlAddress, controlPort);
		MActorContext.registerRemoteActor("controller", "buttonControlCtx");
		led = new LedAsActor("led", ledType);
	}
	
	private void activateComponents() {
		MActorContext.activateActors();
	}
	private void configure() {
		BLSystemConfig.setConfiguration();
		ledType = BLSystemConfig.ledType;
	}
	
	public static void main(String[] args) {
		System.out.println("Main");
		new MainLedActorSystem().startTheSystem();
	}
}
