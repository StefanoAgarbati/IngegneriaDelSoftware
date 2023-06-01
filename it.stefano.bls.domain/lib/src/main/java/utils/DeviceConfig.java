package utils;

import java.awt.Color;
import java.io.File;
import java.io.FileReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import interfaces.ProtocolType;

public class DeviceConfig {

	public static int ledPin = 0;
	
	public static int buttonPin = 4;
	
	public static int ledOnColor = Color.GREEN.getRGB();
	
	public static int ledOffColor = Color.RED.getRGB();
	
	public static int ledPort = 8085;
	
	public static String ledAddress = "localhost";
	
	public static ProtocolType ledProtocol = ProtocolType.TCP;
	
	public static int buttonPort = 8084;
	
	public static ProtocolType buttonProtocol = ProtocolType.TCP;
	
	public static String serialPortName = "COM3";
	
	static {
		setConfiguration();
	}
	
	public static void setConfiguration() {
		setConfiguration("./DeviceConfig.json");
		System.out.println("setTheConfig");
	}
	public static void setConfiguration(String config) {
		try {
			FileReader fr = new FileReader(new File(config));
			JsonObject geson = JsonParser.parseReader(fr).getAsJsonObject();
			
			ledPin = geson.get("ledPin").getAsInt();
			buttonPin = geson.get("buttonPin").getAsInt();
//			ledOnColor = Integer.parseInt(geson.get("ledOnColor").getAsString(), 16);
			System.out.println("ledOnColorGeson: ");
//			ledOffColor = Integer.parseInt(geson.get("ledOffColor").getAsString(), 16);
			ledPort = geson.get("ledPort").getAsInt();
			ledAddress = geson.get("ledAddress").getAsString();
			ledProtocol = getProtocol(geson.get("ledProtocol").getAsString());
			buttonPort = geson.get("buttonPort").getAsInt();
			buttonProtocol = getProtocol(geson.get("buttonProtocol").getAsString());	
			serialPortName = geson.get("serialPortName").getAsString();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private static ProtocolType getProtocol(String type) {
		switch(type) {
		case "tcp":
			return ProtocolType.TCP;
		case "udp":
			return ProtocolType.UDP;
		}
		return ProtocolType.TCP;
	}
	
	public static void main(String[] ags) {
		String num = "0A09ff";
		int intNum = Integer.parseInt(num, 16);
		int esaNum = 0x1010FF;
		Color aColor = new Color(esaNum);
		System.out.println(intNum);
		System.out.println(esaNum);
		System.out.println(aColor.toString());
		setConfiguration();
		System.out.println("ledPin:" + ledPin);
		System.out.println("buttonPin:" + buttonPin);
		System.out.println("LedOnColor:"+ new Color(ledOnColor));
		System.out.println("LedOffColor"+ new Color(ledOffColor));
	}
	
}
