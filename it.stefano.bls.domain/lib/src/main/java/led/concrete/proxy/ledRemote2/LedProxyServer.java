package led.concrete.proxy.ledRemote2;

import interf.ILedDevice;
import interfaces.IMsgHandler;
import interfaces.ProtocolType;
import led.LedFactory;
import led.concrete.LedGui;
import server.IProxyServer;
import server.ProxyServerFactory;

public class LedProxyServer {

	private ILedDevice ledDevice;
	private IProxyServer server;
	private ProtocolType protocol;
	
	public LedProxyServer(ILedDevice led, int port, ProtocolType protocol) {
		System.out.println("LedProxyServer | creating");
		this.ledDevice = led;
		IMsgHandler ledMsgHandler = new LedMsgHandler(led);
		server = ProxyServerFactory.createServer(port, ledMsgHandler, protocol);
		System.out.println("LedProxyServer | created on port " + port);
	}
	public void activate() {
		server.activate();
		System.out.println("LedProxyServer | activated");
	}
	public void deactivate() {
		server.deactivate();
	}
	
	public static void main(String[] args) throws Exception {
		ILedDevice dev = new LedGui();
		LedProxyServer ledServer = new LedProxyServer(dev,8085,ProtocolType.TCP);
		ledServer.activate();
		ILedDevice led = LedFactory.createLedProxyClient("localhost", 8085, ProtocolType.TCP);
		for(int i = 0; i < 10; i++) {
			led.on();
			Thread.sleep(500);
			led.off();
			Thread.sleep(500);
		}
	}
	
}
