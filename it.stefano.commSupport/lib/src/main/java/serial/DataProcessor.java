package serial;

public class DataProcessor implements IDataProcessor {

	private Thread myself;
	private IDataStore<Byte> dataStore;
	private IDataStore<String> msgStore;
	
	public DataProcessor(IDataStore<Byte> dataStore, IDataStore<String> msgStore) {
		this.dataStore = dataStore;
		this.msgStore = msgStore;
		myself = new Thread(() -> doJob());
	}
	@Override
	public void activate() {
		myself.start();
	}
	
	private void doJob() {
		while(true) {
			String msg = "";
			while(true) {
				byte data = getData();
				if((char)data == '\n')
					break;
				if((char)data != '\r')
					msg = msg + (char)data;
			}
			if(!msg.equals(""))
				storeMsg(msg);
			
		}
	}
	private void storeMsg(String msg) {
		msgStore.addData(msg);
	}
	private byte getData() {
		return dataStore.getData();
	}
	
}
