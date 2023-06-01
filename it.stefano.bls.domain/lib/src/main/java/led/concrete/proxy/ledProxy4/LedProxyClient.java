package led.concrete.proxy.ledProxy4;

import client.IProxyClient;
import client.ProxyClientFactory;
import interfaces.ProtocolType;
import led.concrete.LedDevice;
import led.concrete.proxy.ledProxy0.LedMsg;


public class LedProxyClient extends LedDevice {

	private IProxyClient client;
	
	public LedProxyClient(String host, int port, ProtocolType protocol) {
		try {
			initClient(host, port, protocol);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	@Override
	protected void doOn() {
		sendMsg(LedMsg.on);
	}

	private void sendMsg(String msg) {
		client.sendMsg(msg);
	}
	@Override
	protected void doOff() {
		sendMsg(LedMsg.off);
	}
	
	private void initClient(String host, int port, ProtocolType protocol) {
		client = ProxyClientFactory.createClient(host, port, protocol);
	}

}
