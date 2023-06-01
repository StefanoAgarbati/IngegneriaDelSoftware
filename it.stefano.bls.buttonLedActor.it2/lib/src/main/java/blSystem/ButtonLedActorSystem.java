package blSystem;

import mactor.impl.MActorSystem;

public class ButtonLedActorSystem {

	public ButtonLedActorSystem() {
		MActorSystem.createTheSystem(null);
	}
	
	public static void main(String[] args) {
		new ButtonLedActorSystem();
	}
	
}
