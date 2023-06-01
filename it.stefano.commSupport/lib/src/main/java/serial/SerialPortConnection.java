package serial;

import interfaces.IConnection;

public class SerialPortConnection implements IConnection {

	private ISenderObject sender;
	private IReceiverObject receiver;
	
	public SerialPortConnection(ISerialSupport support) {
		this.sender = support.getSender();
		this.receiver = support.getReceiver();
	}
	@Override
	public void sendMsg(String msg) {
		sender.sendMsg(msg);
	}

	@Override
	public String receiveMsg() {
		return receiver.receiveMsg();
	}

	
}
