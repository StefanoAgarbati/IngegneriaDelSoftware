package mactor.impl;

import event.EventSupport;
import mactor.interfaces.IMsgStore;
import utils.MsgUtils;

public abstract class MActor {

	private IMsgStore<MActorMessage> msgStore = new MsgStore<>();
	private boolean isActive = false;
	private String name;
	
	public MActor(String name) {
		this.name = name;
		MActorContext.registerActor(name, this);
	}
	
	protected abstract void processMsg(MActorMessage msg);

	public String getName() {
		return name;
	}
	public void deactivate() {
		isActive = false;
		sendMsgToThis("bye", "bye");
	}
	
	public void activate() {
		if(isActive)
			return;
		isActive = true;
		new Thread(() -> mainLoop()).start();
		System.out.println("MActor | actor "+getName()+" activated");
	}
	private void mainLoop() {
		while(isActive) {
			MActorMessage msg = getNextMessage();
			processMsg(msg);
		}
	}
	private MActorMessage getNextMessage() {
		return msgStore.getMsg();
	}
	public void send(MActorMessage msg) {
		
	}
	protected void sendMsgToThis(String name, String msg) {
		sendMsg(name, getName(), getName(), msg);
	}
	public void sendReply(String repName, String sender, String receiver, String msg) {
		sendMsg(repName, sender, receiver, msg);
	}
	public void sendMsg(String msgName, String sender, String receiver, String msg) {
		System.out.println(""+this.getClass().getName()+"| sending message");
		MActorMessage message = MActorMessage.create(msgName, sender, receiver, msg);
		//receiver.getMsgStore().storeMsg(message);
		MActor recv = MActorContext.getActor(receiver);
		System.out.println("MActor | receiver ref " + recv);
		if(recv != null) {
			System.out.println("Actor"+getName()+ "| local sending to " + recv.getName());
			recv.getMsgStore().storeMsg(message);
		} else {
			sendMessageToRemoteActor(message);
		}
	}
	private void sendMessageToRemoteActor(MActorMessage msg) {
		System.out.println("MActor | sending message to remote actor '" + msg.getReceiver()+"'");
		String msgRep = getMessageStringRep(msg);
		MessageSender sender = MActorContext.getMessageSender(msg.getReceiver());
		sender.sendMsg(msgRep);
		
	}
	
	private void sendEventToAllCtx(String evName, String evSource, String evMsg) {
		System.out.println("MActor | sending emit event");
		MActorMessage event = MActorMessage.create(evName, evSource, "", evMsg);
		MActorContext.emitEvent(getMessageStringRep(event)); 
	}

	private String getMessageStringRep(MActorMessage message) {
		return MsgUtils.getAsString(message);
	}

	public void sendRequest(String msgName, String sender, String receiver, String msg) {
		sendMsg(msgName, sender, receiver, msg);
	}
	public void sendDispatch(String name, String sender, String receiver, String msg) {
		sendMsg(name, sender, receiver, msg);
	}
	protected void storeMsg(MActorMessage msg) {
		msgStore.storeMsg(msg);
		System.out.println("MActor | message stored " + msg.getName());
	}
	public IMsgStore<MActorMessage> getMsgStore() {
		return msgStore;
	}
	
	public void publish(String eventName, String eventBody) {
		EventSupport.getInstance().publish(eventName, eventBody);
		System.out.println("MActor | event published " + eventName + " "+ eventBody);
		sendEventToAllCtx(eventName, this.getName(), eventBody);
	}
	public void subscribe(String evName) {
		EventSupport.getInstance().subscribe(evName, (evType, evMsg) -> {
			MActorMessage ev = MActorMessage.create(evType, "", "", evMsg);
			this.getMsgStore().storeMsg(ev);
			System.out.println("MActor | Subscriber | handleEvent " + evType + " " + evMsg);
		});
		System.out.println("MActor | subscribed for " + evName);
	}
	
}
