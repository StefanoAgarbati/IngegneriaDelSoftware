package ledProxy.ledProxy0;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import led.concrete.proxy.ledProxy0.LedProxyClient;

public class LedProxyClientUDP extends LedProxyClient {

	private DatagramSocket socket;
	private String host;
	private int port;
	
	public LedProxyClientUDP(String host, int port) {
		try {
			this.host = host;
			this.port = port;
			socket = new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	protected void sendMsg(String msg) {
		try {
			byte[] buffer = (msg + "\n").getBytes();
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(host), port);
			socket.send(packet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
