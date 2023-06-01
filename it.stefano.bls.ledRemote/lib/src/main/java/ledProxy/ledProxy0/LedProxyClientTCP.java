package ledProxy.ledProxy0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import led.concrete.LedDevice;
import led.concrete.proxy.ledProxy0.LedProxyClient;

public class LedProxyClientTCP extends LedProxyClient {
	
	private Socket socket;
	private BufferedReader in;
	private BufferedWriter out;
	
	public LedProxyClientTCP(String host, int port) {
		try {
			socket = new Socket(host, port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void sendMsg(String msg) {
		try {
			out.write(msg+"\n");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
