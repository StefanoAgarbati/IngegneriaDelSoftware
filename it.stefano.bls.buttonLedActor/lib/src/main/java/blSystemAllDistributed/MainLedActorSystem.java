package blSystemAllDistributed;

import blSystem.BLSystemConfig;
import led.LedType;
import led.actor.LedAsActor;
import mactor.impl.MActor;
import mactor.impl.MActorContext;


public class MainLedActorSystem {

	private MActor led;
	
	private String ledType = LedType.GUI;
	
	private String port = "8086";
	private String controlAddress = "localhost";
	private String controlPort = "8084";
	
	public void startTheSystem() {
		configure();
		createComponents();
		activateComponents();
	}
	private void createComponents() {
		MActorContext.initContext("ledCtx", port);
		MActorContext.registerRemoteContext("controlCtx", controlAddress, controlPort);
		MActorContext.registerRemoteActor("controller", "controlCtx");
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
		System.out.println("MainLedActorSystem");
		new MainLedActorSystem().startTheSystem();
	}
}
