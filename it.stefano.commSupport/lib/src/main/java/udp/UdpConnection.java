package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import interfaces.IConnection;

public class UdpConnection implements IConnection {

	private String host;
	private int port;
	private DatagramSocket socket;
	private static final int BUF_SIZE = 65536;
	
	public UdpConnection(DatagramSocket socket, String host, int port) {
		this.host = host;
		this.port = port;
		this.socket = socket;
	}
	
	public void sendMsg(String msg) {
		try {
			byte[] buffer = (msg + "\n").getBytes();
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
