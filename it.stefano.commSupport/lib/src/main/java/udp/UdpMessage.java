package udp;

public class UdpMessage {

	private String host;
	private int port;
	private String msg;
	
	public UdpMessage(String host, int port, String msg) {
		super();
		this.host = host;
		this.port = port;
		this.msg = msg;
	}

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public String getMsg() {
		return msg;
	}
	
	
	
	
}
