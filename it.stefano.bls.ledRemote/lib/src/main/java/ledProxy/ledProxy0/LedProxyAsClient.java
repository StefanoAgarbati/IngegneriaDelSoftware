package ledProxy.ledProxy0;

import java.io.OutputStream;
import java.net.Socket;

import led.concrete.LedDevice;
import led.concrete.proxy.ledProxy0.LedMsg;

/*
 * Protocol dependent. 
 */
public class LedProxyAsClient extends LedDevice {
	
	private Socket socket;
	private OutputStream out;
	
	public LedProxyAsClient(String host, int port) {
		try {
			socket = new Socket(host, port);
			out = socket.getOutputStream();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	@Override
	protected void doOn() {
		sendMsg(LedMsg.on);
	}

	@Override
	protected void doOff() {
		sendMsg(LedMsg.off);
	}

	private void sendMsg(String msg) {
		try {
			out.write((msg + "\n").getBytes());
			out.flush();
		} catch (Exception e) {
			
		}
	}

}
