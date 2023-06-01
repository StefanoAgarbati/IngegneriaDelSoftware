package serial;

public class SenderObject implements ISenderObject {

	private IDataStore<String> msgStore = new DataStore<>();
	private ISerialPort port;
	
	public SenderObject(ISerialPort port) {
		this.port = port;
		startJob();
	}
	
	private void startJob() {
		new Thread(() -> doJob()).start();
	}
	
	@Override
	public void sendMsg(String msg) {
		msgStore.addData(msg);
	}
	
	private void doJob() {
		while(true) {
			String msg = msgStore.getData();
			doSend(msg);
		}
	}
	private void doSend(String msg) {
		port.sendData((msg+"\n").getBytes());
	}

}
