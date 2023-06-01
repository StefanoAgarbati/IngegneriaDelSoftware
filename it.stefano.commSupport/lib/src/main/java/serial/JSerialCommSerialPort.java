package serial;

import java.util.Arrays;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

public class JSerialCommSerialPort extends DataSourceObservable implements ISerialPort {

	private SerialPort port;
	
	public JSerialCommSerialPort(String portName, int speed) {
		try {
			init(portName, speed);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void sendData(byte[] data) {
		port.writeBytes(data, data.length);
	}

	@Override
	public byte[] receiveData() {
		byte[] buffer = new byte[65536];
		int reads = port.readBytes(buffer, 65536);
		byte[] data = new byte[reads];
		for(int i = 0; i < reads; i++) {
			data[i] = buffer[i];
		}
		return data;
	}
	
	private void init(String portName, int speed) throws Exception {
		port = createPort(portName);
		if(port == null)
			throw new Exception("No port with name " + portName + " found");
		configurePort(speed, 8, 1, 0);
		registerListener(port);
		openPort();
	}
	private void registerListener(SerialPort port) {
		port.addDataListener(new SerialPortListener());
	}
	private void openPort() {
		port.openPort();
		System.out.println("Serial port opened " + port.isOpen());
		waitFor(4000);
	}
	private void waitFor(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void configurePort(int baud, int dataBits, int stopBits, int parity) {
		port.setComPortParameters(baud, dataBits, stopBits, parity);
	}
	private SerialPort createPort(String portName) {
		SerialPort[] ports = SerialPort.getCommPorts();
		for(SerialPort p : ports) {
			if(p.getSystemPortName().equals(portName))
				return SerialPort.getCommPort(portName);
		}
		return null;
	}
	
	private class SerialPortListener implements SerialPortDataListener {

		@Override
		public int getListeningEvents() {
			return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
		}

		@Override
		public void serialEvent(SerialPortEvent ev) {
			byte[] data = ev.getReceivedData();
			//System.out.println("JSerialCommSerialSupport | data received " + Arrays.toString(data));
			setData(data);
		}
		
	}

}
