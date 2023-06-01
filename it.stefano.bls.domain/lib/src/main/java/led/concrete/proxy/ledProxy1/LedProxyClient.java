package led.concrete.proxy.ledProxy1;

import led.concrete.LedDevice;
import led.concrete.proxy.ledProxy0.LedMsg;


public class LedProxyClient extends LedDevice {

	private TcpClient client;
	
	public LedProxyClient(String host, int port) {
		try {
			client = new TcpClient(host, port);
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

}
