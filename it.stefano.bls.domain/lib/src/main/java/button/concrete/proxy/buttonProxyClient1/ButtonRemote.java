package button.concrete.proxy.buttonProxyClient1;

import button.ButtonFactory;
import client.IProxyClient;
import client.ProxyClientFactory;
import interf.IButtonDevice;
import interfaces.ProtocolType;
import observable.GenericObserver;

public class ButtonRemote extends GenericObserver {
	
	private IProxyClient proxyClient;
	private IButtonDevice device;
	
	public ButtonRemote(String host, int port, ProtocolType protocol) {
//		device = ButtonFactory.createButtonDevice()
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
