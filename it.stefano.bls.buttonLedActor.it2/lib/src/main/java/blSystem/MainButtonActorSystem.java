package blSystem;

import mactor.impl.MActorSystem;

public class MainButtonActorSystem {

	public static void main(String[] args) {
		MActorSystem.createTheSystem("ButtonActorSystemConfig.json");
	}
}
