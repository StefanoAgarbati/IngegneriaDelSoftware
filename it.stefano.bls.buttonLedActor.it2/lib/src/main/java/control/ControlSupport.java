package control;

import interf.ILed;
import interfaces.IBLController;
import led.LedForActors;
import mactor.impl.MActor;
import utils.ConfigReader;

public class ControlSupport {

	private IBLController control;
	private String evName;
	
	public static ControlSupport create(MActor actor, String config) {
		return new ControlSupport(actor, config);
	}
	public ControlSupport(MActor actor, String config) {
		ConfigReader reader = new ConfigReader(config);
		String ledName = reader.getString("ledName");
		actor.subscribe("buttonEv");
		ILed ledForActors = new LedForActors(actor, ledName);
		control = new BLController(ledForActors);
		System.out.println("BLControllerActor | created ");
	}
	public String getEvName() {
		return evName;
	}
	public void update(String data) {
		control.update(data);
	}
}
