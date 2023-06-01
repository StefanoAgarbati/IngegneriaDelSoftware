package led.concrete;

import interfaces.IConnection;
import serial.ISerialSupport;
import serial.SerialPortConnection;
import serial.SerialSupportFactory;

public class SerialLed extends LedDevice {

	private IConnection serialConn;
	
	public SerialLed(String port) {
		this(port, 115200);
	}
	public SerialLed(String port, int speed) {
		serialConn = createConnection(port, speed);
	}
	private IConnection createConnection(String port, int speed) {
		ISerialSupport support = SerialSupportFactory.create(port, speed);
		IConnection conn = new SerialPortConnection(support);
		return conn;
	}
	@Override
	protected void doOn() {
		send("on");
	}

	@Override
	protected void doOff() {
		send("off");
	}
	private void send(String msg) {
		System.out.println("SerialLed | sending " + msg);
		serialConn.sendMsg(msg);
	}

}
