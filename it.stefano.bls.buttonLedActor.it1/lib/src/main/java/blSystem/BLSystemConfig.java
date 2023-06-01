package blSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import button.ButtonType;
import led.LedType;

public class BLSystemConfig {

	public static String buttonType = ButtonType.MOCK;
	
	public static String ledType = LedType.MOCK;
	
	public static String buttonActorName = "button";
	
	public static String ledActorName = "led";
	
	public static String controlActorName = "controller";
	
	public static String buttonCtxName = "buttonCtx";
	
	public static String buttonCtxPort = "8085";
	
	public static String buttonCtxAddress = "localhost";
	
	public static String ledCtxName = "ledCtx";
	
	public static String ledCtxPort = "8086";
	
	public static String ledCtxAddress = "localhost";
	
	public static String controlCtxName = "controlCtx";
	
	public static String controlCtxPort = "8084";
	
	public static String controlCtxAddress = "localhost";

	public static String buttonControlCtxPort = "8085";
	
	public static String buttonControlCtxName = "buttonControlctx";
	
	public static String controlLedCtxPort = "8084";
	
	public static String controlLedCtxName = "controlLedctx";
	
	
	public static void setConfiguration() {
		setConfiguration("BLSystemConfig.json");
	}
	
	public static void setConfiguration(String configuration) {
		try {
			FileReader fr = new FileReader(new File(configuration));
			
			JsonObject object = JsonParser.parseReader(fr).getAsJsonObject();
			
			buttonType = object.get("buttonType").getAsString();
			ledType = object.get("ledType").getAsString();
			
			buttonActorName = object.get("buttonActorName").getAsString();
			buttonCtxName = object.get("buttonCtxName").getAsString();
			buttonCtxAddress = object.get("buttonCtxAddress").getAsString();
			buttonCtxPort = object.get("buttonCtxPort").getAsString();
			
			ledActorName = object.get("ledActorName").getAsString();
			ledCtxName = object.get("ledCtxName").getAsString();
			ledCtxAddress = object.get("ledCtxAddress").getAsString();
			ledCtxPort = object.get("ledCtxPort").getAsString();
			
			controlActorName = object.get("controlActorName").getAsString();
			controlCtxName = object.get("controlCtxName").getAsString();
			controlCtxAddress = object.get("controlCtxAddress").getAsString();
			controlCtxPort = object.get("controlCtxPort").getAsString();
			
			buttonControlCtxPort = object.get("buttonControlCtxPort").getAsString();
			buttonControlCtxName = object.get("buttonControlCtxName").getAsString();
			controlLedCtxPort = object.get("controlLedCtxPort").getAsString();
			controlLedCtxName = object.get("controlLedCtxName").getAsString();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
