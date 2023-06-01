package mactor.impl;

public class MActorMessage {

	private String sender;
	private String msg;
	private String name;
	private String receiver;
	
	public MActorMessage(String name, String sender, String receiver, String msg) {
		this.sender = sender;
		this.msg = msg;
		this.name = name;
		this.receiver = receiver;
	}
	
	public static MActorMessage create(String name, String sender, String receiver, String msg) {
		return new MActorMessage(name, sender, receiver, msg);
	}
	
	public String getName() {
		return this.name;
	}

	
	public String getSender() {
		return this.sender;
	}
	
	public String getMsg() {
		return this.msg;
	}
	
	public String getReceiver() {
		return this.receiver;
	}
	
	

}
