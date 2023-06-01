package blSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import interfaces.ProtocolType;
import led.LedType;

public class BLSystemConfig {

	public static String ledType = LedType.GUI;
	
	public static int port = 8085;

	public static ProtocolType protocol = ProtocolType.TCP;

	public static void setConfiguration() {
		setConfiguration("BLSystemConfig.json");
	}
	
	public static void setConfiguration(String configuration) {
		try {
			FileReader fr = new FileReader(new File(configuration));
			
			JsonObject object = JsonParser.parseReader(fr).getAsJsonObject();
			
			ledType = object.get("ledType").getAsString();
			port = object.get("port").getAsInt();
			switch(object.get("protocol").getAsString()) {
			case "tcp" : protocol = ProtocolType.TCP; break;
			case "udp" : protocol = ProtocolType.UDP; break;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
