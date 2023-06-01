package server;

import interfaces.IMsgHandler;
import interfaces.ProtocolType;
import tcp.TcpServer;
import udp.UdpServer;

public class ProxyServerFactory {

	public static IProxyServer createServer(int port, IMsgHandler handler, ProtocolType protocol) {
		switch(protocol) {
		case TCP:
			System.out.println("ProxyServerFactory | creating tcp proxy server on port " + port);
			return new TcpServer(port, handler);
		case UDP:
			return new UdpServer(port, handler);
		}
		return new TcpServer(port, handler);
	}
	
}
