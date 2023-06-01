package ledProxyRemote.ledRemote1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import interfaces.IConnection;
import led.concrete.proxy.ledRemote1.IMsgHandler;
import tcp.TcpConnection;

public class TcpServer extends Thread {

	private ServerSocket server;
	private boolean isRunning = false;
	private IMsgHandler msgHandler;
	
	public TcpServer(int port, IMsgHandler msgHandler) {
		try {
			this.msgHandler = msgHandler;
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
	private Socket acceptAConnection() throws Exception {
		return server.accept();
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
	}
}
