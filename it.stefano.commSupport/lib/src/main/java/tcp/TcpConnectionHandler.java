package tcp;

import interfaces.IMsgHandler;

public class TcpConnectionHandler extends Thread {

	private TcpConnection conn;
	private IMsgHandler handler;
	
	public TcpConnectionHandler(TcpConnection conn, IMsgHandler handler) {
		super();
		this.conn = conn;
		this.handler = handler;
		start();
	}

	public void run() {
		while(true) {
			String msg = receiveAMsg();
			elab(msg);
		}
	}

	private void elab(String msg) {
		handler.handleMsg(msg, conn);
	}

	private String receiveAMsg() {
		return conn.receiveMsg();
	}
}
