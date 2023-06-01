package mactor.impl;


import client.IProxyClient;
import client.ProxyClientFactory;
import interfaces.ProtocolType;

public class MessageSender {

	private IProxyClient client;
	private MsgStore<String> msgStore = new MsgStore<>();
	private boolean isActive = false;
	
	public MessageSender(String host, int port) {
		client = ProxyClientFactory.createClient(host, port, ProtocolType.TCP);
	}
	public void sendMsg(String msg) {
		storeMsg(msg);
	}
	private void storeMsg(String msg) {
		msgStore.storeMsg(msg);
	}
	public void deactivate() {
		isActive = false;
		sendMsg("bye");
	}
	public void activate() {
		if(isActive)
			return;
		isActive = true;
		new Thread(()-> doJob()).start();
	}
	private void doJob() {
		while(isActive) {
			String msg = msgStore.getMsg();
			if(!msg.equals("bye"))
				client.sendMsg(msg);
		}
		
	}
	
}
