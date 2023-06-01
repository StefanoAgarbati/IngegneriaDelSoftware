package client;

public interface IProxyClient {

	void sendMsg(String msg);
	
	String receiveMsg();
	
}
