package button.concrete.proxy.buttonProxyClient0;

import client.IProxyClient;
import client.ProxyClientFactory;
import interfaces.ProtocolType;
import observable.GenericObserver;

public class ButtonProxyClient extends GenericObserver {
	
	private IProxyClient proxyClient;
	
	public ButtonProxyClient(String host, int port, ProtocolType protocol) {
		proxyClient = ProxyClientFactory.createClient(host, port, protocol);
	}
	
	@Override
	public void update(String data) {
		send(data);
	}
	
	private void send(String msg) {
		proxyClient.sendMsg(msg);
	}

}
