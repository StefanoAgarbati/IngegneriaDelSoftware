package client;

import interfaces.ProtocolType;
import tcp.TcpClient;
import udp.UdpClient;

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
