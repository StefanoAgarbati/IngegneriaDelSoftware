package tcp;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import client.IProxyClient;

public class TcpClient implements IProxyClient {
	
	private TcpConnection conn;
	
	public static TcpClient createClient(String host, int port) {
		return new TcpClient(host, port);
	}
	
//	public TcpClient(String host, int port) {
//		try {
//				System.out.println("tcpClient | try connection");
//				Socket s = new Socket(host, port);
//				conn = new TcpConnection(s);
//		} catch (UnknownHostException e) {
//			System.out.println("hostException");
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.out.println("IOException");
//		}
//	}
	
	public TcpClient(String host, int port) {
		for(;;) {
			try {
				System.out.println("tcpClient | try connection");
				Socket s = new Socket(host, port);
				conn = new TcpConnection(s);
				break;
			} catch (UnknownHostException e) {
				System.out.println("hostException");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("IOException");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	public void sendMsg(String msg) {
		conn.sendMsg(msg);
	}
	public String receiveMsg() {
		return conn.receiveMsg();
	}
}

