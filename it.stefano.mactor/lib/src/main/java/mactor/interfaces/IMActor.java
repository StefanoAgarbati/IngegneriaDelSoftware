package mactor.interfaces;

public interface IMActor {
	
	String getName();
	
	void receive(IMActorMessage msg);
	
	IMsgStore<IMActorMessage> getMsgStore();
	
	
	
}
