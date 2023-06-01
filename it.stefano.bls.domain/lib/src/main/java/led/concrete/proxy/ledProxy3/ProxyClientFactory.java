package led.concrete.proxy.ledProxy3;

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
