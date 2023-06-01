package blSystem;

import blSystemAppl.MainButtonActorSystem;
import blSystemAppl.MainButtonControlActorSystem;
import blSystemAppl.MainButtonLedLocalActorSystem;
import blSystemAppl.MainControlActorSystem;
import blSystemAppl.MainControlLedActorSystem;
import blSystemAppl.MainLedActorSystem;
import interfaces.IApplication;

public class ButtonLedActorSystemFactory {

	public static IApplication createSystem(String type) {
		switch(type) {
		case "local": return new MainButtonLedLocalActorSystem();
		case "led": return new MainLedActorSystem();
		case "button": return new MainButtonActorSystem();
		case "control": return new MainControlActorSystem();
		case "ledControl": return new MainControlLedActorSystem();
		case "buttonControl": return new MainButtonControlActorSystem();
		}
		return null;
	}
}
