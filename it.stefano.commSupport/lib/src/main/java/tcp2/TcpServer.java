package tcp2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import interfaces.IConnection;
import interfaces.IMsgHandler;
import server.ConnectionHandler;
import server.IProxyServer;
import server.IServer;
import tcp.TcpConnection;

public class TcpServer extends Thread implements IProxyServer {
	private ServerSocket server;
	private IMsgHandler msgHandler;
	private boolean isActive = false;
	
	public TcpServer(int port, IMsgHandler handler) {
		server = createServer(port);
		this.msgHandler = handler;
		
	}
	
	private ServerSocket createServer(int port) {
		try {
			return new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void run() {
		while(isActive) {
			IConnection conn = acceptConnection(); //blocking call
			ConnectionHandler handler = new ConnectionHandler(conn, msgHandler);
		}
	}
	
	private IConnection acceptConnection() {
		try {
			Socket s = server.accept();
			TcpConnection conn = new TcpConnection(s);
			return conn;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void activate() {
		if(isActive)
			return;
		isActive = true;
		super.start();
	}
	
	@Override
	public void deactivate() {
		isActive = false;
	}
}
