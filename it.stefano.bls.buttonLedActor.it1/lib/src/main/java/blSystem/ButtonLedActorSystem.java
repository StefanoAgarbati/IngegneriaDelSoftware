package blSystem;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import interfaces.IApplication;

public class ButtonLedActorSystem {

	private IApplication curSystem;
	private String systemType;
	private final String configResource = "BLSystemActorConfig.json";
	
	public ButtonLedActorSystem() {
		init();
	}
	public void startSystem() {
		curSystem.startTheSystem();
	}
	private void init() {
		configure();
		curSystem = createSystem(systemType);
	}
	private IApplication createSystem(String type) {
		return ButtonLedActorSystemFactory.createSystem(type);
	}
	private void configure() {
		try {
			FileReader fr = new FileReader(configResource);
			JsonObject object = JsonParser.parseReader(fr).getAsJsonObject();
			systemType = object.get("type").getAsString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new ButtonLedActorSystem().startSystem();
	}
	
}
