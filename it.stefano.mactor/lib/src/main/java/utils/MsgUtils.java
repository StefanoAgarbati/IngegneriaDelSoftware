package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import mactor.impl.MActorMessage;

public class MsgUtils {

	private JsonObject object;
	private String jsonMsg;
	private MActorMessage msg;
	
	public MsgUtils(String msg) {
		this.jsonMsg = msg;
		try {
			object = JsonParser.parseString(msg).getAsJsonObject();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
		
		
	}
	public MsgUtils(MActorMessage msg) {
		this.msg = msg;
	}
	public static MsgUtils create(MActorMessage msg) {
		return new MsgUtils(msg);
	}
	public static MsgUtils create(String msg) {
		return new MsgUtils(msg);
	}

	private String getAsString(String propName) {
		return object.get(propName).getAsString();
	}
	public static MActorMessage getAsActorMessage(String msg) {
		JsonObject object = JsonParser.parseString(msg).getAsJsonObject();
		String name = object.get("name").getAsString();
		String message = object.get("msg").getAsString();
		String sender = object.get("sender").getAsString();
		String receiver = object.get("receiver").getAsString();
		return MActorMessage.create(name, sender, receiver, message);
	}
	public static String getAsString(MActorMessage msg) {
		JsonObject object = new JsonObject();
		object.addProperty("name", msg.getName());
		object.addProperty("sender", msg.getSender());
		object.addProperty("receiver", msg.getReceiver());
		object.addProperty("msg", msg.getMsg());
		return object.toString();
	}
	
	public String getName() {
		return getAsString("name");
	}

	public String getSender() {
		return getAsString("sender");
	}

	public String getReceiver() {
		return getAsString("receiver");
	}

	public String getMsg() {
		return getAsString("msg");
	}
	
	public static void main(String[] args) {
		MActorMessage message = MActorMessage.create("m1", "sen", "rec", "body");
		
		MActorMessage message2 = MActorMessage.create("m1", "sen", "", "body");
		
		String stringMessage = MsgUtils.getAsString(message);
		System.out.println(stringMessage);
		System.out.println( MsgUtils.getAsString(message2));
	}

}
