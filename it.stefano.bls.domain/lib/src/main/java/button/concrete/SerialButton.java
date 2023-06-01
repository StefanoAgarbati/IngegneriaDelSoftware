package button.concrete;

import interfaces.IConnection;
import serial.ISerialSupport;
import serial.SerialPortConnection;
import serial.SerialSupportFactory;

public class SerialButton extends ButtonDevice {

	private boolean isActive = false;
	private Thread self;
	private IConnection conn;
	
	public SerialButton(String port) {
		this(port, 115200);
	}
	public SerialButton(String port, int speed) {
		conn = createConnection(port, speed);
		self = new Thread(() ->doJob());
		activate();
	}
	private IConnection createConnection(String port, int speed) {
		ISerialSupport support = SerialSupportFactory.create(port, speed);
		IConnection conn = new SerialPortConnection(support);
		return conn;
	}
	
	public void activate() {
		if(isActive)
			return;
		isActive = true;
		startJob();
	}

	private void startJob() {
		self.start();
	}
	private void doJob() {
		while(isActive) {
			String msg = receiveMsg();
			handleMsg(msg);
		}
	}
	private void handleMsg(String msg) {
		if(msg.equals("pressed")) {
			setState(true);
			System.out.println("SerialButton | set state true" );
		} else if(msg.equals("released")) {
			setState(false);
			System.out.println("SerialButton | set state false" );
		} else {
			System.out.println("SerialButton | handleMsg ");
		}
	}
	private String receiveMsg() {
		return conn.receiveMsg();
	}
	
	public void deactivate() {
		isActive = false; //??
	}

}
