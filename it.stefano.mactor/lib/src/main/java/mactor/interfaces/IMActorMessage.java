package mactor.interfaces;

public interface IMActorMessage {
	
	String getName();
	
	IMActor getSender();
	
	IMActor getReceiver();

	String getMsg();
}
