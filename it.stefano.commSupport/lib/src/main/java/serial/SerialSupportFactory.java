package serial;

public class SerialSupportFactory {

	public static ISerialSupport create(String portName, int speed) {
		return createJSerialCommSerialSupport(portName, speed);
	}

	private static ISerialSupport createJSerialCommSerialSupport(String portName, int speed) {
		return new JSerialCommSerialSupport(portName, speed);
	}
}
