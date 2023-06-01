package udp;

import java.net.DatagramSocket;
import java.net.SocketException;

import client.IProxyClient;

public class UdpClient implements IProxyClient {

	private String host;
	private int port;
	private DatagramSocket socket;
	private UdpConnection conn;
	
	public UdpClient(String host, int port) {
		this.host = host;
		this.port = port;
		try {
			socket = new DatagramSocket();
			conn = new UdpConnection(socket, host, port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMsg(String msg) {
		conn.sendMsg(msg);
		System.out.println("UdpClient | message sent " + msg);
	}
	public String receiveMsg() {
		return conn.receiveMsg();
	}
	
}
