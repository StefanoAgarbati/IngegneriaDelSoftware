package interfaces;

public interface IConnection {
	void sendMsg(String msg);
	String receiveMsg();
}
