package mactor.impl;

import java.util.HashMap;
import java.util.Map;

public class MActorContext {

	private static String name;
	private static Map<String, MActor> actorsMap = new HashMap<>();
	private static Map<String, MessageSender> senderMap = new HashMap<>();
	private static Map<String, MessageSender> remoteActorMap = new HashMap<>();
	private static Map<String, String> ctxActorMap = new HashMap<>();
	private static ServerObject server;
	private static int port;
	
	private static void initServerObject(int port) {
		server = new ServerObject(port);
		server.activate();
	}
	public static void initContext(String aName, String aPort) {
		name = aName;
		if(aPort != null && !aPort.equals("")) {
			port = Integer.parseInt(aPort);
			initServerObject(port);
		}
		System.out.println("MActorContext | ctx " + name + " initialized on port " + port);
	}
	public static String getName() {
		return name;
	}
	public static void registerRemoteActor(String actorName, String ctxName) {
		String ctx = ctxActorMap.get(actorName);
		if(ctx == null) {
			ctxActorMap.put(actorName, ctxName);
		}
	}
//	public static void registerRemoteActor(String name, String host, String port) {
//		MessageSender aSender = remoteActorMap.get(name);
//		if(aSender == null) {
//			String senderName = host+":"+port;
//			aSender = senderMap.get(senderName);
//			if(aSender == null) {
//				aSender = new MessageSender(host, Integer.parseInt(port));
//				senderMap.put(senderName, aSender);
//				aSender.activate();
//			}
//			remoteActorMap.put(name, aSender);
//		}
//	}
	public static void registerActor(String name, MActor actor) {
		actorsMap.put(name, actor);
		System.out.println("MActorContex | actor registered " + actor.getName());
	}
	
	public static void deregisterActor(String name) {
		actorsMap.remove(name);
	}
	
	public static MActor getActor(String name) {
		MActor actor = actorsMap.get(name);
		return actor;
	}
	
	public static void activateActors() {
		actorsMap.values().stream().forEach(actor -> actor.activate());
	}
	public static MessageSender getMessageSender(String receiver) {
		String remoteCtxName = ctxActorMap.get(receiver);
		return senderMap.get(remoteCtxName);
	}
	public static void emitEvent(String event) {
		senderMap.values().stream().forEach(sender -> sender.sendMsg(event));
	}
	public static void registerRemoteContext(String name, String address, String port) {
		MessageSender sender = senderMap.get(name);
		if(sender == null) {
			sender = new MessageSender(address, Integer.parseInt(port));
			senderMap.put(name, sender);
			sender.activate();
		}
		System.out.println("MActorContext | remote ctx " + name + " registered. Address " + address +":"+port);
	}
	
	
}
