package blSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import button.ButtonType;
import interfaces.ProtocolType;

public class BLSystemConfig {

	public static String buttonType = ButtonType.MOCK;
	
	public static String buttonAddress = "localhost";
	
	public static int buttonPort = 8084; 
	
	public static ProtocolType buttonProtocol = ProtocolType.TCP;
	
	public static void setConfiguration() {
		setConfiguration("BLSystemConfig.json");
	}
	
	public static void setConfiguration(String configuration) {
		try {
			FileReader fr = new FileReader(new File(configuration));
			
			JsonObject object = JsonParser.parseReader(fr).getAsJsonObject();
			
			buttonType = object.get("buttonType").getAsString();
			buttonAddress = object.get("buttonAddress").getAsString();
			buttonPort = object.get("buttonPort").getAsInt();
			buttonProtocol = getProtocol(object.get("buttonProtocol").getAsString());
			
			System.out.println("BLSystemConfig | buttonType " + buttonType);
			System.out.println("BLSystemConfig | buttonAddress " + buttonAddress);
			System.out.println("BLSystemConfig | buttonPort " + buttonPort);
			System.out.println("BLSystemConfig | buttonProtocol " + buttonProtocol);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static ProtocolType getProtocol(String type) {
		ProtocolType protocol = ProtocolType.TCP;
		switch(type) {
		case "tcp": 
			protocol = ProtocolType.TCP;
			break;
		case "udp": 
			protocol = ProtocolType.UDP; 
			break;
		}
		return protocol;
	}
	
}
