package blSystem;

import mactor.impl.MActorSystem;

public class MainControlLedActorSystem {

	public static void main(String[] args) throws Exception {
		MActorSystem.createTheSystem("ControlLedActorSystemConfig.json");
	}
}
