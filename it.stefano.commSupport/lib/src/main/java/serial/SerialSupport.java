package serial;

public abstract class SerialSupport implements ISerialSupport {

	private ISenderObject sender;
	private IReceiverObject receiver;
	private ISerialPort port;
	
	public SerialSupport(String portName, int speed) {
		port = createSerialPort(portName, speed);
	}
	
	protected abstract ISerialPort createSerialPort(String portName, int speed);

	public ISenderObject getSender() {
		if(sender == null) {
			sender = new SenderObject(port);
		}
		return sender;
	}
	public IReceiverObject getReceiver() {
		if(receiver == null) {
			receiver = new ReceiverObject(port);
		}
		return receiver;
	}
}
