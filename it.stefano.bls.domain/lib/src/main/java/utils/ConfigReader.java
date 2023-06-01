package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConfigReader {

	private JsonObject object;
	
	public ConfigReader(String config) {
		try {
			FileReader fr = new FileReader(new File(config));
			object = JsonParser.parseReader(fr).getAsJsonObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int getInt(String param) {
		return object.get(param).getAsInt();
	}
	public String getString(String param) {
		return object.get(param).getAsString();
	}
	
}
