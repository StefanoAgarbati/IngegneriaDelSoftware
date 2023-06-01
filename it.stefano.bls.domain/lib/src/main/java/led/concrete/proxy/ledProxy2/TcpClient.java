package led.concrete.proxy.ledProxy2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {

	private Socket socket;
	private OutputStream out;
	private BufferedReader in;
	
	public TcpClient(String host, int port) {
		try {
			socket = new Socket(host, port);
			out = socket.getOutputStream();
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	public void sendMsg(String msg) {
		try {
			out.write((msg + "\n").getBytes());
			out.flush();
		} catch (Exception e) {
			
		}
	}
	public String receiveMsg() {
		try {
			String msg = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
