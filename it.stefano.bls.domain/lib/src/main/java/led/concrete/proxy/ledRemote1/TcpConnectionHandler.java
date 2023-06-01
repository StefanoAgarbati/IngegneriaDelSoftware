package led.concrete.proxy.ledRemote1;

import interfaces.IConnection;

public class TcpConnectionHandler extends Thread {

	private IMsgHandler handler;
	private IConnection conn;
	
	public TcpConnectionHandler(IConnection conn, IMsgHandler msgHandler) {
		this.handler = msgHandler;
		this.conn = conn;
	}
	
	public void run() {
		while(true) {
			String msg = conn.receiveMsg();
			elabMsg(msg, conn);
		}
	}

	private void elabMsg(String msg, IConnection conn) {
		this.handler.handleMsg(msg, conn);
	}
}
