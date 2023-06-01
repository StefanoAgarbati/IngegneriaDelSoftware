package serial;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

import interfaces.IConnection;

public class SerialSupport2 extends Thread implements IConnection {

	private SerialPort port;
	private static String commPort = "COM3";
	private BlockingQueue<Byte> datas = new LinkedBlockingQueue<>();
	
	public SerialSupport2(String portName) {
		this(portName, 115200);
	}
	public SerialSupport2(String portName, int speed) {
		port = SerialPort.getCommPort(portName);
		configurePort(speed, 8, 1, 0);
		openPort();
		start();
		//activateReceiver();
	}
	
	private void configurePort(int baud, int databits, int stopbits, int parity) {
		port.setComPortParameters(baud, databits, stopbits, parity);
	}

	private void openPort() {
		port.openPort();
		System.out.println("Serial port opened " + port.isOpen());
		waitFor(3000);
	}
	public void run() {
		port.addDataListener(new SerialPortListener());
		doJob2();
	}
//	private void activateReceiver() {
//		new Thread(() -> doReceiveMsg()).start();
//	}
	
	@Override
	public void sendMsg(String msg) {
		String toSend = msg + "\n";
		port.writeBytes(toSend.getBytes(), toSend.length());
	}
	
//	private void doReceiveMsg() {
//		while(true) {
//			String msg = receiveMsg();
//			System.out.println("Message " + msg);
//		}
//	}

	private void receive() {
		byte[] data = new byte[65536];
		int reads = port.readBytes(data, 65536);
		System.out.println("reads " + reads);
		for(int i = 0; i < reads; i++) {
			addData(data[i]);
		}
	}
	private void addData(byte data) {
		try {
			datas.put(data);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private byte getData() {
		try {
			return datas.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public String receiveMsg() {
		try {
			String msg = readMsgFromQueue();
			return msg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private String readMsgFromQueue() {
		String msg = "";
		while(true) {
			byte data = getData();
			if(data != '\r' && data != '\n')
				msg = msg + (char)data;
			if(data == '\n')
				break;
		}
		return msg;
	}
	private void doJob2() {
		
	}
	private void doJob() {
		while(true) {
			receive();
			//System.out.println("Message received");
			waitFor(200);
		}
	}
	private void waitFor(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private class SerialPortListener implements SerialPortDataListener {

		@Override
		public int getListeningEvents() {
			return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
		}

		@Override
		public void serialEvent(SerialPortEvent ev) {
			byte[] data = ev.getReceivedData();
			for(int i = 0; i < data.length; i++) {
				addData(data[i]);
			}
		}
		
	}
	public static void main(String[] args) {
		
	}

}
