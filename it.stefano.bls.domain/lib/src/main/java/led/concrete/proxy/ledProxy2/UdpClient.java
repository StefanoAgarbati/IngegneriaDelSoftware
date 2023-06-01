package led.concrete.proxy.ledProxy2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpClient {

	private static final int BUF_SIZE = 65536;
	private DatagramSocket socket;
	private String host;
	private int port;
	
	public UdpClient(String host, int port) {
		try {
			this.host = host;
			this.port = port;
			socket = new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	public void sendMsg(String msg) {
		try {
			byte[] buffer = new byte[BUF_SIZE];
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(host), port);
			socket.send(packet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String receiveMsg() {
		try {
			byte[] buffer = new byte[BUF_SIZE];
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			socket.receive(packet);
			String msg = new String(packet.getData(), 0, packet.getLength());
			return msg;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
