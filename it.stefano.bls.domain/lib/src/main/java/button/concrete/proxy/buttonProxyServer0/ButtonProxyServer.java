package button.concrete.proxy.buttonProxyServer0;

import button.concrete.ButtonDevice;
import button.concrete.proxy.ButtonMsg;
import interfaces.IConnection;
import interfaces.IMsgHandler;
import interfaces.ProtocolType;
import server.IProxyServer;
import server.ProxyServerFactory;

public class ButtonProxyServer extends ButtonDevice {
	
	private IProxyServer server;
	private ProtocolType protocol;
	
	public ButtonProxyServer(int port, ProtocolType protocol) {
		IMsgHandler buttonMsgHandler = new ButtonMsgHandler();
		server = ProxyServerFactory.createServer(port, buttonMsgHandler, protocol);
		server.activate();
	}
	
	private class ButtonMsgHandler implements IMsgHandler {

		@Override
		public void handleMsg(String msg, IConnection conn) {
			if(msg.equals(ButtonMsg.pressed))
				setState(true);
			else if(msg.equals(ButtonMsg.released))
				setState(false);
		}
		
	}
}
