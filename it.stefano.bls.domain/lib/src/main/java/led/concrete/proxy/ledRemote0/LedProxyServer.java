package led.concrete.proxy.ledRemote0;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import interf.ILedDevice;
import interfaces.IConnection;
import led.concrete.proxy.ledProxy0.LedMsg;
import tcp.TcpConnection;

public class LedProxyServer extends Thread {

	private ILedDevice ledDevice;
	private ServerSocket server;
	private boolean isRunning = false;
	
	public LedProxyServer(ILedDevice led, int port) {
		try {
			this.ledDevice = led;
			server = new ServerSocket(port);
		} catch (IOException e) {
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
		try {
			isRunning = false;
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		try {
			doServerJob();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void doServerJob() throws Exception {
		while(isRunning) {
			Socket socket = acceptAConnection();
			IConnection conn = new TcpConnection(socket);
			handleConnection(conn);
		}
	}
	private void handleConnection(IConnection conn) {
		new Thread(() -> {
			try {
				while(true) {
					String msg = conn.receiveMsg();
					elabMsg(msg);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}).start();
	}
	private void elabMsg(String msg) {
		if(msg.equals(LedMsg.on))
			turnLedOn();
		else if(msg.equals(LedMsg.off))
			turnOffLed();
	}
	private void turnOffLed() {
		this.ledDevice.off();
	}
	private void turnLedOn() {
		ledDevice.on();
	}
	private Socket acceptAConnection() throws Exception {
		return this.server.accept();
	}
	
	
}
