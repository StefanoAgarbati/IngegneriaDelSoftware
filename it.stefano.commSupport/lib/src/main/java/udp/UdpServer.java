package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import interfaces.IMsgHandler;
import server.IProxyServer;

public class UdpServer extends Thread implements IProxyServer {
	
	private int port;
	private DatagramSocket socket;
	private DatagramPacket lastPacket;
	private static final int BUF_SIZE = 65536;
	private boolean isActive = false;
	private IMsgHandler msgHandler;
	private IMsgStore<UdpMessage> msgStore = new MsgStore<>();
	private UdpConnectionHandler connHandler;
	
	public UdpServer(int port, IMsgHandler msgHandler) {
		this.port = port;
		this.msgHandler = msgHandler;
		try {
			this.socket = new DatagramSocket(this.port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		connHandler = new UdpConnectionHandler(msgStore, msgHandler);
		System.out.println("UdpServer | created on port " + port);
	}
	public void activate() {
		if(isActive)
			return;
		isActive = true;
		this.start();
		connHandler.activate();
	}
	public void deactivate() {
		isActive = false;
		connHandler.deactivate();
		socket.close();
	}
	public void run() {
		doServerJob();
	}
	public void doServerJob() {
		System.out.println("UdpServer | doServerJob starting");
		while(isActive) {
			String msg = receiveMsg();
			System.out.println("UdpServer | message received " + msg);
			storeMsg(new UdpMessage(lastPacket.getAddress().getHostAddress(), lastPacket.getPort(), msg));
		}
	}
	private void storeMsg(UdpMessage udpMessage) {
		msgStore.put(udpMessage);
	}
	private void elabMsg(String msg) {
		
	}
	public String receiveMsg() {
		try {
			byte[] buffer = new byte[BUF_SIZE];
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			socket.receive(packet);
			lastPacket = packet;
			String msg = new String(packet.getData(), 0, packet.getLength());
			return msg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
