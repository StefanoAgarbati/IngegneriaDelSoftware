package ledProxy.ledProxy2;

import led.concrete.LedDevice;
import led.concrete.proxy.ledProxy0.LedMsg;
import led.concrete.proxy.ledProxy2.ProtocolType;
import led.concrete.proxy.ledProxy2.TcpClient;
import led.concrete.proxy.ledProxy2.UdpClient;


public class LedProxyClient extends LedDevice {

	private TcpClient tcpClient;
	private UdpClient udpClient;
	private ProtocolType protocol;
	
	public LedProxyClient(String host, int port, ProtocolType protocol) {
		try {
			this.protocol = protocol;
			initClient(host, port);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	@Override
	protected void doOn() {
		sendMsg(LedMsg.on);
	}

	private void sendMsg(String msg) {
		switch(protocol) {
		case TCP:
			sendMsgTcp(msg);
			break;
		case UDP:
			sendMsgUdp(msg);
			break;
		}
	}
	@Override
	protected void doOff() {
		sendMsg(LedMsg.off);
	}
	
	private void initClient(String host, int port) {
		switch(protocol) {
		case TCP:
			tcpClient = new TcpClient(host, port);
			break;
		case UDP:
			udpClient = new UdpClient(host, port);
			break;
		}
	}
	
	private void sendMsgTcp(String msg) {
		tcpClient.sendMsg(msg);
	}
	private void sendMsgUdp(String msg) {
		udpClient.sendMsg(msg);
	}

}
