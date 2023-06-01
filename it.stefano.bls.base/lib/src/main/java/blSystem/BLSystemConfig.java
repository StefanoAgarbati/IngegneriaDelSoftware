package blSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import button.ButtonType;
import led.LedType;

public class BLSystemConfig {

	public static String ledType = LedType.MOCK;
	
	public static String buttonType = ButtonType.MOCK;
	
	public static void setConfiguration() {
		setConfiguration("BLSystemConfig.json");
	}
	
	public static void setConfiguration(String configuration) {
		try {
			FileReader fr = new FileReader(new File(configuration));
			
			JsonObject object = JsonParser.parseReader(fr).getAsJsonObject();
			
			ledType = object.get("ledType").getAsString();
			System.out.println("BLSystemConfig | LedType " + ledType);
			buttonType = object.get("buttonType").getAsString();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
