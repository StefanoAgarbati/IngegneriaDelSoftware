package blSystem;

import client.IProxyClient;
import client.ProxyClientFactory;
import interfaces.ProtocolType;

public class TestLedActorRemote {

	public static void main(String[] args) {
		IProxyClient client = ProxyClientFactory.createClient("localhost", 8084, ProtocolType.TCP);
		String onMsg = "{\"name\":\"on\",\"sender\":\"client\",\"receiver\":\"led\",\"msg\":\"on\"}";
	}
}
