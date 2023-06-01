package ledProxyRemote.ledRemote2;

import interf.ILedDevice;
import interfaces.IMsgHandler;
import interfaces.ProtocolType;
import led.concrete.proxy.ledRemote2.LedMsgHandler;
import server.IProxyServer;
import server.ProxyServerFactory;

public class LedProxyServer {

	private ILedDevice ledDevice;
	private IProxyServer server;
	private ProtocolType protocol;
	
	public LedProxyServer(ILedDevice led, int port, ProtocolType protocol) {
		this.ledDevice = led;
		IMsgHandler ledMsgHandler = new LedMsgHandler(ledDevice);
		server = ProxyServerFactory.createServer(port, ledMsgHandler, protocol);
		System.out.println("LedProxyServer | created");
	}
	public void activate() {
		server.activate();
		System.out.println("LedProxyServer | activated");
	}
	public void deactivate() {
		server.deactivate();
	}
	
}
