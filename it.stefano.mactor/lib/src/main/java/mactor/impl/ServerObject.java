package mactor.impl;

import event.EventSupport;
import interfaces.IConnection;
import interfaces.IMsgHandler;
import interfaces.ProtocolType;
import server.IProxyServer;
import server.ProxyServerFactory;
import utils.MsgUtils;

public class ServerObject {

	private IProxyServer server;
	
	public ServerObject(int port) {
		IMsgHandler handler = new ServerMessageHandler();
		server = ProxyServerFactory.createServer(port, handler, ProtocolType.TCP);
	}
	
	private class ServerMessageHandler implements IMsgHandler {

		@Override
		public void handleMsg(String msg, IConnection conn) {
			MActorMessage message = MsgUtils.getAsActorMessage(msg);
			String recvName = message.getReceiver();
			if(recvName.equals("")) {//il messaggio è un evento, manca il nome receiver
				System.out.println("ServerObject | event received " + message.getName() + " " + message.getMsg());
				EventSupport.getInstance().publish(message.getName(), message.getMsg());
			} else {
				MActor recv = MActorContext.getActor(message.getReceiver());
				recv.getMsgStore().storeMsg(message);
			}
			
		}
		
	}
	public void activate() {
		server.activate();
	}
	public void deactivate() {
		server.deactivate();
	}
}
