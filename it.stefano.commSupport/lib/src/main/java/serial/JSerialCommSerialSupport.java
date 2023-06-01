package serial;

public class JSerialCommSerialSupport extends SerialSupport implements ISerialSupport {
	
	public JSerialCommSerialSupport(String portName, int speed) {
		super(portName, speed);
	}

	@Override
	protected ISerialPort createSerialPort(String portName, int speed) {
		return new JSerialCommSerialPort(portName, speed);
	}
}
