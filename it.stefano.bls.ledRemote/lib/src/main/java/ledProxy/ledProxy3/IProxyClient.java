package ledProxy.ledProxy3;

public interface IProxyClient {

	void sendMsg(String msg);
	
	String receiveMsg();
	
}
