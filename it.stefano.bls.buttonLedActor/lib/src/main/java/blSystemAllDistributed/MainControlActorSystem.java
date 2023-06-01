package blSystemAllDistributed;

import control.BLControllerAsActor;
import mactor.impl.MActor;
import mactor.impl.MActorContext;

public class MainControlActorSystem {

	private MActor controller;
	
	private String ledCtxAddress = "localhost";
	private String ledCtxPort = "8086";
	private String ledCtxName = "ledCtx";
	private String port = "8084";
	
	public void startTheSystem() {
		configure();
		createComponents();
		activateComponents();
	}
	
	private void configure() {
	}

	private void createComponents() {
		MActorContext.initContext("controlCtx", port);
		MActorContext.registerRemoteContext(ledCtxName, ledCtxAddress, ledCtxPort);
		MActorContext.registerRemoteActor("led", ledCtxName);
		controller = new BLControllerAsActor("controller", "led");
	}
	private void activateComponents() {
		MActorContext.activateActors();
	}
	
	public static void main(String[] args) {
		System.out.println("MainControlActorSystem");
		new MainControlActorSystem().startTheSystem();
	}
	
}
