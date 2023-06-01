package tcp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClientSupport {

	private Socket socket;
	private BufferedReader in;
	private OutputStream out;
	
	public TcpClientSupport(String host, int port) {
		try {
			socket = new Socket(host, port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = socket.getOutputStream();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void sendMsg(String msg) {
		try {
			String toSend = msg + "\n";
			out.write(toSend.getBytes());
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
