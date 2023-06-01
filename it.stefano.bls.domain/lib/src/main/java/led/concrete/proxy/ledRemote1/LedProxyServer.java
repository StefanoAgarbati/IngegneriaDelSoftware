package led.concrete.proxy.ledRemote1;

import interf.ILedDevice;

public class LedProxyServer {

	private ILedDevice ledDevice;
	private TcpServer server;
	
	public LedProxyServer(ILedDevice led, int port) {
		this.ledDevice = led;
		IMsgHandler ledMsgHandler = new LedMsgHandler(led);
		server = new TcpServer(port, ledMsgHandler);
	}
	public void activate() {
		server.start();
	}
	public void deactivate() {
		server.deactivate();
	}
	
}
