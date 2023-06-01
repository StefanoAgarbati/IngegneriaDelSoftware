package mactor.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MActorSystem {

	private static String configuration = "MActorSystemConfig.json";
	
	private static MActor createActor(String name, String className) {
		try {
			Class clz = Class.forName(className);
			Constructor<?> cons = clz.getConstructor(String.class);
			MActor actor = (MActor)cons.newInstance(name);
			return actor;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void createTheSystem(String configuration) {
		System.out.println("MActorSystem | configuration file " + configuration);
		if(configuration == null || configuration.equals("")) {
			configureSystem();
		} else {
			configureSystem(configuration);
		}
		activateSystem();
	}
	public static void activateSystem() {
		MActorContext.activateActors();
	}
	public static void configureSystem() {
		try {
			configureSystem(configuration);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void configureSystem(String config) {
		System.out.println("MActorContext | configure system with config " + config);
		configureContexts(config);
		configureActors(config);
	}
	private static void configureContexts(String configuration) {
		try {
			FileReader fr = new FileReader(new File(configuration));
			JsonObject object = JsonParser.parseReader(fr).getAsJsonObject();
			
			List<JsonElement> ctxs = object.get("contexts").getAsJsonArray().asList();
			
			System.out.println("MActorSystem | contexts " + ctxs.toString());
			
			for(JsonElement ctx : ctxs) {
				String ctxName = ctx.getAsJsonObject().get("name").getAsString();
				String ctxPort = ctx.getAsJsonObject().get("port").getAsString();
				String ctxAddress = ctx.getAsJsonObject().get("address").getAsString();
				
				System.out.println("MActorSystem | ctxName: " + ctxName + " ctxPort: " +ctxPort+" ctxAddress:" + ctxAddress);
				
				configureContext(ctxName, ctxPort, ctxAddress);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void configureContext(String ctxName, String ctxPort, String ctxAddress) {
		if(ctxAddress == null || ctxAddress.equals("")) {
			MActorContext.initContext(ctxName, ctxPort);
		} else {
			MActorContext.registerRemoteContext(ctxName, ctxAddress, ctxPort);
		}
	}
	private static void configureActors(String configuration) {
		try {
			FileReader fr = new FileReader(new File(configuration));
			JsonObject object = JsonParser.parseReader(fr).getAsJsonObject();
			
			List<JsonElement> acts = object.get("actors").getAsJsonArray().asList();
			
			for(JsonElement actor: acts) {
				String actorName = actor.getAsJsonObject().get("name").getAsString();
				String actorCtx= actor.getAsJsonObject().get("context").getAsString();
				String actorClassName = actor.getAsJsonObject().get("class").getAsString();
				
				configureActor(actorName, actorClassName, actorCtx);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	private static void configureActor(String name, String className, String context) {
		if(isLocalActor(context)) {
			MActor actor = createActor(name, className);
			MActorContext.registerActor(name, actor);
		} else {
			MActorContext.registerRemoteActor(name, context);
		}
	}
	private static boolean isLocalActor(String context) {
		return MActorContext.getName().equals(context);
	}
}
