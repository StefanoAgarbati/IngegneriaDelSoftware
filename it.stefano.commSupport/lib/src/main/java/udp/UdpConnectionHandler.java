package udp;

import java.net.DatagramSocket;
import java.net.SocketException;

import interfaces.IMsgHandler;

public class UdpConnectionHandler extends Thread {

	private IMsgStore<UdpMessage> msgStore;
	private boolean isRunning = false;
	private UdpConnection conn;
	private IMsgHandler handler;
	private DatagramSocket socket;
	
	public UdpConnectionHandler(IMsgStore<UdpMessage> msgStore, IMsgHandler handler) {
		this.msgStore = msgStore;
		this.handler = handler;
		try {
			socket = new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	public void activate() {
		if(isRunning)
			return;
		isRunning = true;
		super.start();
	}
	public void deactivate() {
		isRunning = false;
		msgStore.put(new UdpMessage("",0,"bye"));
		socket.close();
	}
	public void run() {
		doJob();
	}
	
	private void doJob() {
		System.out.println("UdpConnectionHandler | doJob starting");
		while(isRunning) {
			UdpMessage msg = msgStore.take();
			System.out.println("UdpConnectionHandler | message taken from store " + msg.getMsg());
			elabMsg(msg);
		}
	}

	private void elabMsg(UdpMessage msg) {
		conn = new UdpConnection(socket, msg.getHost(), msg.getPort());
		handler.handleMsg(msg.getMsg(), conn);
	}
}
