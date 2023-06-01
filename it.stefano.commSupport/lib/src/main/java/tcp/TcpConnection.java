package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import interfaces.IConnection;

public class TcpConnection implements IConnection {
	private Socket socket;
	private OutputStream out;
	private BufferedReader in;
	
	public TcpConnection(Socket socket) {
		try {
			this.socket = socket;
			out = socket.getOutputStream();
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch(Exception e) {

		}
	}
	
	public void sendMsg(String msg) {
		try {
			msg = msg + "\n";
			out.write(msg.getBytes());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String receiveMsg() {
		try {
			String msg = in.readLine();
			return msg;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
