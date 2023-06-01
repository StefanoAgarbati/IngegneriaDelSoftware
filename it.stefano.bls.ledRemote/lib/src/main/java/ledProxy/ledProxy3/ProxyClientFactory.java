package ledProxy.ledProxy3;

import led.concrete.proxy.ledProxy3.IProxyClient;
import led.concrete.proxy.ledProxy3.ProtocolType;
import led.concrete.proxy.ledProxy3.TcpClient;
import led.concrete.proxy.ledProxy3.UdpClient;

public class ProxyClientFactory {

	public static IProxyClient createClient(String host, int port, ProtocolType protocol) {
		switch(protocol) {
		case TCP:
			return new TcpClient(host, port);
		case UDP:
			return new UdpClient(host, port);
		}
		return new TcpClient(host, port);
	}
}
