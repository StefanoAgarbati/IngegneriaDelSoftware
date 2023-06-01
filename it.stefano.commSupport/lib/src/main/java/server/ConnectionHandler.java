package server;

import interfaces.IConnection;
import interfaces.IMsgHandler;

public class ConnectionHandler extends Thread {

	private IConnection conn;
	private IMsgHandler handler;
	
	public ConnectionHandler(IConnection conn, IMsgHandler handler) {
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
